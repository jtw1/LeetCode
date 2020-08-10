package LeetcodeTest;
// [696] 计数二进制串
// https://leetcode-cn.com/problems/count-binary-substrings/
import java.util.ArrayList;
import java.util.List;

public class Solu696 {
    public int countBinarySubstrings(String s) {
        //TC:O(n)   SC：O(n)
        //按照0，1的连续段进行分组，存在counts数组中，所以counts数组中相邻两个数字一定代表不同的字符
        //假如相邻两个字符的个数为u,v，他们组成的符合条件的字串数目为min(u,v)
        // List<Integer> list = new ArrayList<>();
        // int ptr=0,ans=0,n=s.length();
        // while(ptr<n){
        //     char c=s.charAt(ptr);
        //     int count=0;
        //     while(ptr<n && s.charAt(ptr)==c){
        //         ptr++;
        //         count++;
        //     }
        //     list.add(count);
        // }
        // for(int i=1;i<list.size();i++){
        //     ans += Math.min(list.get(i),list.get(i-1));
        // }
        // return ans;

        //TC:O(n)   SC：O(1)
        int ptr=0,ans=0,last=0,n=s.length();
        while(ptr<n){
            char c=s.charAt(ptr);
            int count=0;
            while(ptr<n && s.charAt(ptr)==c){
                ptr++;
                count++;
            }
            ans += Math.min(last, count);
            last=count;
        }
        return ans;
    }
}