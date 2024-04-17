package DSA_TUT8;

class ArrayStack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public ArrayStack(int maxSize) {
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
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

public class BaseConversion {
    public static String convertToBase(int K, int B) {
        if (K == 0) {
            return "0"; 
        }

        ArrayStack2 stack = new ArrayStack2(100);

       
        while (K > 0) {
            int remainder = K % B;
            stack.push(remainder);
            K = K / B;
        }

       
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int K = 124;
        int B = 2;
        System.out.println("Base " + B + " representation of " + K + ": " + convertToBase(K, B));

        B = 16; 
        System.out.println("Base " + B + " representation of " + K + ": " + convertToBase(K, B));
    }
}
