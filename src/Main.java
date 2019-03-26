import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Введите своё имя: ");
            String name = scanner.nextLine();
            int score;
            boolean f;
            do {
                System.out.println("Введите количество примеров: ");
                int countOfEx = scanner.nextInt();
                System.out.println("Введите разрядность чипсел (степень 10): ");
                int numCapacity = scanner.nextInt();
                do {
                    System.out.println("Выберите действие: \n1.+\n2.-\n3.*\n4.\\\n");
                    switch (scanner.nextInt()) {
                        case 1:
                            score = Methods.addition(numCapacity, countOfEx);
                            f = true;
                            break;
                        case 2:
                            score = Methods.subtraction(numCapacity, countOfEx);
                            f = true;
                            break;
                        case 3:
                            score = Methods.multiplication(numCapacity, countOfEx);
                            f = true;
                            break;
                        case 4:
                            score = Methods.division(numCapacity, countOfEx);
                            f = true;
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            System.out.println("Неверный формат");
                            score = -1;
                            f = false;
                    }
                } while (!f);
                int res = Methods.recordResult(name, score);
                System.out.println(name + ", количество правильных ответов = " + score + ". Вы на " + res + " месте в рейтинге.");
                System.out.println("Хотите повторить?\n1.Повторить\n0.Выход\n");
            } while (scanner.nextInt() != 0);
        } catch (Exception ex) {
            System.out.println("Неверный формат, проверьте правильность введённых данных и перезапустите программу.");
        }
    }
}