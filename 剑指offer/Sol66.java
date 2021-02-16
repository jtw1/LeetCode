/**
 * @Description 66 构建乘积数组
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * @date 2021/2/16-16:00
 */
public class Sol66 {
    public int[] constructArr(int[] a) {
        /**
         * 算法过程：
         * 初始化：数组 B ，其中 B[0] = 1 ；辅助变量 tmp = 1 ；
         * 计算 B[i] 的下三角各元素的乘积，直接乘入 B[i] ；
         * 计算 B[i] 的上三角各元素的乘积，记为 tmp ，并乘入B[i] ；
         * 返回 B 。
         */
        if(a==null || a.length==0) return new int[0];
        int len=a.length;
        int[] res=new int[len];
        res[0]=1;
        int tmp=1;
        for (int i = 1; i < len; i++) {
            res[i]=res[i-1]*a[i-1];
        }
        for (int i = len-2; i >= 0; i--) {
            tmp *= a[i+1];
            res[i] *= tmp;
        }
        return res;
    }
}
