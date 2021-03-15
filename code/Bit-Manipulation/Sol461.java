/**
 * @Description 461. 汉明距离
 * https://leetcode-cn.com/problems/hamming-distance/
 * @date 2021/3/15 0015-9:39
 */
public class Sol461 {
    // 法一  逐个移位判断是否是1
    public int hammingDistance1(int x, int y) {
        int ans=x^y;
        int count=0;
        while(ans!=0){
            if((ans & 1)==1){
                count++;
            }
            ans >>=1;
        }
        return count;
    }
    //法二：利用性质  x&(x-1)可以将x最右边的1变为0，效率优于法一
    public int hammingDistance(int x, int y){
        int ans=x^y;
        int count=0;
        while(ans!=0){
            count++;
            ans=ans&(ans-1);
        }
        return count;
    }

}
