package LeetCodeTest;

public class Solu258 {
    public int addDigits(int num) {
        // if(num<10) return num;
        // int sum=0;
        // while (num>=10) {
        //     while (num!=0) {
        //         sum += num%10;
        //         num /= 10;

        //     }
        //     num=sum;
        // }
        // return num;

        //法二
        return (num-1)%9+1;
    }
}