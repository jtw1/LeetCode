package LeetcodeTest;
// [374] 猜数字大小
// https://leetcode-cn.com/problems/guess-number-higher-or-lower/
public class Solu374 {
    public int guessNumber(int n) {
        if(n==1) return 1;
        int left=1,right=n;
//        while(left<right){
//            int mid=left+(right-left)/2;
//            if(guess(mid)==-1) right=mid;
//            else if(guess(mid)==1) left=mid+1;
//            else if(guess(mid)==0) return mid;
//        }
        return left;
    }
}

class GuessGame {

    private static final int NUM = 6;

    int guess(int num) {
        if (num == NUM) {
            return 0;
        } else if (num < NUM) {
            return -1;
        }
        return 1;
    }
}

