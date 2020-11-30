/**
 * @Description [767] 重构字符串 day
 * https://leetcode-cn.com/problems/reorganize-string/
 * @date 2020/11/30 0030-9:32
 */
public class Sol767 {
    public static void main(String[] args) {
        String S="aaacbd";
        System.out.println(reorganizeString(S));
    }
    public static String reorganizeString(String S) {
        if(S==null || S.length()<2) return S;
        int len=S.length();
        int[] repo=new int[26];
        int maxLen=0;  //记录字符出现的最长长度
        for (int i = 0; i < len; i++) {
            maxLen=Math.max(maxLen,++repo[S.charAt(i)-'a']);
        }
        if(maxLen>(len+1)/2) return "";
        /**
         * 对于总长度为奇数，如果 字符 长度为 (len + 1) / 2，即向上取整，那么这个字符首先需要放在首尾，即偶数位（因为需要夹紧其他字符，比如 ababa）
         * 对于总长度为偶数，没有什么特别要求，因为无论怎么整，字符的长度最长只能为总长度的一半，那么只要间隔存放，奇数位偶数位没差别（比如 abababab）
         *
         * 综上，我们只需要处理 总长度奇数 的情况即可，
         * 这里我们先写出放在奇数位的条件，chs[i] < (len + 1) / 2
         * 但这里写的话会有问题，因为如果总长度是 偶数的话， 如果存在这么一个情况 aaaabbbb，
         * 那么 每个字符出现的次数都是 4，占了总长度一半，如果写成 chs[i] < (len + 1) / 2，（我们上面说了 对于偶数长度，len / 2 == (len + 1) / 2），
         * 即 只有在 chs[i] < len / 2 的情况才能放在奇数
         * 那么对于 这个 a 来说，由于 chs[i] < len / 2 不成立，因此不会放在奇数，都放在偶数位，然后下一个 b ,
         * 同样也不会放在奇数，导致奇数位不会被放置，结果错误
         *
         * 因此，我们需要修改成既能限制 奇数长度的放置，又能不影响 偶数长度的放置
         * 因为对于 奇数长度来说，len / 2 + 1 == (len + 1) / 2，而对于偶数长度来说是不一样的，因此我们采用 len / 2 + 1 这个写法，
         * 这样的话，对于 a 来说，就是 4 < 5 了，a 放置完奇数位，然后奇数位越界，因此 b 会 放置在偶数位，那么结果就是 abababab
         */
        char[] res=new char[len];
        int even=0,odd=1;
        for (int i = 0; i < 26; i++) {
            //元素个数不为 0 并且 长度 小于 len / 2 + 1，并且奇数位下标还没越界，那么将元素放在奇数位
            while(repo[i]>0 && repo[i]<len/2+1 && odd<len){
                res[odd]=(char)(i+'a');
                repo[i]--;
                odd+=2;
            }
            //当 odd 越界了，或者长度等于 len / 2 + 1，那么就会放在偶数位
            while(repo[i] > 0){
                res[even] = (char)(i + 'a');
                repo[i]--;
                even += 2;
            }
        }
        return new String(res);
    }
}
