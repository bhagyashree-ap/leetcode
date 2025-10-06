class Solution {
    public void sortColors(int[] nums) {
        int size = nums.length;
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int i = 0; i < size; i++) {
            if (nums[i] == 0){
                red++;
            }
            else if (nums[i] == 1){
                white++;
            }
            else{
                blue++;
            }
        }

        int index = 0;
        for (int i=0; i<red; i++){
            nums[index++]=0;
        }   
        for (int i=0; i<white; i++){
            nums[index++]=1;
        }   
        for (int i=0; i<blue; i++){
            nums[index++]=2;
        }
    }
}
