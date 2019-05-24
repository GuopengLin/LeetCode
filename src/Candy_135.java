public class Candy_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        for (int i = 0 ; i < n;i++){
            fromLeft[i] = 1;
            fromRight[i] = 1;
        }
        for (int i = 1 ; i < n ;i++){
            if (ratings[i]>ratings[i-1]){
                fromLeft[i] = fromLeft[i-1]+1;
            }
        }
        for (int i = n-2 ; i >=0 ;i--){
            if (ratings[i]>ratings[i+1]){
                fromRight[i] = fromRight[i+1]+1;
            }
        }
        int total = 0;
        for (int i = 0 ; i< n ;i++){
            total = total + max(fromLeft[i],fromRight[i]);
        }
        return total;
    }
    public int max(int a,int b){
        return  a>b?a:b;
    }
}
