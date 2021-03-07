package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description 56 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * @date 2021/3/7-20:36
 */
public class Solu56 {
    /**
     * TC:O(nlogn)  SC:O(logn)
     * 思路 先将intervals按左边界从小到大排序，这样保证了可以合并的区间是连续的
     */
    public int[][] merge(int[][] intervals) {
        if (intervals==null || intervals.length==0) return new int[0][2];
        // 按左边界升序排序
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        // 存储最终答案的list
        List<int[]> merged=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left=intervals[i][0],right=intervals[i][1];
            // merged还未添加区间
            // 或者 当前所遍历的区间的左端点>merged最后一个区间的右端点，说明不会重合，直接将区间加入merged末尾
            if (merged.size()==0 || merged.get(merged.size()-1)[1]<left){
                merged.add(new int[]{left,right});
            }
            // 或者 当前所遍历的区间的左端点<=merged最后一个区间的右端点，
            // 更新merged最后一个区间的右端点，为当前所遍历的区间的右端点和merged最后一个区间的右端点的较大值
            else {
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
