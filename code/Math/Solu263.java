package LeetCodeTest;
// [263] 丑数
// https://leetcode-cn.com/problems/ugly-number/description/

// import java.util.Arrays;
// import java.util.HashSet;

public class Solu263 {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        int[] arr = new int[]{2,3,5};
        for (int i : arr) {
            while(num%i==0){
                num /= i;
            }
        }
        return num==1;
        
        //超时
        // HashSet<Integer> set = new HashSet<>();
        // //int[] arr=new int[]{2,3,5};
        // set.add(2);
        // set.add(3);
        // set.add(5);
        // int driver = 2;
        // while(num!=1){
        //     if(num%driver==0){
        //         if(!set.contains(driver)) return false;
        //         num /= driver;
        //         driver++;
        //     }else{
        //         driver++;
        //     }
        // }
        // return true;
    }
}