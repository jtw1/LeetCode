package LeetCodeTest;
//加一
public class Solu66 {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9,9,8};
        int[] dig = Solu66.plusOne(digits);
        for (int i = 0; i < dig.length; i++) {
            System.out.print(dig[i]+",");
        }
        System.out.println();
    }
    
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0 ; i--) {
            //从数组最后一位从后往前遍历，digits[i]！=9时，把digits[i]加1，直接返会digits数组，程序结束
            if (digits[i]!=9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; //digits[i]=9时，加1之后digits[i]就变成0了
        }
        //跳出for循环，说明数组每一位都是9，新数组长度需要增加一位
        int[] digit = new int[digits.length+1];
        digit[0] = 1;
        return digit;

        /*int len = digits.length;
        if (digits==null || len==0) {
            return null;
        }

        if (len==1 && digits[0]<9) {
            int[] dig = new int[1];
            dig[0] = digits[0]+1;
            System.out.println(dig[0]);
            return dig;
        }
        //可能会有整型溢出
        int Sum = digits[len-1];
        int index = 10;
        for(int i=len-2;i>=0;i--){
            Sum += digits[i]*index;
            index *=10;
        }  //得到原来数组代表的数
         int outSum = Sum+1;
         String str = String.valueOf(outSum);
         int[] digit = new int[str.length()];
         for (int i = 0; i < str.length(); i++) {
             digit[i] = str.charAt(i)-'0';
             System.out.print(digit[i]+",");
         }
         System.out.println();
         return digit;*/
    }
}