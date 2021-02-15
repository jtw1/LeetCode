/**
 * @Description 62 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 题解 https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
 * @date 2021/2/15-16:52
 */
public class Sol62 {
    public int lastRemaining(int n, int m) {
        // 数学法 
        int last=0; //最后一个数的下标位置
        /**
         * 思路 最后一轮剩下2个人，所以从2开始反推
         * 模拟整个过程，从后往前反推
         * 最后只剩一个人，下标为0，值为x，所以last初始化为0，每次都是移动m个位置，
         * 最后一轮剩下2个人，x在这一轮中的下标 last=(last+m)%2
         * 前一轮剩下3个人，x在这一轮中的下标 (last+m)%3
         * ...
         *      剩下n个人，x在这一轮中的下标 (last+m)%n
         * 数字是从0开始的，所以x=(last+m)%n
         */
        for (int i = 2; i <= n; i++) {
            last=(last+m)%i;
        }
        return last;
    }
}
