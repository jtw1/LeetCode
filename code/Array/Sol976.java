import java.util.Arrays;

/**
 * @Description [976] 三角形最大周长
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * @date 2020/11/29-10:58
 */
public class Sol976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
