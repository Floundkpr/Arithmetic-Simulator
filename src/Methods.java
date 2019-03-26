import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Methods {

    private static Scanner scanner = new Scanner(System.in);

    static int addition(int numCapacity, int countOfEx) {
        int r = 0;
        for (int i = 0; i < countOfEx; i++) {
            int num1 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1));
            int num2 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1));
            switch ((int) (Math.ceil(Math.random() * 3))) {
                case 1:
                    System.out.println("Введите пропущенное слагаемое: ");
                    System.out.println("_____ + " + num2 + " = " + (num1 + num2));
                    if (scanner.nextInt() == num1) r++;
                    break;
                case 2:
                    System.out.println("Введите пропущенное слагаемое: ");
                    System.out.println(num1 + " + _____" + " = " + (num1 + num2));
                    if (scanner.nextInt() == num2) r++;
                    break;
                case 3:
                    System.out.println("Введите результат вычисления: ");
                    System.out.println(num1 + " + " + num2 + " =  _____");
                    if (scanner.nextInt() == num1 + num2) r++;
                    break;
            }
        }
        return r;
    }

    static int subtraction(int numCapacity, int countOfEx) {
        int r = 0;
        for (int i = 0; i < countOfEx; i++) {
            int num1 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1));
            int num2 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1));
            switch ((int) (Math.ceil(Math.random() * 3))) {
                case 1:
                    System.out.println("Введите пропущенное уменьшаемое: ");
                    System.out.println("_____ - " + num2 + " = " + (num1 - num2));
                    if (scanner.nextInt() == num1) r++;
                    break;
                case 2:
                    System.out.println("Введите пропущенное вычитаемое: ");
                    System.out.println(num1 + " - _____" + " = " + (num1 - num2));
                    if (scanner.nextInt() == num2) r++;
                    break;
                case 3:
                    System.out.println("Введите результат вычисления: ");
                    System.out.println(num1 + " + " + num2 + " =  _____");
                    if (scanner.nextInt() == num1 - num2) r++;
                    break;
            }
        }
        return r;
    }

    static int multiplication(int numCapacity, int countOfEx) {
        int r = 0;
        for (int i = 0; i < countOfEx; i++) {
            int num1 = (int) Math.ceil(Math.random() * Math.pow(10, numCapacity + 1));
            int num2 = (int) Math.ceil(Math.random() * Math.pow(10, numCapacity + 1));
            switch ((int) (Math.ceil(Math.random() * 3))) {
                case 1:
                    System.out.println("Введите пропущенный множитель: ");
                    System.out.println("_____ * " + num2 + " = " + (num1 * num2));
                    if (scanner.nextInt() == num1) r++;
                    break;
                case 2:
                    System.out.println("Введите пропущенный множитель: ");
                    System.out.println(num1 + " * _____" + " = " + (num1 * num2));
                    if (scanner.nextInt() == num2) r++;
                    break;
                case 3:
                    System.out.println("Введите результат вычисления: ");
                    System.out.println(num1 + " * " + num2 + " =  _____");
                    if (scanner.nextInt() == num1 * num2) r++;
                    break;
            }
        }
        return r;
    }

    static int division(int numCapacity, int countOfEx) {
        int r = 0;
        for (int i = 0; i < countOfEx; i++) {
            int num1 = (int) Math.ceil(Math.random() * Math.pow(10, numCapacity + 1));
            int num2 = (int) Math.ceil(Math.random() * Math.pow(10, numCapacity + 1));
            switch ((int) (Math.ceil(Math.random() * 3))) {
                case 1:
                    System.out.println("Введите пропущенное делимое: ");
                    System.out.println("_____ / " + num1 + " = " + num2);
                    if (scanner.nextInt() == num1 * num2) r++;
                    break;
                case 2:
                    System.out.println("Введите пропущенный делитель: ");
                    System.out.println(num1 * num2 + " / _____" + " = " + num2);
                    if (scanner.nextInt() == num1) r++;
                    break;
                case 3:
                    System.out.println("Введите результат вычисления: ");
                    System.out.println(num1 * num2 + " / " + num1 + " =  _____");
                    if (scanner.nextInt() == num2) r++;
                    break;
            }
        }
        return r;
    }


    static int recordResult(String name, int score) {
        int position = 1;
        StringBuilder beforePos = new StringBuilder();
        StringBuilder afterPos = new StringBuilder();

        try {
            FileReader reader = new FileReader("Results.txt");
            Scanner fileScanner = new Scanner(reader);
            boolean f = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (!f) f = Integer.parseInt(line.split(" ")[1]) <= score;
                if (!f) {
                    position++;
                    beforePos.append(line).append("\n");
                } else afterPos.append(line).append("\n");
            }
            FileWriter writer = new FileWriter("Results.txt", false);
            writer.append(beforePos).append("Счёт: ").append(String.valueOf(score)).append("   Имя: ").append(name).append("\n").append(afterPos);
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return position;
    }
}
