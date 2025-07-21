# Drawable Shapes Processor

This is a simple Java OOP project that demonstrates polymorphism, abstraction, and file handling. It allows processing different drawable shapes like circles and cubes from an input file, calculates their areas, and writes the results to an output file.

## Features

- Object-Oriented Design using inheritance and interfaces
- Polymorphic behavior for drawing shapes
- File input/output handling
- Calculates and displays areas of various shapes
- Total area calculation for all shapes in the file
- Easily extendable to support more shapes

## Project Structure

- `Drawable`: An abstract class representing drawable shapes.
- `Circle`: Inherits from `Drawable` and calculates the area of a circle.
- `Cube`: Inherits from `Drawable` and calculates the surface area of a cube.
- `Main`: Tests the shapes, prints their details, and calculates the total area.

## How to Run

1. **Compile all `.java` files**:
   ```bash
   javac *.java
2. Run the ShapeFileProcessor class (replace input.txt and output.txt with your actual file names):
```bash
java ShapeFileProcessor input.txt output.txt
