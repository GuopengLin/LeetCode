public class JumpGameII_45 {
    public int jump(int[] nums) {
        int len = nums.length;
        int steps[] = new int[len];

        steps[0] = 0;

        for (int i = 0 ; i < len;i++){
            //反着来，一旦坐标大的不能更新，坐标小一点的肯定也不能
            for (int j = min(i+nums[i],len-1) ; j > i ;j--){
                if (steps[i] + 1 < steps[j] || steps[j] == 0){
                    steps[j] = steps[i]+1;
                }else {
                    break;
                }
            }
        }
        return steps[len-1];
    }
    public int min(int a, int b){
        return a<b?a:b;
    }
}
