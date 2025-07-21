import java.io.*;
public class ShapeFileProcessor {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("To run the code input should be <input file path> <output file path>");
            return;
        }
        
        String inputFile = args[0];
        String outputFile = args[1];
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line = reader.readLine();
            if (line == null) {
                writer.write("Input file is empty, the file should contain the shapes with dimension.");
                return;
            }

            String[] inputs = line.split(" ");
            
            if (inputs.length < 2) {
                writer.write("Input should be : (Array_Size) (Shape) (Dimension) ...");
                return;
            }

            int arraySize = Integer.parseInt(inputs[0]);
            if (arraySize < 2) {
                writer.write("The minimum size of Array is 2");
                return;
            }

            if (inputs.length < 1 + arraySize * 2) {
                writer.write("Not enough shape data provided for the specified array size.\n");
                return;
            }


            Drawable[] drawables = new Drawable[arraySize];
            int index = 0;

            for (int i = 1; i <= arraySize * 2; i += 2) {
                if (index >= arraySize) break;

                String shapeType = inputs[i];
                double value = Double.parseDouble(inputs[i + 1]);

                if (value < 0) {
                    writer.write("Invalid value for " + shapeType + ", value must be positive\n");
                    continue;
                }

                if (shapeType.equalsIgnoreCase("circle")) {
                    drawables[index] = new Circle(value);
                    index++;
                } else if (shapeType.equalsIgnoreCase("cube")) {
                    drawables[index] = new Cube(value);
                    index++;
                } else {
                    writer.write("Invalid shape type: " + shapeType + "\n");
                }
            }

            double totalArea = 0;
            for (Drawable drawable : drawables) {
                if (drawable instanceof Shape) {
                    totalArea += ((Shape) drawable).getArea();
                }
                else 
                    continue;
                writer.write(drawable.howToDraw() + "\n");
                writer.write(drawable.toString() + "\n");
            }

            writer.write("Total area of all shapes: " + totalArea);

        } 
        catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Unexpected error: " + ex.getMessage());
        }
    }
}