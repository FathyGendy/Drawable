public class Cube extends ThreeDshape {
    private double side;
    
    public Cube() {
        this.side = 0.0;
        super.setColor("Black");
    }
    public Cube(double side) {
        this.side = side;
        super.setColor("Black");
    }
    public Cube(String color,double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public double getArea(){
        return 6 * this.side * this.side;
    }
    @Override
    public double getPerimeter(){
        return this.side * 12;
    }
    @Override
    public double getVolume(){
        return this.side * this.side * this.side;
    }
    @Override
    public String toString(){
        return "This is a cube with color : " + super.getColor() + " and side : " + this.side;
    }
    @Override
    public String howToDraw() {
        return "Drawing a cube. It's Area is : " + this.getArea();
    }
}