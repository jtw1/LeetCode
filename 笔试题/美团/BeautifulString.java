import java.util.Scanner;

/**
 * @Description 4.4日笔试
 * 一天，小美在写英语作业时，发现了一个十分优美的字符串：
 * 这个字符串没有任何两个字符相同。于是，小美随手写下了一个字符串，
 * 她想知道这个字符串的的所有子序列，有多少个是优美的。由于答案可能会很大，输出对20210101取模后的结果。
 * 一个字符串的子序列定义为：原字符串删除0个或多个字符后剩下的字符保持原有顺序拼接组成的字符串为原串的子序列。
 * 如：ab是acba的子序列，但bc则不是。在本题中。空串也为原串的子序列。
 * @date 2021/4/5-11:05
 */
public class BeautifulString {
    /**
     * 排列组合。统计每个字符出现的次数，记为cnt。
     * 每个字符有选择和不选择两种情况，选择的即为cnt种情况，不选的情况只有一种。
     * 所以每个字符为（cnt+1）种情况，所有出现过的字符的情况种类相乘，即为结果。
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int[] cnt=new int[26];
        for (int i = 0; i < 26; i++) {
            cnt[s.charAt(i)-'a']++;
        }
        int res=0;
        for (int i = 0; i < 26; i++) {
            int tmp=cnt[s.charAt(i)-'a'];
            if (tmp!=0){
                res = res*(tmp+1)%20210101;
            }
        }
        System.out.println(res);;
    }
}
