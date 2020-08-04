package LeetCodeTest;

//[345] 反转字符串中的元音字母
// https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/

public class Solu345 {
    public String reverseVowels(String s) {
        if(s==null || s.length()==0 || s==null)  return s;
        char[] arr = s.toCharArray();
        int begin=0,end=arr.length-1;

        while (begin<end) {
            //从前往后，不是元音就后移
            while (begin<arr.length && judge(arr[begin])) {
                begin++;
            }
            //从后往前，不是元音就前移
            while (end>0 && judge(arr[end])) {
                end--;
            }
            if (begin>=end) {
                break;
            }

            char temp = arr[begin];
            arr[begin++] = arr[end];
            arr[end--] = temp;
        }
        String result = new String(arr);
        return result;

    }
    public boolean judge(char c){
        //不是元音，返回true
        if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u' && c!='A' && c!='E' && c!='I' && c!='O' && c!='U'){
            return true;
        }else{return false;}
    }
}