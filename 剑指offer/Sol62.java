import java.util.ArrayList;
import java.util.List;

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

    public int lastRemaining1(int n, int m) {
        if(n==0||m==0) return -1;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(i);
        int c=(m-1)%n;
        /**
         * 当前要删除的位置是c，下一个要删除的位置next是c+m,由于位置c的元素被删除了，所以在位置next的元素前移一位
         * 并且数到末尾会从头继续数，最后需要取模，所以 next=(c+m-1)%list.size();
         */
        while(list.size()!=1) {
            list.remove(c);
            c=(c+m-1)%list.size();
        }
        return list.get(0);
    }
}
