import java.util.Stack;

/**
 * @Description 32 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @date 2021/2/26-11:20
 */
public class Sol32 {
    public static void main(String[] args) {
        int res=longestValidParentheses1(")()())");
    }
    //法一 dp   TC:O(n)  SC:O(n)
    public int longestValidParentheses(String s){
        if(s==null || s.length()==0) return 0;
        int maxRes=0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i-2>=0?dp[i-2]:0)+2;
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
                maxRes=Math.max(maxRes,dp[i]);
            }
        }
        return maxRes;
    }

    //法二 栈   TC:O(n)  SC:O(n)
    public static int longestValidParentheses1(String s){
        int max=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);  //避免以“()”开头时出错
        for (int i = 0; i < s.length(); i++) {
            //遇到左括号就把他的下标压栈
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                // 栈：后进先出
                //遇到右括号说明和栈顶元素匹配，先将栈顶元素出栈。
                // 再用当前元素下表减去新的栈顶元素的值，
                // 减去新的栈顶元素的值，是因为新的栈顶元素还未匹配成功，之前的栈顶元素到现在的元素之间形成了有效括号
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    //法三 左右遍历   TC:O(n)  SC:O(1)
    public static int longestValidParentheses2(String s){
        int left=0,right=0,maxLen=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLen=Math.max(maxLen,right*2);
            }else if(right>left){
                left=right=0;
            }
        }
        // 只从左向右遍历时会漏掉一种情况，就是就是遍历的时候左括号的数量始终大于右括号的数量，
        // 即 (() ，这种时候最长有效括号是求不出来的。从右向左遍历即可
        left=right=0;
        for (int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLen=Math.max(maxLen,left*2);
            }else if(right<left){
                left=right=0;
            }
        }
        return maxLen;
    }
}
