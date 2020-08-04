package LeetCodeTest;


import java.util.Scanner;

public class RomanToInt {
    public static void main(String[] args) {
       
            Scanner sc=new Scanner(System.in);
            System.out.print("请输入罗马数字：");
            String s=sc.nextLine().toString();
            RomanToInt rom=new RomanToInt();
            System.out.println("该罗马数字对应的整数是："+rom.romanToInt(s));
            //sc.close();
            sc.close();
    }
    /**
     * 罗马数字转阿拉伯数字的主方法
     * @param s
     * @return 罗马数字代表的值
     */
    public int romanToInt(String s){
        int sum=0;
        int prenum=getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num=getValue(s.charAt(i));
            if (prenum<num) {
                sum -= prenum;
            } else {
                sum += prenum;
            }
            prenum=num;
        }
        sum += prenum;
        return sum;
    }
    /**
     * 获取罗马数字对应的数字
     * @param c
     * @return
     */
    public int getValue(char c){
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    //哈希表
    /*public int romanToInt(String s){
        Map<String,Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int sum=0;
        for (int i = 0; i < s.length();) {
            if ((i+1)<s.length()&& map.containsKey(s.substring(i, i+2))) {
               sum += map.get(s.substring(i, i+2));
               i += 2; 
            } else {
               sum += map.get(s.substring(i, i+1));
               i++; 
            }
        }
        return sum;
    }
*/
}