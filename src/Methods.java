import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Methods {

    private static Scanner scanner = new Scanner(System.in);

    //тренажер сложения
    static int addition(int numCapacity, int countOfEx) {
        int r = 0; //результат
        for (int i = 0; i < countOfEx; i++) { //цикл, количество итераций которого равно количеству примеров.
            int num1 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1)); //случайное число от 0 до 1, умножается на 10 в степени, которую пользователь указал как разрядность округляется и преобразуется в целое число
            int num2 = (int) Math.round(Math.random() * Math.pow(10, numCapacity + 1)); // так же как и первое число, только уже второе
            switch ((int) (Math.ceil(Math.random() * 3))) { //случайный переключатель
                case 1: // если переключило на этот вариант, то пропускается первое слагаемое
                    System.out.println("Введите пропущенное слагаемое: ");
                    System.out.println("_____ + " + num2 + " = " + (num1 + num2));
                    if (scanner.nextInt() == num1) r++; // если число которое ввел пользователь равно пропущенному, то прибавить счётчик результата
                    break;
                case 2: // если переключило на этот вариант, то пропускается второе слагаемое
                    System.out.println("Введите пропущенное слагаемое: ");
                    System.out.println(num1 + " + _____" + " = " + (num1 + num2));
                    if (scanner.nextInt() == num2) r++; // если число которое ввел пользователь равно пропущенному, то прибавить счётчик результата
                    break;
                case 3: // если переключило на этот вариант, то пропускается третье слагаемое
                    System.out.println("Введите результат вычисления: ");
                    System.out.println(num1 + " + " + num2 + " =  _____");
                    if (scanner.nextInt() == num1 + num2) r++; // если число которое ввел пользователь равно пропущенному, то прибавить счётчик результата
                    break;
            }
        }
        return r; //функция возвращает счёт
    }

    //тренажер вычитания. работает по тому же принципу что и сложение.
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

    //тренажер умножения. работает по тому же принципу что и предыдущие.
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

    //тренажер деления. работает по тому же принципу что и другие.
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

    //запись результата в файл и возвращение номера пользователя в списке.
    static int recordResult(String name, int score) {
        int position = 1;                                                           //позиция пользователя, на случай, если файл пустой.
        StringBuilder beforePos = new StringBuilder();                              //строка, для данных, которые записаны до позиции текущего пользоватлея
        StringBuilder afterPos = new StringBuilder();                               //строка, для данных, которые записаны после позиции текущего пользоватлея

        try {
            FileReader reader = new FileReader("Results.txt");              //обьявление переменной, которая связана с файлом для чтения
            Scanner fileScanner = new Scanner(reader);                              //сканнер, который будет построчно считывать из файла
            boolean f = false;                                                      //флаг истинный тогда, когда результат в очередной строке файла меньше либо равен пользовательскому
            while (fileScanner.hasNextLine()) {                                     //цикл, работающий пока в файле существует следующая строка
                String line = fileScanner.nextLine();                               //считывание очередной строки и запись её в переменную line
                if (!f) f = Integer.parseInt(line.split(" ")[1]) <= score;    //если флаг f ложный, то сравнить значение результата в текущей строке с пользовательским рещультатом
                if (!f) {                                                           //если флаг ложный
                    position++;                                                     //увеличить счётчик позиции
                    beforePos.append(line).append("\n");                            //добавить строку line в строку beforePos
                } else afterPos.append(line).append("\n");                          //иначе добавить в строку afterPos
            }
            FileWriter writer = new FileWriter("Results.txt", false);//обьявление переменной, которая связана с файлом для записи
            //запись в файл с нуля. сначала записываются строки, которые были до нужной позиции, затем результат пользователя, затем те строки, которые были после.
            writer.append(beforePos).append("Счёт: ").append(String.valueOf(score)).append("   Имя: ").append(name).append("\n").append(afterPos);
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return position; //функция возвращает позицию пользователя в списке результатов
    }
}
