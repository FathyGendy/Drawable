import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(args.length < 2) {
            System.out.println("Input should be : (Array_Size) (Shape) (Dimension) ... ");
            return;
       }
        try {
            int arraySize = Integer.parseInt(args[0]);
              if (arraySize < 2) {
                System.out.println("The minimum size of Array is equal 2");
                return;
            }
              if (args.length < 1 + arraySize * 2) {
                System.out.println("Not enough arguments provided for the specified array size.");
                return;
            }

            Drawable[] drawables = new Drawable[arraySize];
            int index = 0;
           for (int i = 1; i <= arraySize * 2 ; i += 2){
                if(index >= arraySize) break;
                
                 String shapeType = args[i];
                double value = Double.parseDouble(args[i+1]);

                if (shapeType.equalsIgnoreCase("circle")) {
                     if (value < 0) {
                         do{
                             System.out.println("The value should be positive. Please enter a positive integer: ");
                             String newVal = in.next();
                             value = Double.parseDouble(newVal);
                         }while(value < 0);
                      }
                    drawables[index] = new Circle(value);
                    index++;
                }
                else if (shapeType.equalsIgnoreCase("cube")) {
                     if (value < 0) {
                         do{
                             System.out.println("The value should be positive. Please enter a positive integer: ");
                             String newVal = in.next();
                             value = Double.parseDouble(newVal);
                         }while(value < 0);
                     }
                    drawables[index] = new Cube(value);
                    index++;

                }
                else{
                      System.out.println("Sorry, this is invalid shape type " + shapeType);
                 }
            }
            double totalArea = 0;
            for (Drawable drawable : drawables) {
                if(drawable instanceof Shape){
                   totalArea += ((Shape) drawable).getArea();
                }
                else 
                    continue;
                System.out.println(drawable.howToDraw());
                System.out.println(drawable.toString());
            }


            System.out.println("Total area of all shapes: " + totalArea);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number format : " + e.getMessage());
        }
           
        catch (IllegalArgumentException e) {
            System.out.println("Invalid input : " + e.getMessage());
        }
           
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
