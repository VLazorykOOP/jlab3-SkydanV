package project2;

import java.util.Scanner; 

abstract class Figure3D {

    public abstract double surfaceArea();
    public abstract double volume();
}

class Cube extends Figure3D {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double surfaceArea() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

class Sphere extends Figure3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}

class Cone extends Figure3D {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight); 
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height; 
    }
}

class Cylinder extends Figure3D {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height); 
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }
}

class TriangularPyramid extends Figure3D {
    private double baseArea; 
    private double height;

    public TriangularPyramid(double baseArea, double height) {
        this.baseArea = baseArea;
        this.height = height;
    }

    @Override
    public double surfaceArea() {
        return baseArea + 3 * Math.sqrt((baseArea * 4) / Math.sqrt(3));
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * baseArea * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть фігуру:");
        System.out.println("1. Куб");
        System.out.println("2. Сфера");
        System.out.println("3. Конус");
        System.out.println("4. Циліндр");
        System.out.println("5. Трикутна піраміда");
        int choice = scanner.nextInt();

        Figure3D figure = null;

        switch (choice) {
            case 1:
                System.out.print("Введіть сторону куба: ");
                double side = scanner.nextDouble();
                figure = new Cube(side);
                break;
            case 2:
                System.out.print("Введіть радіус сфери: ");
                double radius = scanner.nextDouble();
                figure = new Sphere(radius);
                break;
            case 3:
                System.out.print("Введіть радіус основи конуса: ");
                double coneRadius = scanner.nextDouble();
                System.out.print("Введіть висоту конуса: ");
                double coneHeight = scanner.nextDouble();
                figure = new Cone(coneRadius, coneHeight);
                break;
            case 4:
                System.out.print("Введіть радіус основи циліндра: ");
                double cylinderRadius = scanner.nextDouble();
                System.out.print("Введіть висоту циліндра: ");
                double cylinderHeight = scanner.nextDouble();
                figure = new Cylinder(cylinderRadius, cylinderHeight);
                break;
            case 5:
                System.out.print("Введіть площу основи трикутної піраміди: ");
                double baseArea = scanner.nextDouble();
                System.out.print("Введіть висоту трикутної піраміди: ");
                double pyramidHeight = scanner.nextDouble();
                figure = new TriangularPyramid(baseArea, pyramidHeight);
                break;
            default:
                System.out.println("Невірний вибір!");
                return;
        }
        System.out.printf("Площа поверхні: %.2f\n", figure.surfaceArea());
        System.out.printf("Об'єм: %.2f\n", figure.volume());

        scanner.close();
    }
}
