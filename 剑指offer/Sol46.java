/**
 * @Description 46 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-by-leetcode-sol/
 * @date 2021/1/27-20:54
 */
public class Sol46 {
    /**
     * 用 f(i)表示以第 i 位结尾的前缀串翻译的方案数
     * 则 f(i)=f(i-1)+f(i-2)[i-1>=0,第i-1位，i位组成的数 x 满足 10<=x<=25]
     * 边界条件 f(0)=1,f(-1)=0
     * 方程中 [c] 的意思是 c 为真的时候 [c] = 1，否则 [c]=0。
     * dp TC:O(n) SC:O(n)
      */
    public int translateNum(int num){
        String src=String.valueOf(num);
        int p=0,q=0,r=1;  //p,q,r依次对应 f(i-2),f(i-1),f(i)
        for (int i = 0; i < src.length(); i++) {
            p=q;
            q=r;
            r=0;
            r += q;
            if(i==0) continue; //(1)

            String pre=src.substring(i-1,i+1);
            //转移方程中[...]部分的判断 包含上面的(1)
            if(pre.compareTo("25")<=0 && pre.compareTo("10")>=0){
                r += p;
            }
        }
        return r;
    }
    //数字求余   TC:O(n) SC:O(1)  从右向左（dp的对称性）
    public int translateNum1(int num){
        int a=1,b=1,x,y=num%10;
        while (num!=0){
            num /= 10;
            x=num%10;
            int tmp=10*x+y;
            int c=(tmp>=10 && tmp <=25)?a+b:a;
            b=a;
            a=c;
            y=x;
        }
        return a;
    }
}
