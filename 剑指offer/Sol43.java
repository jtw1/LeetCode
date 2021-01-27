/**
 * @Description 1～n 整数中 1 出现的次数 p221
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 题解 https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
 * @date 2021/1/27 0027-9:38
 */
public class Sol43 {
    public int countDigitOne(int n) {
        //将 1 ~ n 的个位、十位、百位、...的 1 出现次数相加，即为 1 出现的总次数
        // TC:O(logn) SC:O(1)
        int digit=1;    //位因子
        int high=n/10;  //高位  例如2304，此时的高位是230
        int low=0;      //低位， 此时的低位为0
        int cur=n%10;   //当前位  初始当前位是4
        int res=0;
        //当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
        while(high!=0 || cur!=0){
            if(cur==0) res += high*digit;
            else if(cur==1) res += high*digit+low+1;
            else res += (high+1)*digit;

            low += cur*digit;  //将 cur 加入 low ，组成下轮 low
            cur = high%10;  // 下轮 cur 是本轮 high 的最低位
            high /= 10;    // 将本轮 high 最低位删除，得到下轮 high
            digit *= 10;   // 位因子每轮 × 10
        }
        return res;
    }
}
