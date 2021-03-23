//面试题五：替换空格
// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。
/**
 * @Description
 * @date 2020/10/22 0022-17:35
 */
public class Sol5 {
    public static void main(String[] args) {
        char[] str=new char[]{'h','e','l','l','o',' ','w','o','r','l','d',' ',' ','c','h','i','n','a',' '};
        for (char c: replaceBlank(str)) {
            System.out.print(c);
        }
    }
    public static char[] replaceBlank(char[] str){
        if(str==null || str.length==0) return str;
        int i=0,originalLen=str.length;
        int numOfBlank=0;  //空格数
        while(i<originalLen){
            if(str[i]==' '){
                numOfBlank++;
            }
            i++;
        }
        int newLen=originalLen+numOfBlank*2;
        char[] newStr=new char[newLen];
        int indexOfOriginal=originalLen-1,indexOfNew=newLen-1;

        while(indexOfOriginal>=0){
            if(str[indexOfOriginal]==' '){
                newStr[indexOfNew--]='0';
                newStr[indexOfNew--]='2';
                newStr[indexOfNew--]='%';
            }else{
                newStr[indexOfNew--]=str[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        return newStr;
    }

    //法二
    // return s.replace(" ","%20");
}
