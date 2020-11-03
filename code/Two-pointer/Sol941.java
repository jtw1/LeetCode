import java.util.Scanner;

/**
 * @Description [941] 有效的山脉数组
 * https://leetcode-cn.com/problems/valid-mountain-array/
 * @date 2020/11/3 0003-9:16
 */
public class Sol941 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int n=scan.nextInt();
        int[] A=new int[n];
        System.out.print("请输入数组元素：");
        for (int i = 0; i < n; i++) {
            A[i]=scan.nextInt();
        }
        boolean res = validMountainArray(A);
        boolean res1 = validMountainArray1(A);
        System.out.println("双指针法："+res);
        System.out.println("线性扫描法："+res1);
    }
    //法一：双指针法
    //TC:O(n)   SC:O(1)
    public static boolean validMountainArray(int[] A) {
        int len=A.length;
        if(len<3) return false;
        int i=0,j=len-1;
        while(i<len-1 && A[i]<A[i+1]){
            i++;
        }
        while(j>0 && A[j-1]>A[j]){
            j--;
        }
        if(i==j && i!=0 && j!=len-1){ return true;}
        return false;
    }

    //法二：线性扫描
    //TC:O(n)   SC:O(1)
    public static boolean validMountainArray1(int[] A){
        int len1=A.length;
        if(len1<3) return false;
        int i=0;
        //上坡扫描
        while(i<len1-1 && A[i]<A[i+1]){
            i++;
        }
        //最高点不能是两边端点
        if(i==0 || i==len1-1) return false;
        //下坡扫描
        while(i<len1-1 && A[i]>A[i+1]){
            i++;
        }
        return i==len1-1;
    }
}
