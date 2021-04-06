import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Description 2021 4.4 笔试题
 * 输入：
 * 输入t表示案例数
 * 输入n，w分别表示手机数和充电器功率
 * 接下来的n行输入 a[i] b[i]表示每一部手机初始电量，和每一秒消耗的电量
 * 输出：用充电器给这些手机轮流充电（不计切换时间），最多可以撑多久。
 * 当然功率够的话可以把所有斜率拨正。这时就输出-1
 *
 * 样例：
 * 1
 * 3 5
 * 3 6
 * 2 5
 * 1 6
 * @date 2021/4/5-10:37
 * 题解 https://www.nowcoder.com/subject/index/f36f9858ffc94c888f5d589ad19a5eab
 */
public class ReCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            double w = sc.nextDouble();
            PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> (int) (a[0] * b[1] - a[1] * b[0]));
            for(int j = 0; j < n; j++) {
                pq.offer(new double[]{sc.nextInt(), sc.nextInt()});
            }
            while(w > 0) {
                if(pq.size() == 1) {
                    double[] cur = pq.poll();
                    if(cur[1] <= w) {
                        System.out.println(-1);
                    } else {
                        System.out.println(cur[0]/(cur[1] - w));
                        w = 0;
                    }
                } else {
                    double[] cur = pq.poll();
                    double[] next = pq.peek();
                    double temp = ((next[0] * cur[1]) - cur[0] * next[1]) / next[0];
                    if(w  > temp) {
                        w -= temp;
                        pq.poll();
                        pq.offer(new double[]{cur[0] + next[0], cur[1] + next[1] - temp});
                    } else if(w <= temp) {
                        System.out.println(cur[0]/(cur[1] - w));
                        w = 0;
                    }
                }
            }
        }
    }
}
