class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[]res=new int[n];
        k=k%n;
        for(int i=0;i<n;i++){
            int newIndex=(i+k)%n;
            res[newIndex]=nums[i];
        }
        for(int i=0;i<n;i++){
            nums[i]=res[i];
        }
    }
}
//for left rotation(i-k+n)%n;