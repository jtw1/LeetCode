import java.util.List;

/**
 * @Description 0806 汉诺塔问题
 * https://leetcode-cn.com/problems/hanota-lcci/
 * @date 2021/1/20 0020-10:40
 */
public class Sol0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if(A==null || A.size()==0) return;
        int n=A.size();
        recur(n,A,B,C);
    }
    public void recur(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        if(n==1){
            C.add(A.remove(A.size()-1));
            return;
        }
        //把n-1个盘子从A借助C移到B
        recur(n-1,A,C,B);
        //把第n个盘子从A移到C
        C.add(A.remove(A.size()-1));
        //把n-1个盘子从B借助A移到C
        recur(n-1,B,A,C);
    }
}
