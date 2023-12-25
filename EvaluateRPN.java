import java.util.ArrayList;
import java.util.Stack;

public class EvaluateRPN {
   public static int evalRPN(String[] a) {
    // ArrayList<String> list = new ArrayList<>();
    // list.add("+");
    // list.add("-");
    // list.add("*");
    // list.add("/");
    // Stack<Integer> stack = new Stack<>();
    // for (String token : tokens) {
    // if (list.contains(token)) {
    // int a = stack.pop();
    // int b = stack.pop();
    // if (token.equals("+")) {
    // stack.push(a + b);
    // }
    // if (token.equals("-")) {
    // stack.push(b-a);
    // }
    // if (token.equals("*")) {
    // stack.push(a * b);
    // }
    // if (token.equals("/")) {
    // stack.push(b / a);
    // }
    // } else {
    // stack.push(Integer.parseInt(token));
    // }
    // }
    // return stack.pop();
    // }
    Stack<Integer> stack = new Stack<Integer>();

    for(int i = 0;i<a.length;i++) {
        switch (a[i]) {
            case "+":
                stack.push(stack.pop() + stack.pop());
                break;

            case "-":
                stack.push(-stack.pop() + stack.pop());
                break;

            case "*":
                stack.push(stack.pop() * stack.pop());
                break;

            case "/":
                int n1 = stack.pop(), n2 = stack.pop();
                stack.push(n2 / n1);
                break;

            default:
                stack.push(Integer.parseInt(a[i]));
        }
    }

    return stack.pop();
}

    public static void main(String[] args) {
        String[] s={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));
    }
}
