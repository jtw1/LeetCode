package TanXin;

/**
 * @Description 加油站
 * https://leetcode-cn.com/problems/gas-station/
 * @date 2020/11/18-22:04
 */
public class Sol134 {
    public static void main(String[] args) {
        int[] gas=new int[]{3,1,1};
        int[] cost=new int[]{1,2,2};
        //int res=canCompleteCircuit(gas,cost);
        int res=canCompleteCircuit1(gas,cost);
        System.out.println(res);
    }
    public static int canCompleteCircuit1(int[] gas, int[] cost){
        //https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
        //画总油量剩余值的折线图，使折线图最低点大于0，该点即为起点
        //TC:O(n)   SC:O(1)
        /*
        首先判断总gas能不能大于等于总cost，如果总gas不够，一切都白搭对吧；
        有序列表再就是找总（gas-cost）的最低点，不管正负（当然如果最低点都是正的话那肯定能跑完了）；
        找到最低点后，如果有解，那么解就是最低点的下一个点，因为总（gas-cost）是大于等于0的，所以前面损失的gas我从最低点下一个点开始都会拿回来！（此处@小马哥！），别管后面的趋势是先加后减还是先减后加，最终结果我是能填平前面的坑的。
         */
        int len1=gas.length;
        int spare=0;
        int minSpare=Integer.MAX_VALUE;
        int minIndex=0;
        for (int i = 0; i < len1; i++) {
            spare+=gas[i]-cost[i];
            if(spare<minSpare){
                minSpare=spare;
                minIndex=i;
            }
        }
        return spare<0?-1:(minIndex+1)%len1;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost){
        //官方题解
        //TC:O(n)   SC:O(1)
        int len=gas.length;
        int start=0;
        while(start<len){
            int sumOfCos=0,sumOfGas=0;
            int cnt=0;
            while(cnt<len){
                int j=(start+cnt)%len;  //到终点后再从起点开始走，路径是个环
                sumOfGas += gas[j];
                sumOfCos += cost[j];
                if(sumOfGas<sumOfCos) break;
                cnt++;
            }
            if(cnt==len){
                return start;
            }else{
                start=start+cnt+1;  //从不能回到原点的下一个点再次出发
            }
        }
        return -1;
    }
}
