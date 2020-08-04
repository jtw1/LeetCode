package LeetCodeTest;
// [38] 外观数列
// https://leetcode-cn.com/problems/count-and-say/description/

public class Solu38 {
    public static void main(String[] args) {
        Solu38 s = new Solu38();
        System.out.println(s.countAndSay(4));
    }
    //用StringBuilder  运行时间(1 ms)
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        int p1 = 0;
        int cur = 1;
        if(n==1){
            return "1";
        }
        String str = countAndSay(n-1);
        for(cur=1; cur<str.length(); cur++){
            if (str.charAt(p1) != str.charAt(cur)) {
                // 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
                int count = cur-p1;
                s.append(count).append(str.charAt(p1));
                p1 = cur;
            }
        }
            // 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
            if (p1 != cur) {
                int count = cur-p1;
                s.append(count).append(str.charAt(p1));
            }        
        return s.toString();
    }

    //用String ,运行时间(22 ms)
    public String countAndSay1(int n) {
        String s = "";
        int p1 = 0;
        int cur = 1;
        if(n==1){
            return "1";
        }
        String str = countAndSay1(n-1);
        for(cur=1;cur<=str.length();cur++){
            if (str.charAt(p1) != str.charAt(cur)) {
                // 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
                int count = cur-p1;
                s=s+count+""+str.charAt(p1);
                p1 = cur;
            }
        }
            // 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
            if (p1 != cur) {
                int count = cur-p1;
                s=s+count+""+str.charAt(p1);
            }
        return s;
    }
}