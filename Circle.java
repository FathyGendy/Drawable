public class Circle extends Shape {
    private double radius;
    
   public Circle() {
    super("Black");
    this.radius = 0.0;
}

    public Circle(double radius) {
        super.setColor("Black");
        this.radius = radius;
    }
    public Circle(String color,double radius) {
        super(color);
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
    @Override
    public double getPerimeter(){
        return Math.PI * this.radius * 2;
    }
    @Override
    public String toString() {
        return "Circle{ It's color : " + super.getColor() + " radius = " + radius + '}';
    }
    @Override
    public String howToDraw() {
       return "Drawing a circle. It's Area : " + this.getArea();
    }
}