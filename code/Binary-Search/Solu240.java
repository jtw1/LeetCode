/**
 * @Description 240 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * @date 2021/3/3 0003-11:25
 */
public class Solu240 {
    /**
     * TC:O(m+n)  SC:O(1)
     * 时间复杂度一开始想成了O(mn)是错误的，
     * 因为每次遇到大于或小于target时，都是移动一整行或者一整列
     * 行只能减少m次，列只能增加n次，循环不会超过  m+n 次
     */
    public boolean searchMatrix1(int[][] matrix, int target){
        if(matrix==null || matrix[0].length==0) return false;
        /**
         * 搜索起点可以选左下角或右上角，这里选的左下角，原因
         * 左上角：往右和往下都增大，不可选
         * 右下角：往左和往下都减小，不可选
         * 左下角：往右增大  往上减小，可选
         * 右上角：往左减小  往下增大，可选
         */
        int row=matrix.length-1,column=0;
        while (row>=0 && column<matrix[0].length){
            if (matrix[row][column]>target){
                row--;
            }else if (matrix[row][column]<target){
                column++;
            }else{
                //找到target
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 二分法   TC:O(lg(n!))  SC:O(1)
         * 在对角线上迭代，二分搜索行和列，
         * 直到对角线的迭代元素用完为止（意味着我们可以返回 false ）
         * 或者找到目标（意味着我们可以返回 true ）。
         */
        if(matrix==null || matrix[0].length==0) return false;
        int shortDim=Math.min(matrix.length,matrix[0].length);
        for (int i = 0; i < shortDim; i++) {
            boolean verticalFound=binarySearch(matrix,target,i,false);
            boolean horizontalFound=binarySearch(matrix,target,i,true);

            if (verticalFound || horizontalFound) return true;
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target,int start,boolean isHorizontal){
        int low = start;
        int high = (isHorizontal?matrix[0].length-1 : matrix.length-1);

        while (high>=low){
            int mid=low+(high-low)/2;
            if (isHorizontal){
                //水平方向查找
                if(matrix[start][mid] < target){
                    low=mid+1;
                }else if(matrix[start][mid] > target){
                    high=mid-1;
                }else{
                    return true;
                }
            }else{
                //垂直方向查找
                if(matrix[mid][start] < target){
                    low=mid+1;
                }else if (matrix[mid][start] > target){
                    high=mid-1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

}
