package LeetCodeTest;
import java.util.Scanner;

public class Huiwenshu 
{
    public static void main(String[] args) {
        System.out.print("请输入一个数：");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        boolean result= isPalindrome(x);
        System.out.println(result);
        sc.close();
    }
    //math method one 将数字对折看能否一一对应
    /*public static boolean isPalindrome(int x) {
        if (x<0||(x%10==0&&x!=0))    return false;
        int ReverseNumber=0;
        while (x>ReverseNumber) {
            ReverseNumber=ReverseNumber*10+x%10;
            x /= 10;
        }
        return x==ReverseNumber|| x==ReverseNumber/10;
        //第一种条件是x为偶数位是，例如1221，退出while时x=12=ReverseNumber
        //第一种条件是x为奇数位时，例如12321，退出while时x=12，ReverseNumber=123
    }*/

     //math method two 
    /*public static boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;  //直到x/div < 10时，才结束循环
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }*/
    
    //method three 将x整个翻转
    public static boolean isPalindrome(int x) {
        String ReverseString=new StringBuilder(x+"").reverse().toString();
        return (x+"").equals(ReverseString);
    }
}