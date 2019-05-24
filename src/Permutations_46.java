import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public boolean[] used;//标记元素是否已经使用过
    public List<List<Integer>> ans; //保存答案
    public List<Integer> temp;//保存找到的方案
    public int[] data; //把nums 弄成全局变量，方便
    public int len;//弄个全局变量保存数组长度
    public void search(int k){
        if (k == 0) //找到方案
        {
            List<Integer> list = new ArrayList<>();//因为java引用的缘故，必须另外开个对象保存
            for (int i = 0;i<temp.size();i++)
                list.add(temp.get(i));
            ans.add(list);
            return;
        }
        for (int i = 0;i<len;i++){  //循环去找，看哪个数字还没加入temp 中
            if (used[i] == false){
                //接下来这部分很关键，回溯的传统模版写法，不会写的话，可以好好理解下
                used[i] = true;  //将标记设为已使用
                temp.add(data[i]);//将元素放入
                search(k-1);//继续找下一个
                temp.remove(temp.size()-1);//回来后，删除刚才放的那个，为啥不能写 remove(data[i]),因为data[i] 是int，remove会 把data[i]当成下标
                used[i] = false;//将标记变为未使用

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
