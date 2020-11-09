import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @Description [973] 最接近原点的K个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * @date 2020/11/9 0009-9:30
 */
public class Sol973 {
    Random rand = new Random();
    //法一  快排
    //TC:O(n)  SC:O(logn)
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void random_select(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }

    //法二  排序
    //TC:O(nlogn)  SC:O(logn)
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return (point1[0]*point1[0]+point1[1]*point1[1])-(point2[0]*point2[0]+point2[1]*point2[1]);
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }
}
