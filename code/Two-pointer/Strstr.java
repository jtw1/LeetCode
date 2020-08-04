package LeetCodeTest;
//[28] 实现 strStr()
//https://leetcode-cn.com/problems/implement-strstr/description/
public class Strstr {
    public static void main(String[] args) {
        int d=strStr1("gello", "");
        System.out.println(d);
    }
    //时间复杂度：O((N - L)L)，其中 N 为 haystack 字符串的长度，L 为 needle 字符串的长度。
    //内循环中比较字符串的复杂度为 L，总共需要比较 (N - L) 次。
    //空间复杂度：O(1)。
    public static int strStr(String haystack, String needle) {
        if(needle==null)   return 0;
        int len = needle.length();
        for (int i = 0; i <= haystack.length()-len; i++) {
            if (needle.equals(haystack.substring(i, i+len))) {
                return i;
            }else
                 continue;   
        }
        return -1;
    }
    
    //时间复杂度：最坏时间复杂度为 O((N - L)L)，最优时间复杂度为 O(N)。其中 N 为 haystack 字符串的长度，L 为 needle 字符串的长度。
    //内循环中比较字符串的复杂度为 L，总共需要比较 (N - L) 次。
    //空间复杂度：O(1)。
    public static int strStr1(String haystack, String needle) {
        if(needle==null||needle.length()==0)   return 0;
        int l = needle.length();
        int n = haystack.length();

        int pn=0;
        while(pn<n-l+1){
            // find the position of the first needle character
            // in the haystack string
            while(pn<n-l+1 && haystack.charAt(pn)!=needle.charAt(0))  ++pn;
            
            //compute the max match string
            int currlen=0,pl=0;
            while(pl<l && pn<n && haystack.charAt(pn)==needle.charAt(pl)){
                ++pl;
                ++pn;
                ++currlen;
            }

            //if the whole needle string is found
            //return its start position
            if(currlen==l)  return pn-l;

            //otherwise,backtrack
            pn=pn-currlen+1;
        }
        return -1;
   }
}