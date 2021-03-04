/**
 * @Description 42 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @date 2021/3/4 0004-10:10
 */
public class Solu42 {
    /**
     * 法一 暴力法  TC:O(n^2) SC:O(1)
     * 对数组的每个元素，找出下雨后水能达到的最高位置，等于两边的最大高度left,right的较小值减去当前高度的值
     */

    // 法二 动态编程  TC:O(n) SC:O(n)
    // 与法一大概思路一致，就是将每个元素左右两边高度的最大值分别存储在两个数组里面
    public int trap(int[] height){
        if(height==null || height.length<=2) return 0;
        int ans=0;
        int len=height.length;
        //分别记录每根柱子左边高度最大值和右边高度最大值
        int[] left_max=new int[len];
        int[] right_max=new int[len];
        //分别给left_max，right_max赋值
        left_max[0]=height[0];
        for (int i = 1; i < len; i++) {
            left_max[i]=Math.max(height[i],left_max[i-1]);
        }
        right_max[len-1]=height[len-1];
        for (int i = len-2; i >= 0; i--) {
            right_max[i]=Math.max(height[i],right_max[i+1]);
        }
        //柱子的最左和最右那根只能当作边界，所以遍历的下标范围是[1,len-2]
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(left_max[i],right_max[i])-height[i];
        }
        return ans;
    }

    /**
     * 法三 双指针  TC:O(n) SC:O(1)
     * 法二中注意到，right_max[i]>left_max[i]或right_max[i]<left_max[i]时，
     * 积水高度由较小的那个决定
     */
    public int trap1(int[] height){
        if(height==null || height.length<=2) return 0;
        int ans=0;
        int left=0,right=height.length-1;
        // 实时维护每根柱子左边高度最大值和右边高度最大值
        int left_max=0,right_max=0;
        while (left<right){
            if(height[left] < height[right]){
                // 当前柱子高度大于left_max，更新left_max
                if(height[left]>=left_max){
                    left_max=height[left];
                }
                // 当前柱子高度小于left_max，说明当前柱子可以存水，将当前柱子存水量添加到ans中
                else{
                    ans += (left_max-height[left]);
                }
                ++left;
            }else{
                if(height[right]>=right_max){
                    right_max=height[right];
                }else{
                    ans += (right_max-height[right]);
                }
                right--;
            }
        }
        return ans;
    }

    /**
     * 法四 韦恩图解法  TC:O(n) SC:O(1)
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/wei-en-tu-jie-fa-zui-jian-dan-yi-dong-10xing-jie-j/
     */
    public int trap2(int[] height){
        int len=height.length;
        int s1=0,s2=0,sum=0;
        int max_left=0,max_right=0;
        for (int i = 0; i < len; i++) {
            if(height[i] > max_left){
                max_left=height[i];
            }
            if(height[len-i-1] > max_right){
                max_right=height[len-i-1];
            }

            s1 += max_left;
            s2 += max_right;
            sum += height[i];
        }
        return s1+s2-max_left*len-sum;
    }
}
