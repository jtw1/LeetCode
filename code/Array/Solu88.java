package LeetCodeTest;
//[88] 合并两个有序数组

// https://leetcode-cn.com/problems/merge-sorted-array/description/

import java.util.Arrays;

public class Solu88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        Solu88.merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]+" ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //法一   时间复杂度O（(m+n)log(m+n)）      空间复杂度O（1）
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

        //法二：双指针，从前往后
        //时间复杂度O（m+n）      空间复杂度O（m）
        int[] nums_copy = new int[m];
        System.arraycopy(nums1, 0, nums_copy, 0, m);   //复制数组nums1到nums_copy

        int p1=0;
        int p2=0;       //指向数组nums_copy,nums2的指针，
        int p=0;        //指向数组nums1的指针

        //在每一步将最小值放入输出数组中。
        while (p1<m && p2<n) {
            nums1[p++] = (nums_copy[p1]<nums2[p2]? nums_copy[p1++]:nums2[p2]);
        }

        //看数组中是否还有残留
        if (p1<m) {
            System.arraycopy(nums_copy, p1, nums1, p1+p1, m+n-p1-p2);
        }
        if (p2<n) {
            System.arraycopy(nums2, p2, nums1, p1+p1, m+n-p1-p2);
        }

        //法三：双指针，从后往前,因为 nums1 的空间都集中在后面，所以从后向前处理排序的数据会更好，节省空间，一边遍历一边将值填充进去
        int l1=m-1;
        int l2=n-1;       //指向数组nums1,nums2的指针，
        int l=m+n-1; 

        while (l1>=0 && l2>=0) {
            nums1[l--] = (nums1[l1]>nums2[l2]? nums1[l1--]:nums2[l2--]);
        }

        System.arraycopy(nums2, 0, nums1, 0, l2+1);


    
        //     List<Integer> list = new ArrayList<>();
    //     for (int i = 0; i < m; i++) {
    //         list.add(nums1[i]);
    //     }

    //     int k = 0;
    //     while (k<n) {
    //         for (int j = 0; j < m+n; ) {
    //             int x = nums1[n-1];
    //             while (nums2[k]>nums1[j] && nums2[k]<=x) {
    //                 j++;
    //             }
    //             list.add(j, nums2[k]);
    //             k++;
    //             j++;
    //         }
    //     }
    //     for (int i = 0; i < nums1.length; i++) {
    //         nums1[i] = list.get(i);
    //     }
           

    }
}