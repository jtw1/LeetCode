import java.awt.image.Kernel;
import java.util.Random;

/**
 * @Description
 * @date 2021/3/25 0025-15:02
 */
public class Tes40 {
    public static void main(String[] args) {
        int[] arr={3,2,1};
        //swap(arr,0,2);
        int[] res=getLeastNumbers(arr,2);
        for (int i = 0; i < 2; i++) {
            res[i]=arr[i];
            System.out.println(res[i]);
        }
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res=new int[k];
        if(k==0) return res;
        selectKNumbers(arr,0,arr.length-1,k);
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }

    public static void selectKNumbers(int[] arr, int left,int right,int k){
        if(left>=right) return;
        int position=randomPartion(arr,left,right);
        int num=position-left+1;
        if(k==num){
            return;
        }else if(k>num){
            selectKNumbers(arr,position+1,right,k-num);
        }else{
            selectKNumbers(arr,left,position-1,k);
        }
    }

    public static int randomPartion(int[] arr, int left,int right){
        int index=left+new Random().nextInt(right-left+1);
        swap(arr,index,right);
        return partion(arr,left,right);
    }
    public static int partion(int[] arr, int left,int right){
        int pivot=arr[right];
        int i=left-1;
        for(int j=left;j<right;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,right);
        return i+1;
    }

    public static void swap(int[] arr, int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
