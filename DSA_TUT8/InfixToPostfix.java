package DSA_TUT8;

import java.util.Stack;

public class InfixToPostfix {
    
    
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
    
            case '*':
            case '/':
                return 2;
    
            case '^':
                return 3;
        }
        return -1;
    }
    
    
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
    
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
    
            
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
          
            else if (ch == '(') {
                stack.push(ch);
            }
            
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); 
            }
            
            else {
                
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch); 
            }
        }
    
       
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid infix expression";
            }
            result.append(stack.pop());
        }
    
        return result.toString();
    }

   
    public static void main(String[] args) {
        String infixExpression = "a+b*c-(d/e+f)*g";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
