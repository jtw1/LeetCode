// 977 有序数组的平方
// https://leetcode-cn.com/problems/squares-of-a-sorted-array/

class Solution {
    public int[] sortedSquares(int[] A) {
        if(A==null || A.length==0) return A;
        
        //法一：TC：O(nlogn)  SC:O(logn)  
        for(int i=0;i<A.length;i++){
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
        
        //法二：TC：O(n)  SC:O(1)  
        int n=A.length;
        int[] ans = new int[n];
        for(int i=0,j=n-1,pos=n-1;i<=j;){
            if(A[i]*A[i]>A[j]*A[j]){
                ans[pos]=A[i]*A[i];
                i++;
            }else{
                ans[pos]=A[j]*A[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
