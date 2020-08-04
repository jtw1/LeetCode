package LeetCodeTest;
//[120] 三角形最小路径和
//https://leetcode-cn.com/problems/triangle/description/
import java.util.List;

public class Solu120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0) return 0;
        //dp[i][j]表示包含第i行第j列元素的最小路径和,由于每次比较时只需要另外一层的两个元素，所以可以降维
        
        // int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

        // for (int i = triangle.size() - 1; i >= 0; i--) {
        //     List<Integer> rows = triangle.get(i);
        //     for (int j = 0; j < rows.size(); j++) {
        //         dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + rows.get(j);
        //     }
        // }
        // return dp[0][0];
        
        int[] dp = new int[triangle.size()+1];
        //长度设置为triangle.size()+1而不是triangle.size()，这样在初始化最后一行的时候，等号右边的dp[i+1]不会角标越界，避免了单独对最后一行初始化的操作

        //从底至上，如果是从上到下，还要对边界的元素单独处理，比较麻烦
        //外循环第一次时，dp[]即triangle的最后一行
        //第二次时，右边的dp[j], dp[j+1]即为当前行的下一行的两个元素，外循环没经过一次，dp[]就刷新一次
        for (int i = triangle.size()-1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j]=Math.min(dp[j], dp[j+1])+rows.get(j);
            }
        }
        return dp[0];
    }
}