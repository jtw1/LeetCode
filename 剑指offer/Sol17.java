/**
 * @Description
 * @date 2021/1/9-14:38
 */
public class Sol17 {
    public int[] printNumbers(int n){
        int size=fast_pow(10,n)-1;
        int[] ans=new int[size];
        for (int i = 0; i < size; i++) {
            ans[i]=i+1;
        }
        return ans;
    }
    public int fast_pow(int base,int index){
        int res=1;
        while(index>0){
            if((index&1)==1) res *= base;

            base *= base;
            index >>= 1;
        }
        return res;
    }
}
