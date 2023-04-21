//Лабораторна робота 2
//Завдання 1

class Rational {
    private int numerator;
    private int denominator;

    public Rational(int num, int den) {
        numerator = num;
        denominator = den;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational add(Rational r) {
        int num = numerator * r.denominator + r.numerator * denominator;
        int den = denominator * r.denominator;
        Rational result = new Rational(num, den);
        result.reduce();
        return result;
    }

    public Rational subtract(Rational r) {
        int num = numerator * r.denominator - r.numerator * denominator;
        int den = denominator * r.denominator;
        Rational result = new Rational(num, den);
        result.reduce();
        return result;
    }

    public Rational multiply(Rational r) {
        int num = numerator * r.numerator;
        int den = denominator * r.denominator;
        Rational result = new Rational(num, den);
        result.reduce();
        return result;
    }

    public Rational divide(Rational r) {
        int num = numerator * r.denominator;
        int den = denominator * r.numerator;
        Rational result = new Rational(num, den);
        result.reduce();
        return result;
    }

    public boolean equals(Rational r) {
        return (numerator == r.numerator) && (denominator == r.denominator);
    }

    public boolean isGreaterThan(Rational r) {
        return numerator * r.denominator > r.numerator * denominator;
    }

    public boolean isLessThan(Rational r) {
        return numerator * r.denominator < r.numerator * denominator;
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}

public class Lab2_1 {
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 3);
        
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        
        Rational r3 = r1.add(r2);
        System.out.println("r1 + r2 = " + r3);
        
        Rational r4 = r1.subtract(r2);
        System.out.println("r1 - r2 = " + r4);
        
        Rational r5 = r1.multiply(r2);
        System.out.println("r1 * r2 = " + r5);
        
        Rational r6 = r1.divide(r2);
        System.out.println("r1 / r2 = " + r6);
        
        Rational r7 = new Rational(2, 4);
        System.out.println("r7 = " + r7);
        
        System.out.println("r1 == r2: " + r1.equals(r2));
        System.out.println("r1 > r2: " + r1.isGreaterThan(r2));
        System.out.println("r1 < r2: " + r1.isLessThan(r2));
    }
}
