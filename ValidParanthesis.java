import java.util.*;

public class ValidParanthesis {

    static boolean isValid(String s) {
        int i;
        Stack<Character> stack = new Stack<Character>();
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '(') {
                stack.push(')');
            } else {

                // In case like this the stack is empty but we still need a pair
                // "({})}"
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
  // In a case like this the stack still has elements but is not a valid parantheses
  // "(({})"
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{()})"));
    }
}

