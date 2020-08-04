package LeetCodeTest;

//import java.util.HashSet;

public class Solu202 {
    
    public boolean isHappy(int n) {
        //法一 数学方法 所有不快乐数的平方和计算，都会进入4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
        // int statues=n;
        // while (true) {
        //     statues=getResult(statues);
        //     if (statues==1) {
        //         return true;
        //     }
        //     if (statues==4) {
        //         return false;
        //     }
        // }

        //法二，利用HashSet检测环
        //TC:O(logn)  SC:O(logn)
        // HashSet<Integer> set = new HashSet<>();
        // while (n!=1 && !set.contains(n)) {
        //     set.add(n);
        //     n=getResult(n);
        // }
        // return n==1;

        //法三，快慢指针
        //TC:O(logn)  SC:O(1)
        int slowRunner=n;
        int fastRunner=getResult(n);
        while (n!=1 && slowRunner!=fastRunner) {
            slowRunner=getResult(slowRunner);
            fastRunner=getResult(getResult(fastRunner));
        }
        return fastRunner==1;
    }
    private int getResult(int n){
        int sum=0;
        while (n!=0) {
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }

}