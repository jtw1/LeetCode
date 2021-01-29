/**
 * @Description 49 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * @date 2021/1/29 0029-9:27
 */
public class Sol49 {
    public Ugly u=new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n-1];
    }

    public int nthUglyNumber1(int n) {
        int p2=0,p3=0,p5=0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            if(dp[i]==dp[p2]*2) p2++;
            if(dp[i]==dp[p3]*3) p3++;
            if(dp[i]==dp[p5]*5) p5++;
        }
        return dp[n-1];
    }
}
class Ugly{
    public int[] nums=new int[1690];
    Ugly(){
        int ugly,i2=0,i3=0,i5=0;
        nums[0]=1;
        for (int i = 1; i < 1690; i++) {
            ugly=Math.min(Math.min(nums[i2]*2,nums[i3]*3),nums[i5]*5);
            nums[i]=ugly;
            // 用了if而不是if else，可以让重复的值比如6时,i2和i3都加一，避免了出现两个6
            if(ugly==nums[i2]*2) i2++;
            if(ugly==nums[i3]*3) i3++;
            if(ugly==nums[i5]*5) i5++;
        }
    }
}
