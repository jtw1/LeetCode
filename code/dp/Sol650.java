import java.util.Arrays;

/**
 * @Description 650 只有两个键的键盘
 * https://leetcode-cn.com/problems/2-keys-keyboard/
 * 题解 https://leetcode-cn.com/problems/2-keys-keyboard/solution/dong-tai-gui-hua-jie-fa-by-reconcile-t3fr/
 * 素数分解 https://leetcode-cn.com/problems/2-keys-keyboard/solution/cong-di-gui-dao-su-shu-fen-jie-by-fuxuemingzhu/
 * @date 2021/5/25 0025-10:52
 */
public class Sol650 {
    public int minStep(int n){
        if(n==1) return 0;
        int[] dp=new int[n+1];   //dp[i]:得到i个A需要的最少操作次数
        Arrays.fill(dp,n+1);
        dp[1]=0;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                // 如果i整除j，则由j个A得到i个A（一次复制，(i/j)-1次粘贴）
                if(i%j == 0) dp[i]=Math.min(dp[i],dp[j]+i/j);
            }
        }
        return dp[n];
    }


    public int minSteps(int n) {
        /**
         * n是素数时，只能复制一次，然后粘贴n-1次得到n个A，操作次数为n
         * n不是素数时，假设n=i*j,可以先得到i个A，复制 1 次，然后再粘贴 j - 1次，得到n个A
         *             操作次数为  minSteps(i)+1+j-1=minSteps(n/j)+j;
         */
        if(n==1) return 0;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return i+minSteps(n/i);
        }
        return n;
    }
}
