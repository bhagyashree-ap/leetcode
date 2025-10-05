class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int answer[] = new int[n];
        int prefix_counter=1;
        for (int i=0; i<n; i++){
            answer[i]=prefix_counter;
            prefix_counter=prefix_counter*nums[i];
        }
        int suffix_counter=1;
        for (int i=n-1; i>=0; i--){
            answer[i]=answer[i]*suffix_counter;
            suffix_counter=suffix_counter*nums[i];
        }
        return answer;
    }
}
