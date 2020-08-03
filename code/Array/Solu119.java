package LeetCodeTest;

import java.util.ArrayList;
import java.util.List;

// [119] 杨辉三角 II
// https://leetcode-cn.com/problems/pascals-triangle-ii/description/
public class Solu119 {
    public List<Integer> getRow(int rowIndex) {
        
        //利用杨辉三角的通项公式
        //n为行数,i为每行的下标，均从0开始
        //第n行，第i个元素C(n,i)=n!/(i!*(n-i)!)
        //第i+1个元素是第i个元素的(n-i)/(i+1)倍
        List<Integer> arr = new ArrayList<>(rowIndex+1);
        long cur=1;
        for (int i = 0; i <= rowIndex; i++) {
            arr.add((int)cur);
            cur = cur*(rowIndex-i)/(i+1);
        }
        return arr;
        

        //法二，从后往前更新
        // List<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // for (int i = 1; i <= rowIndex; i++) {
        //     for (int j = i-1; j > 0; j--) {
        //         arr.set(j, arr.get(j-1)+arr.get(j));
        //     }
        //     arr.add(1);  //每层最后补1
        // }
        // return arr;


        // List<Integer> arr = new ArrayList<>();
        // if (rowIndex==0 || rowIndex<0) {
        //     arr.add(1);
        //     return arr;
        // }

        // arr.add(1);
        // for (int i = 1; i < rowIndex-1; i++) {
        //     arr.add(getRow(rowIndex-1).get(i-1)+getRow(rowIndex-1).get(i));
        // }
        // arr.add(1);
        // return arr;

        
    }
}