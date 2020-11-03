//[844] 比较含退格的字符串
// https://leetcode-cn.com/problems/backspace-string-compare/submissions/

class Sol844 {
    public boolean backspaceCompare(String S, String T) {
        //双指针 TC：O(m+n)  SC:O(1)
        int i = S.length() - 1, j = T.length() - 1; //指向S和T末尾的指针，从后往前遍历
        int skipS = 0, skipT = 0;  //S和T中需要删除的字符个数

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;  //遇到'#'，skipS+1,同时指针前移
                    i--;
                } else if (skipS > 0) {
                    skipS--;  //skipS>0,说明当前还有要删除的字符，指针前移，并将skipS-1
                    i--;
                } else {
                    break;  //否则推出循环
                }
            }
            //与S同理
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;  //执行完一次删除操作后，S和T所遍历的当前字符不同，最后肯定不同，返回false
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;  //最后i,j一个为0，一个不为0，所以S和T最终的长度不同，返回false
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
