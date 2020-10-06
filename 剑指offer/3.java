class Solution {
    public int findRepeatNumber(int[] nums) {
        //TC:O(n)   SC:O(1)
        if(nums.length==0 || nums==null) return -1;
        int len = nums.length;
        for(int i=0;i<len;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]) return nums[i]; //出现了两个相同的数，说明这个数重复了
                //交换对应位置的数，直到nums[i]=i
                int temp=nums[i];
                nums[i]=nums[nums[i]];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
