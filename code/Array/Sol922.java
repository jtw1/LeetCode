/**
 * @Description [922] 按奇偶排序数组II
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * @date 2020/11/12 0012-9:29
 */
public class Sol922 {
    public static void main(String[] args) {
        int[] A=new int[]{4,2,5,7};
        sortArrayByParityII(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
    }
    public static int[] sortArrayByParityII(int[] A) {
        //双指针  TC:O(n)  SC:O(1)
        if(A==null || A.length==0) return A;
        int odd=1;
        int len=A.length;
        for (int even = 0; even < len; even+=2) {
            if(A[even]%2==1){
                while (A[odd]%2==1){
                    odd+=2;
                }
                int tmp=A[even];
                A[even]=A[odd];
                A[odd]=tmp;
            }
        }
        return A;
    }
}
