//Лабораторна робота 2
//Завдання 3

import java.util.Scanner;

class Math {
    public static int nsd(int a, int b) {   //НСД - найбільший спільний дільник
        if (b == 0) {
            return a;
        }
        return nsd(b, a % b);
    }

    public static int nsk(int a, int b) {   //НСК - найменше спільне кратне
        return (a / nsd(a, b)) * b;
    }
}

public class Lab2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        do {
            System.out.print("Введіть перше число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Неправильні вхідні дані!");
                System.out.print("Введіть перше число: ");
                scanner.next();
            }
            a = scanner.nextInt();

            System.out.print("Введіть друге число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Неправильні вхідні дані!");
                System.out.print("Введіть друге число: ");
                scanner.next();
            }
            b = scanner.nextInt();

            if (a <= 0 || b <= 0) {
                System.out.println("Числа повинні бути більше 0!");
            }
        } while (a <= 0 || b <= 0);

        int nsd = Math.nsd(a, b);
        int nsk = Math.nsk(a, b);

        System.out.println("НСД: " + nsd);
        System.out.println("НСК: " + nsk);
    }
}
