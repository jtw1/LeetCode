/**
 * @Description 91. 解码方法
 *
 * @date 2021/5/17 0017-10:42
 */
public class Sol91 {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        if(s.charAt(0)=='0') return 0;
        int len=s.length();
        int pre=1,cur=1;
        for(int i=1;i<len;i++){
            int tmp=cur;
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2') cur=pre;
                else return 0;
            }else if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)>='1' && s.charAt(i)<='6')){
                cur=cur+pre;
            }
            pre=tmp;
        }
        return cur;
    }


    public int numDecodings1(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        int len=s.length();
//        int[] dp=new int[len+1];
//        dp[0]=1;    //dp[0] 代表空字符串   数组中的 i 对应字符串中 i-1
        int a=0,b=1,c=0;    // a b c 分别对应 dp[i-2]  dp[i-1]  dp[i]
        for(int i=1;i<=len;i++){
            c=0;
            if(s.charAt(i-1)!='0'){
                c+=b;
            }

            if(i>1 && s.charAt(i-2)!='0' && ((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0')<=26 ){
                c+=a;
            }
            a=b;
            b=c;
        }
        return c;
    }


    public int numDecodings2(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        int len=s.length();
        int[] dp=new int[len+1];
        dp[0]=1;    //dp[0] 代表空字符串   数组中的 i 对应字符串中 i-1

        for(int i=1;i<=len;i++){
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }

            if(i>1 && s.charAt(i-2)!='0' && ((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0')<=26 ){
                dp[i]+=dp[i-2];
            }
        }
        return dp[len];
    }
}
