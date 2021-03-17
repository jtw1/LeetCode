/**
 * @Description 84 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 题解 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhao-liang-bian-di-yi-ge-xiao-yu-ta-de-zhi-by-powc/
 * @date 2021/3/17 0017-10:21
 */
public class Solu84 {
    // 单调栈  TC:O(n)  SC:O(n)
    public int largestRectangleArea(int[] heights){
        if (heights==null || heights.length==0) return 0;
        int len=heights.length;
        int[] lSide=new int[len];
        int[] rSide=new int[len];
        lSide[0]=-1;
        rSide[len-1]=len;
        int res=0;
        // 以i为中心，向左找到第一个小于heights[i]的位置lSide[i]
        for (int i = 1; i < len; i++) {
            int tmp=i-1;
            // 找到第一个小于heights[i]的位置或者到了边界时就退出循环
            // 否则tmp就更新为第一个小于heights[i-1]的位置lSide[i-1]
            while (tmp>=0 && heights[tmp]>=heights[i]){
                tmp=lSide[tmp];
            }
            lSide[i]=tmp;
        }
        // 以i为中心，向右找到第一个小于heights[i]的位置rSide[i]
        for (int i = len-2; i >= 0; i--) {
            int tmp=i+1;
            while (tmp<len && heights[tmp]>=heights[i]){
                tmp=rSide[tmp];
            }
            rSide[i]=tmp;
        }

        for (int i = 0; i < len; i++) {
            //以heights[i]为高的矩形的宽度值  （rSide[i]-1）-（lSide[i]+1）+1=rSide[i]-lSide[i]-1
            res=Math.max(res,(rSide[i]-lSide[i]-1)*heights[i]);
        }
        return res;
    }
}
