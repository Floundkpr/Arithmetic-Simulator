import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);

    private static int addition(int numCapacity, int countOfEx) {
        int r = 0;
        for (int i = 0; i < countOfEx; i++) {
            int num1 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1));
            int num2 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1));
            switch ((int) (Math.ceil(Math.random() * 3))) {
                case 1:
                    System.out.println("_____ + " + num2 + " = " + (num1 + num2));
                    System.out.println("Введите пропущенное слагаемое: ");
                    if (s.nextInt() == num1) r++;
                    break;
                case 2:
                    System.out.println(num1 + " + _____" + " = " + (num1 + num2));
                    System.out.println("Введите пропущенное слагаемое: ");
                    if (s.nextInt() == num2) r++;
                    break;
                case 3:
                    System.out.println(num1 + " + " + num2 + " =  _____");
                    System.out.println("Введите результат вычисления: ");
                    if (s.nextInt() == num1 + num2) r++;
                    break;
            }
        }
        return r;
    }

    private static int subtraction(int numCapacity, int countOfEx) {
        int r = 0;
        for (int i = 0; i < countOfEx; i++) {
            int num1 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1));
            int num2 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1));
            switch ((int) (Math.ceil(Math.random() * 3))) {
                case 1:
                    System.out.println("_____ - " + num2 + " = " + (num1 - num2));
                    System.out.println("Введите пропущенное уменьшаемое: ");
                    if (s.nextInt() == num1) r++;
                    break;
                case 2:
                    System.out.println(num1 + " - _____" + " = " + (num1 - num2));
                    System.out.println("Введите пропущенное вычитаемое: ");
                    if (s.nextInt() == num2) r++;
                    break;
                case 3:
                    System.out.println(num1 + " + " + num2 + " =  _____");
                    System.out.println("Введите результат вычисления: ");
                    if (s.nextInt() == num1 - num2) r++;
                    break;
            }
        }
        return r;
    }

    private static int multiplication(int numCapacity, int countOfEx) {
        int r = 0;
        for (int i = 0; i < countOfEx; i++) {
            int num1 = (int) Math.ceil(Math.random() * Math.pow(10, numCapacity + 1));
            int num2 = (int) Math.ceil(Math.random() * Math.pow(10, numCapacity + 1));
            switch ((int) (Math.ceil(Math.random() * 3))) {
                case 1:
                    System.out.println("_____ * " + num2 + " = " + (num1 * num2));
                    System.out.println("Введите пропущенный множитель: ");
                    if (s.nextInt() == num1) r++;
                    break;
                case 2:
                    System.out.println(num1 + " * _____" + " = " + (num1 * num2));
                    System.out.println("Введите пропущенный множитель: ");
                    if (s.nextInt() == num2) r++;
                    break;
                case 3:
                    System.out.println(num1 + " * " + num2 + " =  _____");
                    System.out.println("Введите результат вычисления: ");
                    if (s.nextInt() == num1 * num2) r++;
                    break;
            }
        }
        return r;
    }

    private static int division(int numCapacity, int countOfEx) {
        int r = 0;
        for (int i = 0; i < countOfEx; i++) {
            int num1 = (int) Math.ceil(Math.random() * Math.pow(10, numCapacity + 1));
            int num2 = (int) Math.ceil(Math.random() * Math.pow(10, numCapacity + 1));
            switch ((int) (Math.ceil(Math.random() * 3))) {
                case 1:
                    System.out.println("_____ / " + num1 + " = " + num2);
                    System.out.println("Введите пропущенное делимое: ");
                    if (s.nextInt() == num1 * num2) r++;
                    break;
                case 2:
                    System.out.println(num1 * num2 + " / _____" + " = " + num2);
                    System.out.println("Введите пропущенный делитель: ");
                    if (s.nextInt() == num1) r++;
                    break;
                case 3:
                    System.out.println(num1 * num2 + " / " + num1 + " =  _____");
                    System.out.println("Введите результат вычисления: ");
                    if (s.nextInt() == num2) r++;
                    break;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println("Введите своё имя: ");
        String name = s.nextLine();
        System.out.println("Введите количество примеров: ");
        int countOfEx = s.nextInt();
        System.out.println("Введите разрядность чипсел (степень 10): ");
        int numCapacity = s.nextInt();
        int result;
        boolean f;
        do {
            do {
                System.out.println("Выберите действие: \n1.+\n2.-\n3.*\n4.\\\n");
                switch (s.nextInt()) {
                    case 1:
                        result = addition(numCapacity, countOfEx);
                        f = true;
                        break;
                    case 2:
                        result = subtraction(numCapacity, countOfEx);
                        f = true;
                        break;
                    case 3:
                        result = multiplication(numCapacity, countOfEx);
                        f = true;
                        break;
                    case 4:
                        result = division(numCapacity, countOfEx);
                        f = true;
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Неверный формат");
                        result = -1;
                        f = false;
                }
            } while (!f);
            System.out.println(name + ", количество правильных ответов = " + result + "\nХотите повторить?\n1.Повторить\n0.Выход\n");
        } while (s.nextInt() != 0);

    }
}