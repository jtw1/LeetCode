package LeetcodeTest;
// 392 判断子序列
// https://leetcode-cn.com/problems/is-subsequence/
public class Solu392 {
    public boolean isSubsequence(String s, String t) {
        //法一 双指针 TC:O(lengthOfT+lengthOfS)  SC:O(1)
        int shortLen=s.length()-1,longLen=t.length()-1;
        if(s.length()==0 || s==null) return true;
        if(t.length()==0 || t==null) return false;
        while(longLen>=0){
            if(t.charAt(longLen)==s.charAt(shortLen)){
                shortLen--;
                longLen--;
            }else{
                longLen--;
            }

            if(shortLen<0) return true;
            else continue;
        }
        return false;

        //法一.1(官方) 双指针 TC:O(lengthOfT+lengthOfS)[1ms]  SC:O(1)
//        int n=s.length(),m=t.length();
//        int i=0,j=0;
//        while(i<n && j<m){
//            if(s.charAt(i)==t.charAt(j)){
//                i++;
//            } 
//            j++;
//        }
//        return i==n;

        //法一.2(官方) 双指针 TC:O(lengthOfT+lengthOfS)[0ms]  SC:O(1)
//        int n=s.length(),m=t.length();
//        char[] arrs=s.toCharArray();
//        char[] arrt=t.toCharArray();
//        int i=0,j=0;
//        while(i<n && j<m){
//            if(arrs[i]==arrt[j]){
//                i++;
//            } 
//            j++;
//        }
//        return i==n;

        //dp TC:O(lengthOfT*26+lengthOfS)  SC:O(lengthOfT*26)
//        int n=s.length(),m=t.length();
//        //f数组f[i][j]表示字符串t以i位置开始第一次出现字符j的位置
//        int[][] f=new int[m+1][26];
//        //初始化边界条件，f[i][j] = m表示t中不存在字符j
//        for (int k = 0; k < f.length; k++) {
//            f[m][k]=m;
//        }
//        //从后往前递推初始化dp数组
//        for (int k = m-1; k >=0; k--) {
//            for (int j = 0; j < 26; j++) {
//                if(t.charAt(k)==j+'a') f[k][j]=k;
//                else f[k][j]=f[k+1][j];
//            }
//        }

//        int add=0;
//        for (int k = 0; k < f.length; k++) {
//            //t中没有s.charAt(i) 返回false
//            if(f[add][s.charAt(k)-'a']==m) return false;
//            //否则直接跳到t中s.charAt(i)第一次出现的位置之后一位
//            add=f[add][s.charAt(k)-'a']+1;
//        }
//        return true;

        //法三 最快
//        int index=-1;
//        for (char c : s.toCharArray()) {
//            //index表示上一次查找的位置(第一次查找的时候为-1)，所以这里要从t的下标(index+1)开始查找
//            index=t.indexOf(c, index+1);
//            //没找到，返回false
//            if(index==-1) return false;
//        }
//        return true;
    }
}