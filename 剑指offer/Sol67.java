import java.util.concurrent.ForkJoinPool;

/**
 * @Description 67 把字符串转换成整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * @date 2021/2/18-10:39
 */
public class Sol67 {
    public static int strToInt(String str) {
        // TC:O(n)  SC:O(1)
        if(str==null || str.length()==0) return 0;
        int res=0,bndry=Integer.MAX_VALUE/10; //结果，大数边界
        int i=0,sign=1,len=str.length();
        while(str.charAt(i)==' '){
            if(++i == len) return 0;
        }
        if(str.charAt(i)=='-') sign=-1;
        if(str.charAt(i)=='-' || str.charAt(i)=='+') i++;
        for (int j = i; j < len; j++) {
            if(str.charAt(j)<'0' || str.charAt(j)>'9') break;
            /**
             * 两种越界情况
             * 1 res>bndry,执行res*10之后大于Integer.MAX_VALUE(2147483647)
             * 2 res=bndry,拼接后是2147483648或2147483649
             */
            if(res>bndry || (res==bndry && str.charAt(j)>'7'))
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res=res*10+(str.charAt(j)-'0');
        }
        return sign*res;
    }
}
