public class SearchinRotatedSortedArray_33 {
    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        int[] b = {1,3,5};
        int ans = search(a,5);
        System.out.println(ans);
    }
    public static int search(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 0) return -1;
        int l,r,mid,ans;
        l = 0;
        r = nums.length-1;

        while (l<r){
            mid = (l+r)/2;
            if (nums[mid] == target){
                l = mid;
                break;
            }
            if (nums[l]<=nums[mid]){
                if (target>=nums[l] && target <=nums[mid])
                    r = mid;
                else l = mid+1;

            }else {
                if (target>=nums[mid] && target <=nums[r])
                    l = mid+1;
                else r = mid;
            }
        }
        if (nums[l] == target)
            return l;
        else
            return -1;
    }
}
