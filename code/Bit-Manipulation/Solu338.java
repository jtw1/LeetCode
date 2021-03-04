/**
 * @Description 338 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/
 * @date 2021/3/3-20:40
 */
public class Solu338 {
    // 法一 最高有效位
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        res[0]=0;
        int highBit=0;
        /**
         * 设y的最高位1代表的数是x  则有res[y]=res[y-x]+1
         */
        for (int i = 1; i <= num; i++) {
            if((i & (i-1))==0){
                highBit=i;
            }
            res[i]=res[i-highBit]+1;
        }
        return res;
    }

    // 法二 最低有效位
    public int[] countBits1(int num){
        /**
         * x为偶数时  res[x]=res[x>>1]
         * x为奇数时  res[x]=res[x>>1]+1
         */
        int[] res=new int[num+1];
        res[0]=0;
        for (int i = 1; i <= num; i++) {
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }

    // 法三 最低设置位
    public int[] countBits2(int num){
        /**
         * 性质  x&(x-1)  将X最右边的1设置为0
         * 令y=x&(x-1)  则 0<=y<x
         */
        int[] res=new int[num+1];
        res[0]=0;
        for (int i = 1; i <= num; i++) {
            res[i]=res[i&(i-1)]+1;
        }
        return res;
    }
}
