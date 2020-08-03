package LeetCodeTest;
// [118] 杨辉三角
// https://leetcode-cn.com/problems/pascals-triangle/description/
import java.util.ArrayList;
import java.util.List;

public class Solu118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // 动态规划：TC:O(numRows^2)  SC:O(numRows^2)
        if(numRows==0) return triangle;
        //第一行都是[1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        //rowNum = 1对应第二行
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> Arr = new ArrayList<>();   //当前行
            List<Integer> preArr = triangle.get(rowNum-1);  //当前行的上一行

            Arr.add(1);  //第一个元素都是1

            for (int i = 1; i < rowNum; i++) {
                Arr.add(preArr.get(i)+preArr.get(i-1));
            }

            Arr.add(1);   //最后一个元素都是1
            triangle.add(Arr);
        }
        return triangle;

        //递归
        // List<List<Integer>> triangle = new ArrayList<>();
        // if(numRows==0)  return triangle;
        // if (numRows==1) {
        //     triangle.add(new ArrayList<>());
        //     triangle.get(0).add(1);
        //     return triangle;
        // }

        // triangle=generate(numRows-1);
        // List<Integer> Arr = new ArrayList<>();   //最后一行
        // Arr.add(1);

        // for (int i = 1; i < numRows-1; i++) {
        //     Arr.add(triangle.get(numRows-2).get(i)+triangle.get(numRows-2).get(i-1));
        //     //行数为numRows时，数组中最后一行下标为numRows-1，所以上一行的下标为numRows-2
        // }

        // Arr.add(1);
        // triangle.add(Arr);

        // return triangle;
    }
}