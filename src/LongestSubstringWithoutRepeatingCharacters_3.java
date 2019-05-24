public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int ans = 1;

         for (int i = 0;i<len;i++){ //从下标为i 的地方开始找最小不重复
               length:for (int k = 2;k<len-i+1;k++){ //找的长度

                     int j = i + k-1;
                     for (int t = i;t<j;t++)
                         {
                            if (s.charAt(t) == s.charAt(j))
                             break length; //一旦出现重复的，就没必要继续往后找了

                         }
                     if (k > ans)
                         ans = k;
           }
        }

         return ans;
    }
}
