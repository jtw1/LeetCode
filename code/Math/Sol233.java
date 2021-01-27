/**
 * @Description 233 数字1的个数
 * https://leetcode-cn.com/problems/number-of-digit-one/
 * @date 2021/1/27 0027-14:20
 */
public class Sol233 {
    public int countDigitOne(int n) {
        //将 1 ~ n 的个位、十位、百位、...的 1 出现次数相加，即为 1 出现的总次数
        // TC:O(logn) SC:O(1)
        int digit=1;    //位因子
        int high=n/10;  //高位  例如2304，此时的高位是230
        int low=0;      //低位， 此时的低位为0
        int cur=n%10;   //当前位  初始当前位是4
        int res=0;

        while(high!=0 || cur!=0){
            if(cur==0) res += high*digit;
            else if(cur==1) res += high*digit+low+1;
            else res += (high+1)*digit;

            low += cur*digit;
            high /= 10;
            cur = high%10;
            digit *= 10;
        }
        return res;
    }
}
