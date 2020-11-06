import java.util.*;

/**
 * @Description  [1356] 根据数的二进制下1的数目排序
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * @date 2020/11/6 0006-9:20
 */
public class Sol1356 {
    public static void main(String[] args) {
        int[] arr=new int[]{2,3,5,7,11,13,13,17,19};
        arr=sortByBits(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    //法一：暴力法
    //TC:O(nlogn)   SC:O(n)
    public static int[] sortByBits(int[] arr) {
        if(arr==null || arr.length==0) return arr;

        int[] bits=new int[10001];
        List<Integer> list=new ArrayList<>();
        //法一：暴力法  （12ms）
//        for (int tep : arr) {
//            list.add(tep);
//            bits[tep]=countBits(tep);
//        }
        //法二，线性预处理(9ms)
        for (int x : arr) {
            list.add(x);
        }
        for (int i = 0; i <= 10000; i++) {
            bits[i]=bits[i>>1]+(i&1);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(bits[o1]!=bits[o2]){
                    return bits[o1]-bits[o2];
                }else{
                    return o1-o2;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
    //法三
    //TC:O(nlogn)   SC:O(1)
    //执行用时：3 ms, 在所有 Java 提交中击败了100.00%的用户
    //内存消耗：38.6 MB, 在所有 Java 提交中击败了92.41%的用户
    public static int[] sortByBits1(int[] arr){
        if(arr==null || arr.length==0) return arr;
        //根据 1的个数 和 当前数值，存储 每一个数字：
        //此处是本题解的精髓：1的个数权值最大，其次是本身的值，方便之后的 还原和排序
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.bitCount(arr[i])*100000+arr[i];
        }
        //将 存储的数字，还原成最初始的数字，并根据 1的个数 和 当前数值 排序
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100000;
        }
        return arr;
    }

    /**
     * 计算二进制数中1的位数
     * @param num
     * @return
     */
    private static int countBits(int num){
        int count=0;
        while(num>0){
            if(num%2==1){
                count++;
            }
            num >>= 1;
        }
        return count;
    }
}
