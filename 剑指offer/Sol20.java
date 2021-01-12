/**
 * @Description [20] 表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * @date 2021/1/12 0012-9:56
 */
public class Sol20 {
    private int index=0;
    public boolean isNumber(String s){
        if(s==null || s.length()==0) return false;
        s=s+'|';
        while(s.charAt(index)==' ') index++;

        boolean numeric=scanInteger(s);  //是否包含整数部分
        if(s.charAt(index)=='.'){
            index++;
            //有小数点，处理小数部分
            //小数点两边只要有一边有数字就可以，所以用||，
            //注意scanUnsignedInteger要在前面，否则不会进
            numeric=scanUnsignedInteger(s)||numeric;
        }
        if(s.charAt(index)=='e' || s.charAt(index)=='E'){
            index++;
            numeric=numeric && scanInteger(s);
        }
        //跳过尾部空格
        while(s.charAt(index)==' ') index++;
        return numeric && s.charAt(index)=='|';
    }

    //是否包含无符号数
    private boolean scanUnsignedInteger(String str){
        int pre=index;
        while (str.charAt(index)>=0 && str.charAt(index)<=9){
            index++;
        }
        return index>pre;
    }

    //是否包含有符号数
    private boolean scanInteger(String str){
        if(str.charAt(index)=='+' || str.charAt(index)=='-') index++;
        return scanUnsignedInteger(str);
    }
}
