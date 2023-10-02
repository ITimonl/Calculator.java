import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double num1 = getDouble();
        double num2 = getDouble();
        char operation = getOperation();
        double result = calc(num1, num2, operation);
        System.out.print("Результат: " + result);
    }

    public static double getDouble() {
        System.out.println("Введіть число: ");
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.print("Помилка,спробуйте ще раз.");
            scanner.next();
            num = getDouble();

        }
        return num;
    }

    public static char getOperation() {
        System.out.print("Введіть операцію: ");
        char operation;
        if(scanner.hasNext()) {
            operation = scanner.next() .charAt(0);
        } else {
            System.out.print("Помилка.Повторіть спробу.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc (double num1, double num2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 ==0 ) {
                    System.out.println("Ділення на ноль неможливе!");
                    result = calc(num1, getDouble(), operation);
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.print("Введення було неправильним.Повторіть ще раз.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}
