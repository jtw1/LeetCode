package LeetcodeTest;
// [1190] 反转每对括号间的字串
// https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/
// 2021秋招笔试题
import java.util.Stack;

public class bs {
    private int[] parent;

    public String reverseParentheses(String s) {
        parent = new int[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int f = stack.pop();
                parent[f] = i;
                parent[i] = f;
            }
        }
        StringBuilder sb = new StringBuilder(s.length());
        reverse(s, 0, s.length() - 1, false, sb);
        return sb.toString();
    }

    private void reverse(String s, int start, int end, boolean reversed, StringBuilder sb) {
        if (reversed) {
            for (int i = end; i >= start; i--) {
                if (s.charAt(i) == ')') {
                    reverse(s, parent[i] + 1, i - 1, false, sb);
                    i = parent[i];
                } else {
                    sb.append(s.charAt(i));
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '(') {
                    reverse(s, i + 1, parent[i] - 1, true, sb);
                    i = parent[i];
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
    }
}