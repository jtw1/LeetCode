package rejectSampling;

/**
 * @Description 470 用Rand7()实现Rand10()
 * @date 2021/4/19 0019-10:50
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/xiang-xi-si-lu-ji-you-hua-si-lu-fen-xi-zhu-xing-ji/
 */
public class Solu470 {
    // 要保证等概率生成，不能使用 2*rand7()-1再舍弃11，12，13，因为那样并不是等概率

    //最慢，生成49个数取十个数
    public int rand10III() {
        int num=(rand7()-1)*7+rand7();
        //num>10的时候就舍弃再重新生成，直到生成小于等于10的num
        while(num>10){
            num=(rand7()-1)*7+rand7();
        }
        return num;
    }

    //次之  生成49个数取40个数
    public int rand10II(){
        int num=(rand7()-1)*7+rand7();
        while(num>40){
            num=(rand7()-1)*7+rand7();
        }
        //+1是为了解决  10，20，30，40对10取余数之后等于0的情况
        return 1+num%10;
    }


    /**
     * 上次舍弃的9个数再利用，利用公式 (大于40的随机数−40−1)∗7+rand7()
     * 这样我们可以得到 1-63 之间的随机数，只要舍弃 3 个即可，那对于这 3 个舍弃的，还可以再来一轮
     * (大于60的随机数−60−1)∗7+rand7()
     * 这样我们可以得到 1-21 之间的随机数，只要舍弃 1 个即可。
     * @return
     */
    public int rand10I(){
        //只要保证最后生成的数在[1,10]内即可
        while (true){
            int num=(rand7()-1)*7+rand7();
            if (num<=40){
                return 1+num%10;
            }
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍  得到 1-63 之间的随机数
            num=(num-40-1)*7+rand7();
            if (num<=60) return 1+num%10;

            // 说明刚才生成的在61-63之间，利用随机数再操作一遍  得到 1-21 之间的随机数
            num=(num-60-1)*7+rand7();
            if (num<=20) return 1+num%10;
            //说明刚才生成的是21，利用随机数再操作一遍  得到 1-7 之间的随机数
            num=(num-20-1)*7+rand7();
            return num;
        }
    }


    private int rand7() {
        return 0;
    }
}
