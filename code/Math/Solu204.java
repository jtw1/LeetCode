package LeetCodeTest;

import java.util.Arrays;

// [204] 计数质数
// https://leetcode-cn.com/problems/count-primes/description/
public class Solu204 {
    public int countPrimes(int n) {
        // int count=0;
        // while(n>0){
        //     if(isPrime(n)) count++;
        //     n--;
        // }
        // return count;

        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++){
            //先对2-(根号n)每个都遍历一遍
            if (isPrim[i]){
                //i的整数倍肯定不是指数，标记为false
                for (int j = i * i; j < n; j += i){
                    isPrim[j] = false;
                } 
            } 
        } 
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;
        return count;
    }

    // private boolean isPrime(int n){
    //     if(n==1 || n%2==0&&n!=2) return false;
    //     boolean flag=true;
    //     for (int i = 3; i < Math.sqrt(n); i += 2) {
    //         if (n%i==0) {
    //             flag=false;
    //             break;
    //         }
    //     }
    //     return flag;
    // }
}