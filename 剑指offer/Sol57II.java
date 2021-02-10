import java.util.ArrayList;
import java.util.List;

/**
 * @Description 57-II 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @date 2021/2/10-11:06
 */
public class Sol57II {
    public int[][] findContinuousSequence(int target) {
        if(target<3) return new int[0][0];
        List<int[]> res=new ArrayList<>();
        for(int left=1,right=2;left<right;){
            int sum=(left+right)*(right-left+1)/2;
            if(sum==target){
                int[] tmp=new int[right-left+1];
                for (int i = left; i <= right; i++) {
                    tmp[i-left]=i;
                }
                res.add(tmp);
                left++;
            }else if(sum < target){
                right++;
            }else{
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
