package com.example.snakeeyes

import android.Manifest
import android.content.IntentSender.SendIntentException
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.snakeeyes.databinding.ActivityMaps2Binding
import com.example.snakeeyes.databinding.ActivityMapsBinding
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : FragmentActivity(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private  var mMap: GoogleMap?=null
    var mGoogleApiClient: GoogleApiClient? = null
    var currentLatitude = 0.0
    var currentLongitude = 0.0
    var myLocation: Location? = null
    //private var binding: ActivityMapsBinding? = null
    private  var binding: ActivityMapsBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding!!.root) //getroot ->root

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        setUPGClient()
    }

    private fun setUPGClient() {
        mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, 0, this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build()
        mGoogleApiClient!!.connect()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    override fun onConnected(bundle: Bundle?) {
        checkPermission()
    }

    private fun checkPermission() {
        val permissionLocation = ContextCompat.checkSelfPermission(
            this@MapsActivity,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val listPermission: MutableList<String> = ArrayList()
        if (permissionLocation != PackageManager.PERMISSION_GRANTED) {
            listPermission.add(Manifest.permission.ACCESS_FINE_LOCATION)
            if (!listPermission.isEmpty()) {
                ActivityCompat.requestPermissions(
                    this,
                    listPermission.toTypedArray(), REQUEST_ID_MULTIPLE_PERMISSIONS
                )
            }
        } else {
            getMyLocation()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val permissionLocation =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if (permissionLocation == PackageManager.PERMISSION_GRANTED) {
            getMyLocation()
        } else {
            checkPermission()
        }
    }

    override fun onConnectionSuspended(i: Int) {}
    override fun onConnectionFailed(connectionResult: ConnectionResult) {}
    override fun onLocationChanged(location: Location) {
        myLocation = location
        if (myLocation != null) {
            currentLatitude = location.latitude
            currentLongitude = location.longitude
            val icon = BitmapDescriptorFactory.fromResource(R.drawable.navigation)
            mMap!!.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(
                        currentLatitude,
                        currentLongitude
                    ), 15.0f
                )
            )
            val markerOptions = MarkerOptions()
            markerOptions.position(LatLng(currentLatitude, currentLongitude))
            markerOptions.title("You")
            markerOptions.icon(icon)
            this.mMap!!.addMarker(markerOptions)
            nearByHospitals
        }
    }

    private val nearByHospitals: Unit
        private get() {
            val stringBuilder =
                StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?")
            stringBuilder.append("location=$currentLatitude,$currentLongitude")
            stringBuilder.append("&radius=2500")
            stringBuilder.append("&type=hospital")
            stringBuilder.append("&key=" + resources.getString(R.string.MAPS_API_KEY))
            val url = stringBuilder.toString()
            val dataTransfer = arrayOfNulls<Any>(2)
            dataTransfer[0] = mMap
            dataTransfer[1] = url
            val getNearbyPlacesData = GetNearbyPlacesData()
            getNearbyPlacesData.execute(*dataTransfer)
        }

    private fun getMyLocation() {
        if (mGoogleApiClient != null) {
            if (mGoogleApiClient!!.isConnected) {
                val permissionLocation = ContextCompat.checkSelfPermission(
                    this@MapsActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
                if (permissionLocation == PackageManager.PERMISSION_GRANTED) {
                    myLocation =
                        LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient!!)
                    val locationRequest = LocationRequest()
                    //locationRequest.setInterval(3000);
                    //locationRequest.setFastestInterval(3000);
                    locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                    val builder = LocationSettingsRequest.Builder()
                        .addLocationRequest(locationRequest)
                    builder.setAlwaysShow(true)
                    LocationServices.FusedLocationApi
                        .requestLocationUpdates(mGoogleApiClient!!, locationRequest, this)
                    val result = LocationServices.SettingsApi
                        .checkLocationSettings(mGoogleApiClient!!, builder.build())
                    result.setResultCallback { result ->
                        val status = result.status
                        when (status.statusCode) {
                            LocationSettingsStatusCodes.SUCCESS -> {
                                // All location settings are satisfied.
                                // You can initialize location requests here.
                                val permissionLocation = ContextCompat
                                    .checkSelfPermission(
                                        this@MapsActivity,
                                        Manifest.permission.ACCESS_FINE_LOCATION
                                    )
                                if (permissionLocation == PackageManager.PERMISSION_GRANTED) {
                                    myLocation = LocationServices.FusedLocationApi
                                        .getLastLocation(mGoogleApiClient!!)
                                }
                            }
                            LocationSettingsStatusCodes.RESOLUTION_REQUIRED ->                                     // Location settings are not satisfied.
                                // But could be fixed by showing the user a dialog.
                                try {
                                    // Show the dialog by calling startResolutionForResult(),
                                    // and check the result in onActivityResult().
                                    // Ask to turn on GPS automatically
                                    status.startResolutionForResult(
                                        this@MapsActivity,
                                        REQUEST_CHECK_SETTINGS_GPS
                                    )
                                } catch (e: SendIntentException) {
                                    // Ignore the error.
                                }
                            LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {}
                        }
                    }
                }
            }
        }
    }

    companion object {
        private const val REQUEST_CHECK_SETTINGS_GPS = 0x1
        private const val REQUEST_ID_MULTIPLE_PERMISSIONS = 0x2
    }
}