import java.util.ArrayList;
import java.util.List;

/**
 * @Description [57] 插入区间
 * https://leetcode-cn.com/problems/insert-interval/
 * @date 2020/11/4 0004-9:22
 */

/**
 * 思路：根据intervals数组的结构特点，该数组内任意两个区间都是没有并集的，并且是按照左端点排序的，所以所有
 * 与newInterval重合的区间都是连续的，进行一次遍历即可，
 * 对遍历到的区间[li,ri]:有三种情况
 *
 */
public class Sol57 {
    public int[][] insert(int[][] intervals, int[] newInterval){
        //TC:O(n)   SC:O(1)
        // 列表里存的是要返回的结果数组的地址，最后只不过是把列表存储改成数组存储了，里面存的地址还是那些返回数组
        int left=newInterval[0];
        int right=newInterval[1];//要插入区间的左右端点
        boolean placed=false;  //记录newInterval是否添加的标志，true表示已添加，false表示未添加
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0]>right){
                //遍历到的区间在要插入区间的右侧且无交集，newInterval如果未添加，就添加到ansList中，并更新标志
                if(!placed){
                    ansList.add(new int[]{left,right});
                    placed=true;
                }
                ansList.add(interval);
            }else if(interval[1]<left){
                //遍历到的区间在要插入区间的左侧且无交集
                ansList.add(interval);
            }else{
                //遍历到的区间与插入区间有交集，计算他们的并集，将newInterval更新为并集
                left=Math.min(interval[0],left);
                right=Math.max(interval[1],right);
            }
        }
        if(!placed){
            ansList.add(new int[]{left,right});
        }

        int[][] res=new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            res[i]=ansList.get(i);
        }
        return res;
    }
}
