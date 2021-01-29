/**
 * @Description 264 丑数
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * @date 2021/1/29 0029-10:07
 */
public class Sol264 {
    public Ugly u=new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n-1];
    }
}

class isUgly{
    public int[] nums=new int[1690];
    isUgly(){
        int ugly,i2=0,i3=0,i5=0;
        nums[0]=1;
        for (int i = 1; i < 1690; i++) {
            ugly=Math.min(Math.min(nums[i2]*2,nums[i3]*3),nums[i5]*5);
            nums[i]=ugly;

            if(ugly==nums[i]*2) i2++;
            if(ugly==nums[i]*3) i3++;
            if(ugly==nums[i]*5) i5++;
        }
    }
}
