/**
 * @Description 面试题10 斐波那契数列 p76
 * @date 2020/12/10 0010-10:27
 */
public class Sol10 {
    public int fib(int n) {
        int[] res={0,1};
        if(n<2) return res[n];

        int fibNMinusOne=1;
        int fibNMinusTwo=0;
        int fibN=0;
        for (int i = 2; i <= n; i++) {
            fibN=(fibNMinusOne+fibNMinusTwo)%1000000007;
            fibNMinusTwo=fibNMinusOne;
            fibNMinusOne=fibN;
        }
        return fibN;
    }
}
