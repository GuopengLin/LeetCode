import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class sum4_18 {
    public int[][] hashTable;
    public final int M = 29;
    public final int N = 1023;
    public final int MAXIMUM = 2147483647;
    public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int len = nums.length;
            hashTable = new int[N][4];
            for ( int i = 0 ;i < N ;i++)
                hashTable[i][0] = MAXIMUM;
            //四重循环去找，当然也可以三重
            for (int i = 0;i < len; i++)
                for ( int j = i + 1; j < len ;j++)
                    for ( int k = j+1 ;k < len ; k++)
                        for ( int t = k + 1; t < len ;t++){
                            if (nums[i]+nums[j]+nums[k]+nums[t] == target && search(nums[i],nums[j],nums[k],nums[t]) == false){
                                List<Integer> integerList = new ArrayList<>();
                                integerList.add(nums[i]);
                                integerList.add(nums[j]);
                                integerList.add(nums[k]);
                                integerList.add(nums[t]);
                                ans.add(integerList);
                            }
                        }

            return ans;
    }
    //哈希表的实现
    public boolean search(int t1,int t2 ,int t3, int t4){
        int[] a = {t1,t2,t3,t4};
        //先排序
        for (int i = 0;i<4;i++)
            for ( int j = i+1 ;j <4;j++){
                if (a[i] > a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        int k = 0;
            //计算哈希值
        for ( int i = 0; i<4;i++){
            k = (k * M + Math.abs(a[i])) % N;
        }
        //寻找
        while (!compare(hashTable[k],a) && hashTable[k][0] != MAXIMUM){
            k = (k+1) % N;
        }
        //没找到一样的
        if (hashTable[k][0] == MAXIMUM){
            copy(a,hashTable[k]);
            return false;
        }else return true;

    }
    //比较是否一样
    public boolean compare(int[] a, int[] b){
        for ( int i = 0; i<4;i++)
            if (a[i] != b[i])
                return false;
        return true;
    }
    public void copy(int[] from , int[] to){
        for ( int i = 0 ;i< 4;i++)
            to[i] =from[i];
    }
}
