package GreedySelector;

/**
 * @Description [738] 单调递增的数字
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 * @date 2020/12/15 0015-9:26
 */
public class Sol738 {
    public int monotoneIncreasingDigits(int N){
        //贪心   TC:O(logN)  SC:O(logN)   logN代表数字N的位数
        char[] strN=Integer.toString(N).toCharArray();
        int i=1;
        //找到第一个位置 i 使得 [0,i−1] 的数位单调递增且strN[i−1]>strN[i]
        while(i<strN.length && strN[i-1]<=strN[i]){
            i++;
        }

        if(i<strN.length){
            // 因此我们需要从 i−1 开始递减比较相邻数位的关系，
            // 直到找到第一个位置 j 使得strN[j] 自身数位减 1 后strN[j−1] 和strN[j] 仍然保持递增关系，
            // 或者位置 j 已经到最左边（即 j 的值为 0）
            while (i>0 && strN[i-1]>strN[i]){
                strN[i-1]--;
                i--;
            }
            //此时我们将[j+1,n−1] 的数全部变为 9 才能得到最终正确的答案。
            for (int j = i+1; j < strN.length; j++) {
                strN[j]='9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
