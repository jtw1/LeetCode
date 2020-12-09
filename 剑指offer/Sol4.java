// 面试题四
// 二维数组查找

import java.util.Scanner;

/**
 * @Description
 * @date 2020/10/21 0021-11:27
 */
public class Sol4 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("请输入数组的行数，列数，要查找的数：");
        int rows=scan.nextInt(),columns=scan.nextInt(),number=scan.nextInt();
        int[][] matrix=new int[rows][columns];
        System.out.println("请输入数组元素：");
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                matrix[r][c]=scan.nextInt();
            }
        }

//        for(int r=0;r<rows;r++){
//            for(int c=0;c<columns;c++){
//                System.out.print(matrix[r][c]+" ");
//            }
//            System.out.println();
//        }
        //int[][] matrix={{1, 2, 8, 9},{2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};  //二维数组静态初始化，动态初始化才用new int[][],由系统分配默认初始值
        boolean found=find(matrix,rows,columns,number);
        if(found){
            System.out.println("数组中有"+number+"这个数");
        }else{
            System.out.println("数组中没有"+number+"这个数");
        }

    }
    public static boolean find(int[][] matrix,int rows,int columns,int number){
        if(matrix==null) return false;
        boolean found=false;
        if(rows>0 && columns>0){
            int row=0;
            int column=columns-1;
            while(row<rows && column>=0){
                if(matrix[row][column]==number){
                    found=true;
                    break;
                }else if(matrix[row][column]>number){
                    column--;
                }else{
                    row++;
                }
            }
        }
        return found;
    }
}
