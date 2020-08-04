package LeetCodeTest;
//[67] 二进制求和
// https://leetcode-cn.com/problems/add-binary/description/
 
public class Solu67 {
    public static void main(String[] args) {
        System.out.println(Solu67.addBinary1("1101", "101"));
    }
    
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2)+Integer.parseInt(b, 2));
    }

    public static String addBinary1(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0; //进位
        for(int i=a.length(),j=b.length(); i>=0||j>=0; i--,j--){
            try {
                int sum = ca;
                sum += (i>=0? a.charAt(i)-'0' : 0);  
                // 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
                sum += (j>=0? a.charAt(i)-'0' : 0);
                ans.append(sum%2);   //如果二者都为1  那么sum%2应该刚好为0 否则为1
                ca = sum/2;        //如果二者都为1  那么ca 应该刚好为1 否则为0
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        ans.append(ca==1? ca:"");   //判断最后一次计算是否有进位  有则在最前面加上1 否则原样输出
        return ans.reverse().toString();
    }
}