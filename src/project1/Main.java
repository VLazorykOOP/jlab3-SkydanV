package project1;

// Суперклас Корабель
class Ship {
    protected String name;
    protected double length;
    protected int capacity;

    public Ship(String name, double length, int capacity) {
        this.name = name;
        this.length = length;
        this.capacity = capacity;
    }

    // Метод для виведення інформації про корабель
    public void Show() {
        System.out.println("Ship Name: " + name + ", Length: " + length + "m, Capacity: " + capacity + " passengers");
    }
}

// Підклас Пароплав
class Steamboat extends Ship {
    private double steamPower;

    public Steamboat(String name, double length, int capacity, double steamPower) {
        super(name, length, capacity);
        this.steamPower = steamPower;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Steam Power: " + steamPower + " kW");
    }
}

// Підклас Вітрильник
class Sailboat extends Ship {
    private int sailArea;

    public Sailboat(String name, double length, int capacity, int sailArea) {
        super(name, length, capacity);
        this.sailArea = sailArea;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Sail Area: " + sailArea + " sqm");
    }
}

// Підклас Корвет
class Corvette extends Ship {
    private int guns;

    public Corvette(String name, double length, int capacity, int guns) {
        super(name, length, capacity);
        this.guns = guns;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Number of Guns: " + guns);
    }
}

public class Main {
    public static void main(String[] args) {
        Ship[] ships = new Ship[3];

        ships[0] = new Steamboat("Titanic", 269, 3000, 1600);
        ships[1] = new Sailboat("Black Pearl", 50, 500, 700);
        ships[2] = new Corvette("Victory", 70, 1000, 100);

        for (Ship ship : ships) {
            ship.Show();
            System.out.println();
        }
    }
}
