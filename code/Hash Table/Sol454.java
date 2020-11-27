import java.util.HashMap;
import java.util.Map;

/**
 * @Description [454] 四数相加 day
 * https://leetcode-cn.com/problems/4sum-ii/solution/si-shu-xiang-jia-ii-by-leetcode-solution/
 * @date 2020/11/27 0027-9:28
 */
public class Sol454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        /**
         * TC:O(n^2)  SC:O(n^2)
         * 对于 A 和 B，我们使用二重循环对它们进行遍历，得到所有 A[i]+B[j]的值并存入哈希映射中。对于哈希映射中的每个键值对，每个键表示一种 A[i]+B[j], 对应的值为 A[i]+B[j] 出现的次数。
         *
         * 对于 C 和 D，我们同样使用二重循环对它们进行遍历。当遍历到 C[k]+D[l] 时，如果 -(C[k]+D[l]) 出现在哈希映射中，那么将 -(C[k]+D[l])对应的值累加进答案中。
         *
         * 最终即可得到满足 A[i]+B[j]+C[k]+D[l]=0 的四元组数目。
         *
         */
        Map<Integer,Integer> countAB=new HashMap<>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u+v,countAB.getOrDefault(u+v,0)+1);
            }
        }
        int ans=0;
        for (int u : C) {
            for (int v : D) {
                if(countAB.containsKey(-u-v)){
                    ans += countAB.get(-u-v);
                }
            }
        }
        return ans;
    }
}
