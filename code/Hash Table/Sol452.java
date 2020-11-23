import java.util.Arrays;

/**
 * @Description [452] 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @date 2020/11/23 0023-9:47
 */
public class Sol452 {
    public static void main(String[] args) {
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
        int res=findMinArrowShots(points);
        System.out.println("引爆气球的最少箭的数量："+res);
    }
    public static int findMinArrowShots(int[][] points) {
        //TC:O(nlogn)   SC:O(logn)排序使用的栈空间
        if(points==null || points.length==0) return 0;
        int count = 1,min = Integer.MIN_VALUE,max = Integer.MAX_VALUE;
        Arrays.sort(points, (o1, o2) -> o1[0]==o2[0]? (o1[1]-o2[1]):(o1[0]-o2[0]));

        for (int[] point : points) {
            min = min>point[0]?min:point[0];   //左端点较大值
            max = max>point[1]?point[1]:max;   //右端点较小值
            if(min>max){
                min=point[0];
                max = point[1];
                count++;
            }
        }
        return count;
    }
}
