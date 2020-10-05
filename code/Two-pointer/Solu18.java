package LeetCodeTest;
/**
 * [18] 四数之和 https://leetcode-cn.com/problems/4sum/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solu18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null || nums.length<4) return res;
        int len = nums.length;
        Arrays.sort(nums); //对数组排序

        for(int i=0;i<len-3;i++){
            //剪枝
            if(i>0 && nums[i]==nums[i-1]) continue; //相邻元素重复
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break; //确定第一个数之后，如果满足此条件，后面的肯定大于target，退出此重循环
            if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target) continue; //确定第一个数之后，如果满足此条件，后面的肯定小于target，因此进入下一轮循环，枚举nums[i+1]

            for(int j=i+1;j<len-2;j++){
                //剪枝
                if(j>i+1 && nums[j]==nums[j-1]) continue; //相邻元素重复
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break; //确定第一个和第二个数之后，如果满足此条件，后面的肯定大于target，退出此重循环
                if(nums[i]+nums[j]+nums[len-1]+nums[len-2]<target) continue; //确定第一个数之后，如果满足此条件，后面的肯定小于target，因此进入下一轮循环，枚举nums[j+1]

                int left=j+1,right=len-1;
                while(left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //遇到满足条件的四个数了，将左指针右移，直到遇到不同的数
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        left++; //经过上一个while循环之后，左指针实际上是移到了最后一个相同的数，所以需要再移动一位，移到不同的数上面 例如：[2,2,2,3,4,5] 经过上一个while循环之后，左指针实际上是移到了最后一个2 所以为了避免重复需要再移动一位 
                        //将右指针左移，直到遇到不同的数
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        right--; //同理
                    }else if(sum>target){
                        right--; //和大于target，右指针左移
                    }else{
                        left++;  //和小于target，左指针右移
                    }
                }
            }
        }
        return res;
    }
}
