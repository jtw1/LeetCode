package GreedySelector;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description [435] 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * @date 2020/12/31 0031-9:23
 */
public class Sol435 {
    /**
     * 按照右边界排序，就要从左向右遍历，因为右边界越小越好，只要右边界越小，留给下一个区间的空间就越大，所以从左向右遍历，优先选右边界小的。
     * 按照左边界排序，就要从右向左遍历，因为左边界数值越大越好（越靠右），这样就给前一个区间的空间就越大，所以可以从右向左遍历。
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals){
        //TC:O(nlogn)  SC:O(logn)   法一  贪心
        if(intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1]-o2[1]);   //按右端点升序排序

        int n=intervals.length;
        int right=intervals[0][1];   //初始化右端点
        int ans=1;   //不重叠的区间个数
        for (int i = 1; i < n; i++) {
            //区间不重叠的情况
            if(intervals[i][0]>=right){
                ans++;
                right=intervals[i][1];
            }
        }
        return n-ans;
    }
    //排序+双指针
    public int eraseOverlapIntervals1(int[][] intervals){
        if(intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals,(o1,o2)->o1[0]!=o2[0]?(o1[0]-o2[0]):(o1[1]-o2[1]));

        int count=0;
        int i=0,j=1;  //i指向待比较的左边区间，j指向待比较的右边区间
        for(i=0,j=1;i<intervals.length-1 && j<=intervals.length-1;i++,j++){
            if(intervals[i][1]>intervals[j][0]){
                i = intervals[i][1] < intervals[j][1] ? i - 1 : j - 1;
                count++;
            } else {
                i = j-1;
            }
        }
        return count;
    }
}
