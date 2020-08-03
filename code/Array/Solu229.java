package LeetCodeTest;
// [229] 求众数 II
// https://leetcode-cn.com/problems/majority-element-ii/description/
import java.util.ArrayList;
import java.util.List;

public class Solu229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;

        //投票过程（个数大于n/3的数最多两个），所以先找出两个备选数
        int candidate1=0,candidate2=0;  //初始化两个备选数，对应出现次数设为0
        int cnt1=0,cnt2=0;
        for (int num : nums) {
            //当前数和备选数1相等，对应出现次数+1
            if (num==candidate1) {
                cnt1++;
                continue;
            }
            //当前数和备选数2相等，对应出现次数+1
            if (num==candidate2) {
                cnt2++;
                continue;
            }
            //当前数和备选数1，2都不相等，且备选数1的次数为0时，将当前数赋值给备选数1
            if (cnt1==0) {
                candidate1=num;
                cnt1++;
                continue;
            }
            //备选数1的次数不为0，备选数2的次数为0时，将当前数赋值给备选数2
            if (cnt2==0) {
                candidate2=num;
                cnt2++;
                continue;
            }
            // 如果cand1和cand2的数量都不为0，那就都-1
            cnt1--;
            cnt2--;
        }

        //检查两个票数是否符合
        cnt1=0;
        cnt2=0;

        for (int num : nums){
            if(num==candidate1){
                cnt1++;
            }else if (num==candidate2) {
                cnt2++;
            }//这一部分必须用else if而不能用if，否则对于例子[0,0,0],最后输出的res会是[0,0]
        }
        int n=nums.length;
        if(cnt1 > n/3) res.add(candidate1);
        if(cnt2 > n/3) res.add(candidate2);

        return res;
    }
}