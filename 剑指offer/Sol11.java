/**
 * @Description 面试题11 旋转数组的最小数字  p82
 * @date 2020/12/14 0014-10:39
 */
public class Sol11 {
    //法一
    public int minArray(int[] numbers) throws Exception {
        if(numbers==null || numbers.length==0) throw new Exception("数组不合法");
        if(numbers.length==1) return numbers[0];
        int left=0,right=numbers.length-1;   //left指向前面递增数组的元素，right指向后面递增数组的元素
        int mid=left; //将mid初始化为left的原因：当旋转数组就是升序数组时，第一个数字就是最小数字，所以直接返回，所以将mid初始化为left
        while(numbers[left]>=numbers[right]){
            if(right-left==1){
                mid=right;
                break;
            }
            mid=left+(right-left)>>1;
            //如果left,right,mid指向的元素相等，只能顺序查找
            if(numbers[left]==numbers[right] && numbers[left]==numbers[mid]){
                return minOrder(numbers,left,right);
            }

            if(numbers[mid]>=numbers[left]){
                left=mid;
            }else if(numbers[mid]<=numbers[right]){
                right=mid;
            }
        }
        return numbers[mid];
    }
    //法二
    public int minArray1(int[] numbers){
        if(numbers.length==1) return numbers[0];
        int left=0,right=numbers.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(numbers[mid]>numbers[right]) left=mid+1;
            else if(numbers[mid]<numbers[right]) right=mid;
            else right -= 1;
        }
        return numbers[left];
    }


    private int minOrder(int[] numbers,int left,int right){
        int res=numbers[left];
        for (int i = left+1; i <= right; i++) {
            if(res>numbers[i]) res=numbers[i];
        }
        return res;
    }


}
