public class MaximalTrangle {
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0)
            return 0;
        int length = matrix[0].length;
        int[][] temp = new int[height][length];
        int tempans = 0;
        for (int i = 0 ; i < height;i++)
            for (int j =0;j< length;j++){
                if (matrix[i][j] == '1')
                    temp[i][j] = 1;
                if (temp[i][j]>tempans)
                    tempans = temp[i][j];
            }
        for (int i = 1 ; i < height;i++)
            for (int j =1;j< length;j++){
                if (matrix[i][j] == '1')
                    temp[i][j] = min(temp[i][j-1],temp[i-1][j-1])+1;
                if (temp[i][j]>tempans)
                    tempans = temp[i][j];
            }
        int ans =0;
            for (int k = 0;k<=tempans;k++)
                ans = ans +k;
            return ans;
    }
    public int min(int a,int b){
        return (a>b)?b:a;
    }
}
