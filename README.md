# SnakeEyes

## Overview
SnakeEyes is a collaborative project that utilizes the YOLOv4 model for real-time object detection. The backend is built with TensorFlow in Python, and the frontend is developed using Flutter. The project involves contributions from five developers.

## Features
- Real-time object detection using YOLOv4
- TensorFlow-based backend
- Flutter-based frontend
- High accuracy and performance

## Technologies
- YOLOv4
- TensorFlow
- Python
- Flutter

## Installation
1. Clone the repository:
   git clone https://github.com/acekavi/SnakeEyes.git
   cd SnakeEyes

2. Install backend dependencies:
   pip install -r requirements.txt

3. Install frontend dependencies:
   cd frontend
   flutter pub get

## Usage
### Running the Backend
Navigate to the backend directory and start the server:
   cd backend
   python server.py

### Running the Frontend
Navigate to the frontend directory and start the Flutter application:
   cd frontend
   flutter run

## File Structure
- backend/: Contains the TensorFlow backend code.
  - models/: Pre-trained YOLOv4 models.
  - utils/: Utility scripts for data processing and model evaluation.
  - server.py: Main backend server script.
  - requirements.txt: Python dependencies.
- frontend/: Contains the Flutter frontend code.
  - lib/: Flutter application code.
  - assets/: Images and other static assets.
  - pubspec.yaml: Flutter dependencies.
- README.md: This file.
- CONTRIBUTING.md: Guidelines for contributing to the project.
- LICENSE.md: License information.

## Contributors
- [Avishka](https://github.com/acekavi)
- [Deshal](https://github.com/Deshal-001)
- [Rehan](https://github.com/rehan-fp)
- [Saumya](https://github.com/saumyaakumarasinghe)

## Contributing
Please read CONTRIBUTING.md for details on our code of conduct and the process for submitting pull requests.

## License
This project is licensed under the MIT License - see the LICENSE.md file for details.
EOL
