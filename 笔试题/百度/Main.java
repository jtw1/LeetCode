package 百度;

import java.util.Scanner;

/**
 * @Description
 * @date 2021/4/11-19:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int res=shortDistance(a,b);
            System.out.println(res);
        }
    }

    private static int shortDistance(int a, int b) {
        if(a==b) return 0;
        int res=0;
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        if((max/min)==2) return 1;
        while (max!=1 && min!=1){
            max /= 2;
            min /= 2;
            res+=2;
            if((max/res)==2){
                res +=1;
                return res;
            }
        }
        while(max!=1){
            max /= 2;
            res++;
        }
        while(min!=1){
            min /= 2;
            res++;
        }
        return res;
    }
}
