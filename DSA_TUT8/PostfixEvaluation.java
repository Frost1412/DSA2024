package DSA_TUT8;

import java.util.EmptyStackException;


class ArrayStack2 {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

public class PostfixEvaluation {

    public static int evaluatePostfix(String expression) {
        ArrayStack2 stack = new ArrayStack2(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, c);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    // Method to perform arithmetic operation
    private static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Main method to demonstrate postfix expression evaluation
    public static void main(String[] args) {
        String postfixExpression = "82+3*";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result of postfix expression evaluation: " + result);
    }
}
