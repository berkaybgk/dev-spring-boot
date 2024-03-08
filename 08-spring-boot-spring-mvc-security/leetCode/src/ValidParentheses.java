import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]";
        System.out.println(isValid(s));


    }

    public static boolean isValid(String string) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i< string.length(); i++) {
            if ((!stack.isEmpty()) && (isComplementary(stack.peek(),string.charAt(i)))) {
                stack.pop();
            }
            else {
                stack.push(string.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static boolean isComplementary(Character ch1, Character ch2) {

        if (ch1.equals('(') && ch2.equals(')'))
            return true;
        else if (ch1.equals('[') && ch2.equals(']'))
            return true;
        else if (ch1.equals('{') && ch2.equals('}'))
            return true;

        else
            return false;
    }
}
