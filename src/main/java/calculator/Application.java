package calculator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // input
        String[] values = getInput();

        // calculate
        int operand1 = calculate(values);

        // print answer
        System.out.println(operand1);
    }

    private static String[] getInput() {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        return values;
    }

    // todo, 뭔가 더 분리해야 될 것만 같음ㅎ
    private static int calculate(String[] values) {
        int operand1 = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            char operator = values[i].charAt(0);
            int operand2 = Integer.parseInt(values[i + 1]);

            if (operator == '+') {
                operand1 = Operator.plus(operand1, operand2);
            }
            if (operator == '-') {
                operand1 = Operator.minus(operand1, operand2);
            }
            if (operator == '*') {
                operand1 = Operator.multiply(operand1, operand2);
            }
            if (operator == '/') {
                operand1 = Operator.divide(operand1, operand2);
            }
        }
        return operand1;
    }

}
