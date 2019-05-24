public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null)
            return 1;
        int len = nums.length;
        if (len == 0)
            return 1;
        boolean flag = false;
        //一开始先将所有无关的数字变成0
        for (int i = 0 ;i< len ;i++){
            if (nums[i] == len){
                flag = true;
            }
            if (nums[i] < 0 || nums[i] >= len){
                nums[i] = 0;
            }
        }


        //如果数字i 存在，则num[i] = i
        for (int i = 0 ;i < len;i++){
            //无关数字
            if (nums[i] == 0 || nums[i] == i)
                continue;
            int temp = nums[i];
            while (temp != 0 && nums[temp] != temp){
                int temp2 = nums[temp];
                nums[temp] = temp;
                temp = temp2;
            }



        }
        for (int i = 1;i< len;i++)
            if (nums[i] != i)
                return i;
        if (!flag)
            return len;

         return len+1;
    }

}
