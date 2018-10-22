import java.util.Arrays;

public class TowSum {
    public int[]  twoSum(int[] nums,int target){
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        while (true){
            if (nums[l]+nums[r]<target){
                l++;
            }
            if (nums[l]+nums[r]>target){
                r--;
            }
            if (nums[l]+nums[r]==target){
                break;
            }
        }

       int[] ans=  new int[2];
        ans[0]=l;
        ans[1]=r;
       return ans;
    }

    public static void main(String[] args) {

    }
}
