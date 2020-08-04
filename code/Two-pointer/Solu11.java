package LeetCodeTest;
// [11] 盛最多水的容器
// https://leetcode-cn.com/problems/container-with-most-water/description/
public class Solu11 {
    public int maxArea(int[] height) {
        if(height==null || height.length<2) return 0;
        int l=0,r=height.length-1,maxArea=0;
        while (l<r) {
            maxArea=(height[l]<height[r])? Math.max(maxArea, (r-l)*height[l++]):
                                           Math.max(maxArea, (r-l)*height[r--]);
        }
        return maxArea;
    }
}