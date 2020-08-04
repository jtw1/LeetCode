package LeetCodeTest;
// [168] Excel表列名称
// https://leetcode-cn.com/problems/excel-sheet-column-title/description/
public class Solu168 {
    //相当于26进制转换问题，与普通26进制不同的是，这里的每一位是1-26，而不是0-25
    public String convertToTitle(int n) {
        StringBuilder currString = new StringBuilder();
        while (n>0) {
            int temp = n%26;
            //n能被26整除时，说明最低位肯定是Z，所以这里需要设temp=26，并将当前值-1，确保算下一位的时候，n/26操作正好可以舍弃低位
            if (temp==0) {
                temp=26;
                n -= 1;
            }
            char c=(char)(temp+64);
            currString.insert(0, c);
            n = n/26;
        }
        return currString.toString();
    }
}