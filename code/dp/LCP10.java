package LeetCodeTest;
/**
 * LCP10 秋叶收藏集
 * https://leetcode-cn.com/problems/UlBDOe/
 * 其中isYellow(i) 为示性函数，当第 i 片叶子为黄色时为 1，红色时为 0。
 * 红叶子数+黄叶子数 = 总叶子数 = 当前索引+1
*/
public class LCP10 {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int g = leaves.charAt(0) == 'y' ? 1 : -1;
        int gmin = g;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            g += 2 * isYellow - 1;
            if (i != n - 1) {
                ans = Math.min(ans, gmin - g);
            }
            gmin = Math.min(gmin, g);
        }
        return ans + (g + n) / 2;
    }
}
