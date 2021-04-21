package 笔试题.Tencent;

import java.util.Arrays;

/**
 * @Description 2021 4.4 笔试题  过河问题
 * 思路解析 https://blog.csdn.net/qq_36306833/article/details/68941731
 * 题目及题解 https://blog.csdn.net/phdongou/article/details/115449435
 * @date 2021/4/20 0020-10:06
 */
public class CrossRiver {
    private int minCost(int[] nums){
        /**
         * 每次过河时间取决于时间长的那个人
         * 先送最慢的两个人，用最快的两人帮助运送其他人
         */
        int res=0;
        int len=nums.length;
        Arrays.sort(nums);
        while (true){
            if(len==1) return nums[0];
            if(len==2) return res+Math.max(nums[0],nums[1]);
            if(len==3) return res+nums[0]+nums[1]+nums[2];
            //
            /**
             * 最快的那个人(序号为0)分两次带最慢的两个人(序号为len-1，len-2)过河
             * (0,len-1)--->0送len-1过来，所花时间为nums[len-1]
             * 0<---len-1  0返回，所花时间为nums[0]
             * (0,len-2)--->0送len-2过来,所花时间为nums[len-2]
             * 0<---len-1,len-2  0返回，所花时间为nums[0]
             * 总共花的时间为  2*nums[0]+nums[len-1]+nums[len-2];
             */
            int cost1=2*nums[0]+nums[len-1]+nums[len-2];

            /**
             * 如果最慢的两个人过河都需要很长时间，那就让他们两个一起过河
             * 最快的和第二快的那个人(序号为0，1)负责运船，最慢的两个人(序号为len-1，len-2)一起过河
             * (0,1)--->0留下，所花时间为nums[1]
             * 1<---0   1返回，所花时间为nums[1]
             * (len-2,len-1)--->0   len-2,len-1过来，所花时间为nums[len-1]
             * 0，1<---len-1,len-2  0把船送回去，所花时间为nums[0]
             * 总共花的时间为  2*nums[1]+nums[len-1]+nums[0];
             */
            int cost2=2*nums[1]+nums[len-1]+nums[0];
            len-=2;
            res += Math.min(cost1,cost2);
        }
    }
}
