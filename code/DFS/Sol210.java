import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 210 课程表II
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * @date 2021/2/25-16:23
 */
public class Sol210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees=new int[numCourses];
        List<List<Integer>> adjacency=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        int[] res=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp:prerequisites){
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        int index=0;
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.add(i);
                res[index++]=i;
            }
        }

        while(!queue.isEmpty()){
            int pre=queue.poll();
            numCourses--;
            for(int cur:adjacency.get(pre)){
                if(--indegrees[cur]==0){
                    queue.add(cur);
                    res[index++]=cur;
                }
            }
        }
        return numCourses==0?res:new int[0];
    }
}
