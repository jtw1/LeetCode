import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 207 课程表 与210类似
 * https://leetcode-cn.com/problems/course-schedule/
 * 题解： https://leetcode-cn.com/problems/course-schedule/solution/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/
 * @date 2021/2/23-8:39
 */
public class Sol207 {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        int[] indegrees=new int[numCourses]; //入度表
        List<List<Integer>> adjacency=new ArrayList<>();//课号->依赖这门课的后续课程
        Queue<Integer> queue=new LinkedList<>();  //记录入度为0的课程
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 入度为0的课加入队列中，这些是直接可以选的课
        for (int i = 0; i < numCourses; i++) {
            if(indegrees[i]==0) queue.add(i);
        }
        // BFS TopSort.
        while (!queue.isEmpty()){
            int pre=queue.poll(); //出列代表课被选，所以总课程数对应减一
            numCourses--;
            //如果相关课的入度新变为 0，安排它入列、再出列……直到没有入度为 0 的课可入列。
            for (int cur:adjacency.get(pre)){
                if(--indegrees[cur]==0) queue.add(cur);
            }
        }
        return numCourses==0;
    }
}
