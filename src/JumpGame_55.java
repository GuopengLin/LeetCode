public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int reach = 0;
        for (int i = 0;i<len;i++){
            if (reach>=i){
                if (nums[i] + i>reach) reach = nums[i]+i;
            }
            else break;
        }
        if (reach>=len-1)
            return true;
        else return false;
    }
}
