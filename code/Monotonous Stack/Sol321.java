/**
 * @Description [321] 拼接最大数
 * https://leetcode-cn.com/problems/create-maximum-number/
 * @date 2020/12/24 0024-9:14
 */
public class Sol321 {
    public static void main(String[] args) {
        int[] nums1=new int[]{3, 4, 6, 5};
        int[] nums2=new int[]{9, 1, 2, 5, 8, 3};
        int[] res=maxNumber(nums1,nums2,5);

    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k){
        int m=nums1.length,n=nums2.length;
        int[] maxSubsequence=new int[k];
        int start=Math.max(0,k-n),end=Math.min(k,m);
        for (int i = start; i <= end; i++) {
            int[] subsequence1=maxSubsequence(nums1,i);
            int[] subsequence2=maxSubsequence(nums2,k-i);
            int[] curMaxSubsequence=merge(subsequence1,subsequence2);
            if(compare(curMaxSubsequence,0,maxSubsequence,0)>0){
                System.arraycopy(curMaxSubsequence,0,maxSubsequence,0,k);
            }
        }
        return maxSubsequence;
    }

    /**
     * 求一个序列的长度为k的最大子序列
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSubsequence(int[] nums,int k){
        int len=nums.length;
        int[] stack=new int[k];
        int top=-1,remain=len-k;  //top相当于栈顶,remain：nums数组中要删除的数的个数
        for (int i = 0; i < len; i++) {
            int num=nums[i];
            while(top>=0 && stack[top]<num && remain>0){
                top--;
                remain--;
            }
            if(top<k-1){
                stack[++top]=num;
            }else{
                remain--;
            }
        }
        return stack;
    }

    /***
     * 合并两个序列成为一个数值较大的序列
     * @param subsequence1
     * @param subsequence2
     * @return
     */
    public static int[] merge(int[] subsequence1,int[] subsequence2){
        int len1=subsequence1.length,len2=subsequence2.length;
        if(len1==0) return subsequence2;
        if(len2==0) return subsequence1;

        int mergeLength=len1+len2;
        int[] merged=new int[mergeLength];
        int index1=0,index2=0;
        for (int i = 0; i < mergeLength; i++) {
            if(compare(subsequence1,index1,subsequence2,index2)>0){
                merged[i]=subsequence1[index1++];
            }else{
                merged[i]=subsequence2[index2++];
            }
        }
        return merged;
    }

    /**
     * 比较两个序列对应位置数的大小
     * @param subsequence1
     * @param index1
     * @param subsequence2
     * @param index2
     * @return
     */
    public static int compare(int[] subsequence1,int index1,int[] subsequence2,int index2){
        int len1=subsequence1.length,len2=subsequence2.length;
        while(index1<len1 && index2<len2){
            int difference=subsequence1[index1]-subsequence2[index2];
            if(difference!=0) return difference;
            index1++;
            index2++;
        }
        return (len1-index1)-(len2-index2);
    }
}
