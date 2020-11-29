import java.util.Arrays;

/**
 * @Description  [164] 最大间距
 * https://leetcode-cn.com/problems/maximum-gap/
 * @date 2020/11/26 0026-9:30
 */
public class Sol164 {
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        //法一  基数排序   https://baike.baidu.com/item/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F
        //TC:O(kn)  SC:O(n)  k是最大数字的位数
        int len=nums.length;
        long exp=1;
        int[] buf=new int[len];
        //获取nums数组中最大值
        int maxVal= Arrays.stream(nums).max().getAsInt();
        while(maxVal>=exp){
            int[] cnt=new int[10];
            //首先根据个位数的数值，在走访数值时将它们分配至编号0到9的桶子中,第二次根据十位的。。。
            for (int i = 0; i < len; i++) {
                int digit=(nums[i]/(int)exp) % 10;
                cnt[digit]++;
            }
            //接下来将这些桶子中的数值重新串接起来，成为以下的数列
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i-1];
            }
            for (int i = len-1; i >= 0; i--) {
                int digit=(nums[i]/(int)exp) % 10;
                buf[cnt[digit]-1] = nums[i];
                cnt[digit]--;
            }
            //将buf中的数据复制到num中
            System.arraycopy(buf,0,nums,0,len);
            exp *= 10;
        }

        int ret=0;
        for (int i = 1; i < len; i++) {
            ret=Math.max(ret,nums[i]-nums[i-1]);
        }
        return ret;

        //法二  sort排序再比较
        //TC:O(nlogn) beat 99.76%    SC:O(logn)
//        Arrays.sort(nums);
//        int ret=0;
//        for (int i = 1; i < len; i++) {
//            ret=Math.max(ret,nums[i]-nums[i-1]);
//        }
//        return ret;
    }

    //法三：桶排序
    //https://leetcode-cn.com/problems/maximum-gap/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--39/
    public int maximumGap3(int[] nums){
        if (nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        //最大值，最小值
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
//        int min = nums[0];
//        int max = nums[0];
//        //找出最大值、最小值
//        for (int i = 1; i < n; i++) {
//            min = Math.min(nums[i], min);
//            max = Math.max(nums[i], max);
//        }
        if(max - min == 0) {
            return 0;
        }

        //相邻数字的最大间距不会小于interval
        int interval = (int) Math.ceil((double)(max - min) / (n - 1));

        //每个箱子里数字的最小值和最大值
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];

        //最小值初始为 Integer.MAX_VALUE
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        //最大值初始化为 -1，因为题目告诉我们所有数字是非负数
        Arrays.fill(bucketMax, -1);

        //考虑每个数字
        for (int i = 0; i < nums.length; i++) {
            //当前数字所在箱子编号
            int index = (nums[i] - min) / interval;
            //最大数和最小数不需要考虑
            if(nums[i] == min || nums[i] == max) {
                continue;
            }
            //更新当前数字所在箱子的最小值和最大值
            bucketMin[index] = Math.min(nums[i], bucketMin[index]);
            bucketMax[index] = Math.max(nums[i], bucketMax[index]);
        }
        //maxGap表示桶之间的最大间距
        int maxGap = 0;
        //min 看做前一个箱子的最大值
        int previousMax = min;
        //从第 0 个箱子开始计算
        for (int i = 0; i < n - 1; i++) {
            //最大值是 -1 说明箱子中没有数字，直接跳过
            if (bucketMax[i] == -1) {
                continue;
            }

            //当前箱子的最小值减去前一个箱子的最大值
            maxGap = Math.max(bucketMin[i] - previousMax, maxGap);
            previousMax = bucketMax[i];
        }
        //最大值可能处于边界，不在箱子中，需要单独考虑
        maxGap = Math.max(max - previousMax, maxGap);
        return maxGap;
    }

}
