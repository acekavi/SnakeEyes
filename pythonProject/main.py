import cv2
import numpy as np
import pyttsx3

language = 'en'

net = cv2.dnn.readNet("yolo/custom-yolov4-detector_best.weights", "yolo/custom-yolov4-detector.cfg")

classes = []
with open("yolo/coco.names", "r") as f:
    classes = f.read().splitlines()

img = cv2.imread("yolo/istockphoto-137345149-612x612.jpg")
# yolo/SawScaledViper480_jpg.rf.1135037ffec2550dda11ddc36fedb49a.jpg
# yolo/CommonKrait218_jpg.rf.febd4180eea1389b668faead7199517e.jpg
# yolo/Cobra341_jpg.rf.db10e1088966bda8336e9fb4aff73c78.jpg
# yolo/GreenTreeVine15_jpg.rf.f6c63bfa66ef9dc1e69ae3644cc40e99.jpg
# yolo/IndianRockPython4_jpg.rf.0dd8acf3cbac649abd3011babe1bf1c2.jpg
# yolo/RussellsViper273_jpg.rf.9deac9d2d762d060416dccfd51ec6ac2.jpg
# yolo/RatSnake223_jpg.rf.6e43680a8965ef4a9d3a2f69d68b7914.jpg

#yolo/istockphoto-137345149-612x612.jpg
#yolo/Types-of-Fish-Species-In-World-and-Their-Facts.jpg
#yolo/pexels-photo-2379004.jpeg
#yolo/photo-1604085572504-a392ddf0d86a.jpg
#yolo/1030_LL_trees-1028x579.png
height, width, _ = img.shape

blob = cv2.dnn.blobFromImage(img, 1 / 255, (416, 416), (0, 0, 0), swapRB=True, crop=False)

net.setInput(blob)

output_layers_names = net.getUnconnectedOutLayersNames()
layerOutputs = net.forward(output_layers_names)

class_ids = []
boxes = []
confidences = []

for output in layerOutputs:
    for detection in output:
        scores = detection[5:]
        class_id = np.argmax(scores)
        confidence = scores[class_id]
        if confidence > 0.8:
            center_x = int(detection[0] * width)
            center_y = int(detection[1] * height)

            w = int(detection[2] * width)
            h = int(detection[3] * height)

            x = int(center_x - w / 2)
            y = int(center_y - h / 2)

            boxes.append([x, y, w, h])
            confidences.append(float(confidence))
            class_ids.append(class_id)

print(len(boxes))

indexes = cv2.dnn.NMSBoxes(boxes, confidences, 0.5, 0.4)
font = cv2.FONT_HERSHEY_PLAIN
colors = np.random.uniform(0, 255, size=(len(boxes), 3))
List = []
if len(indexes) > 0:
    for i in indexes.flatten():
        x, y, w, h = boxes[i]
        label = str(classes[class_ids[i]])
        confidence = str(round(confidences[i], 2))
        color = colors[i]
        cv2.rectangle(img, (x, y), (x + w, y + h), color, 2)
        cv2.putText(img, label + " " + confidence, (x, y + 400), font, 2, color, 2)
        engine = pyttsx3.init()
        voices = engine.getProperty("voices")
        engine.setProperty("voices", voices[1].id)
        engine.setProperty("rate", 150)
        engine.say(label + "detected")
        engine.runAndWait()

cv2.imshow("Image", img)
cv2.waitKey(0)
cv2.destroyAllWindows()
