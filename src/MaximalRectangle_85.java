public class MaximalRectangle_85 {


    public int maximalRectangle(char[][] matrix) {
        int iLength = matrix.length;
        if (iLength == 0)
            return 0;
        int jLength = matrix[0].length;
        int ans = 0;
        int[][][] heightOfLengthK = new int[iLength][jLength][jLength+1];
        for (int i = 0;i<iLength;i++)
            for (int j =0 ;j<jLength;j++)
                if (matrix[i][j] == '1'){
                    heightOfLengthK[i][j][1] = 1;
                    if (heightOfLengthK[i][j][1]>ans)
                        ans = 1;
                }
        //第一行
        for (int j = 1;j < jLength;j++)
            if (matrix[0][j] == '1'){
                for (int k = 1;k <= j+1;k++)
                    if(heightOfLengthK[0][j-1][k-1]>0){
                        heightOfLengthK[0][j][k] = 1;
                        if (k>ans)
                            ans = k;
                    }

            }
        //第一列
        for (int i = 1; i< iLength;i++)
            if (matrix[i][0] == '1'){
                heightOfLengthK[i][0][1] = heightOfLengthK[i-1][0][1]+1;
                if (heightOfLengthK[i][0][1]>ans)
                    ans = heightOfLengthK[i][0][1];
            }


        for (int i = 1;i<iLength;i++)
            for (int j =1 ;j<jLength;j++)
                if (matrix[i][j] == '1'){

                    heightOfLengthK[i][j][1] = heightOfLengthK[i-1][j][1]+1;
                    if (heightOfLengthK[i][j][1] >ans)
                        ans = heightOfLengthK[i][j][1];
                      for (int k = 2;k<=j+1;k++)
                      {
                         if (heightOfLengthK[i][j-1][k-1] == 0)
                             continue;

                          heightOfLengthK[i][j][k] = 1 ;
                          if (heightOfLengthK[i-1][j][k] != 0 &&
                                  heightOfLengthK[i-1][j][k]+1>heightOfLengthK[i][j][k]
                                 )
                              heightOfLengthK[i][j][k] =heightOfLengthK[i-1][j][k]+1;

                          if (heightOfLengthK[i][j][k] * k >ans)
                              ans = heightOfLengthK[i][j][k] * k;
                      }
                }
        return ans;
    }

}
