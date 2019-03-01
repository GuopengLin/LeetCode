import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public boolean[] used;
    public List<List<Integer>> ans;
    public List<Integer> temp;
    public int[] data;
    public int len;
    public void search(int k){
        if (k == 0)
        {
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i<temp.size();i++)
                list.add(temp.get(i));
            ans.add(list);
            return;
        }
        for (int i = 0;i<len;i++){
            if (used[i] == false){
                used[i] = true;
                temp.add(data[i]);
                search(k-1);
                temp.remove(temp.size()-1);
                used[i] = false;

            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        data = nums;
        len = nums.length;

        ans = new ArrayList<>();
        temp = new ArrayList<>();
        if (len == 0)
            return ans;
        search(nums.length);

        return ans;
    }
}
