//Лабораторна робота 2
//Завдання 2

class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Довжина кожної сторони має бути додатньою");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Довжина кожної зі сторін повинна бути додатньою");
        }

        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Triangle) {
            Triangle other = (Triangle) obj;
            return Double.compare(this.sideA, other.sideA) == 0 &&
                    Double.compare(this.sideB, other.sideB) == 0 &&
                    Double.compare(this.sideC, other.sideC) == 0;
        }
        return false;
    }

    public boolean isSimilarTo(Triangle other) {
        double ratioA = this.sideA / other.sideA;
        double ratioB = this.sideB / other.sideB;
        double ratioC = this.sideC / other.sideC;

        return Double.compare(ratioA, ratioB) == 0 && Double.compare(ratioA, ratioC) == 0;
    }

    public String toString() {
        return "Триктник{сторонаA=" + sideA + ", сторонаB=" + sideB + ", сторонаC=" + sideC + "}";
    }
}

public class Lab2_2 {
    public static void main(String[] args) {
        try {
            // Створюємо правильний трикутник
            Triangle t1 = new Triangle(3, 4, 5);
            System.out.println("t1: " + t1);
            System.out.println("Периметр t1: " + t1.getPerimeter());
            System.out.println("Площа t1: " + t1.getArea());

            // Створюємо неправильний трикутник
            // Повинно дати помилку, і вивести її на екран
            Triangle t = new Triangle(3, 4, 8);
            System.out.println(t.toString());

        } catch (IllegalArgumentException ex) {
            System.out.println("ПОМИЛКА: " + ex.getMessage());
        }

        // Створюємо два однакових трикутника
        Triangle t3 = new Triangle(6, 8, 10);
        Triangle t4 = new Triangle(12, 16, 20);
        System.out.println("t3 подібний до t4?: " + t3.isSimilarTo(t4));

        // Створюємо два різних трикутника
        Triangle t5 = new Triangle(5, 7, 9);
        Triangle t6 = new Triangle(5, 7, 8);
        System.out.println("t5 подібний до t6?: " + t5.isSimilarTo(t6));
    }
}
