package org.tensorflow.lite.examples.detection;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.snakeeyes.R;

import org.tensorflow.lite.examples.detection.customview.OverlayView;
import org.tensorflow.lite.examples.detection.env.ImageUtils;
import org.tensorflow.lite.examples.detection.env.Logger;
import org.tensorflow.lite.examples.detection.env.Utils;
import org.tensorflow.lite.examples.detection.tflite.Classifier;
import org.tensorflow.lite.examples.detection.tflite.YoloV4Classifier;
import org.tensorflow.lite.examples.detection.tracking.MultiBoxTracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final float MINIMUM_CONFIDENCE_TF_OD_API = 0.5f;
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    private Bitmap capturedPhoto;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraButton = findViewById(R.id.realButton);
        detectButton = findViewById(R.id.detectButton);
        captureButton=findViewById(R.id.cameraButton);
        galleryButton=findViewById(R.id.galleryButton);
        imageView = findViewById(R.id.imageView);

        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        cameraButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, org.tensorflow.lite.examples.detection.DetectorActivity.class)));

        captureButton.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v)
            {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }
                else
                {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);


                }
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v)
            {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 250);
            }
        });



        detectButton.setOnClickListener(v -> {
            Handler handler = new Handler();



            this.cropBitmap = Utils.processBitmap(capturedPhoto, TF_OD_API_INPUT_SIZE);

            this.imageView.setImageBitmap(cropBitmap);

            initBox();

            new Thread(() -> {
                final List<Classifier.Recognition> results = detector.recognizeImage(cropBitmap);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        handleResult(cropBitmap, results);
                    }
                });
            }).start();

        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            capturedPhoto = photo;
//            saveToInternalStorage(photo);

        }
        if(resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case 250:
                    Uri selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                        imageView.setImageBitmap(bitmap);
                        capturedPhoto=bitmap;
                    } catch (IOException e) {
                        Log.i("TAG", "Some exception " + e);
                    }
                    break;
            }
    }

    private static final Logger LOGGER = new Logger();

    public static final int TF_OD_API_INPUT_SIZE = 416;

    private static final boolean TF_OD_API_IS_QUANTIZED = false;

    private static final String TF_OD_API_MODEL_FILE = "yolov4-416-fp16.tflite";

    private static final String TF_OD_API_LABELS_FILE = "file:///android_asset/coco.txt";

    // Minimum detection confidence to track a detection.
    private static final boolean MAINTAIN_ASPECT = false;
    private Integer sensorOrientation = 90;

    private Classifier detector;

    private Matrix frameToCropTransform;
    private Matrix cropToFrameTransform;
    private MultiBoxTracker tracker;
    private OverlayView trackingOverlay;

    protected int previewWidth = 0;
    protected int previewHeight = 0;

    private Bitmap sourceBitmap;
    private Bitmap cropBitmap;

    private Button cameraButton, detectButton,captureButton,galleryButton;
    private ImageView imageView;

    private void initBox() {
        previewHeight = TF_OD_API_INPUT_SIZE;
        previewWidth = TF_OD_API_INPUT_SIZE;
        frameToCropTransform =
                ImageUtils.getTransformationMatrix(
                        previewWidth, previewHeight,
                        TF_OD_API_INPUT_SIZE, TF_OD_API_INPUT_SIZE,
                        sensorOrientation, MAINTAIN_ASPECT);

        cropToFrameTransform = new Matrix();
        frameToCropTransform.invert(cropToFrameTransform);

        tracker = new MultiBoxTracker(this);
        trackingOverlay = findViewById(R.id.tracking_overlay);
        trackingOverlay.addCallback(
                canvas -> tracker.draw(canvas));

        tracker.setFrameConfiguration(TF_OD_API_INPUT_SIZE, TF_OD_API_INPUT_SIZE, sensorOrientation);

        try {
            detector =
                    YoloV4Classifier.create(
                            getAssets(),
                            TF_OD_API_MODEL_FILE,
                            TF_OD_API_LABELS_FILE,
                            TF_OD_API_IS_QUANTIZED);
        } catch (final IOException e) {
            e.printStackTrace();
            LOGGER.e(e, "Exception initializing classifier!");
            Toast toast =
                    Toast.makeText(
                            getApplicationContext(), "Classifier could not be initialized", Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    }

    private void handleResult(Bitmap bitmap, List<Classifier.Recognition> results) {
        final Canvas canvas = new Canvas(bitmap);
        final Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);

        final List<Classifier.Recognition> mappedRecognitions =
                new LinkedList<Classifier.Recognition>();

        for (final Classifier.Recognition result : results) {
            final RectF location = result.getLocation();
            if (location != null && result.getConfidence() >= MINIMUM_CONFIDENCE_TF_OD_API) {
                canvas.drawRect(location, paint);
                cropToFrameTransform.mapRect(location);

                result.setLocation(location);
                mappedRecognitions.add(result);
            }
        }

       tracker.trackResults(mappedRecognitions, new Random().nextInt());
        trackingOverlay.postInvalidate();
        imageView.setImageBitmap(bitmap);
    }
}
