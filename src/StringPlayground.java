public class StringPlayground {

    public static int countParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { count++; }
            else if (c == ')') {
                if (count <= 0) {
                    throw new IllegalArgumentException("Unbalanced parentheses in the string: " + s);
                }
                count--;
            }
        }
        if (count != 0) {
            throw new IllegalArgumentException("Unbalanced parentheses in the string: " + s);
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "((3 + 7) * 2)";
        String s2 = "((3 + 7) * 2))";
        String s3 = "(3 + 7) * 2)";
        try {
            System.out.println("Count for s1: " + countParentheses(s1));
            System.out.println("Count for s2: " + countParentheses(s2));
            System.out.println("Count for s3: " + countParentheses(s3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
