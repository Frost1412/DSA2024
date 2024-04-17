package DSA_TUT8;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackReversing {
    public static void reverseStack(Stack<Character> s) {
        Queue<Character> q = new LinkedList<>();

        // Enqueue all elements from the stack to the queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        // Dequeue all elements from the queue and push them back onto the stack
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
    }

    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('d');

        System.out.println("Original stack:");
        System.out.println(s);

        // Reversing the stack
        reverseStack(s);
        System.out.println("Reversed stack:");
        System.out.println(s);
    }
}
