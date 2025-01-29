package Java17;


public sealed abstract class Shape permits Circle, Triangle{
    public abstract double area();
}

final class Circle extends Shape implements Drawable {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }
}

final class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}