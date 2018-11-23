public class UniquePathsII {
    public static void main(String[] args) {
        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] ways = new int[obstacleGrid.length][obstacleGrid[0].length];
            if (obstacleGrid[0][0]==0) ways[0][0] = 1; //如果起点不为障碍物，到达起点的方法数为1

              for (int i = 0;i<obstacleGrid.length;i++)
                  for (int j = 0;j<obstacleGrid[0].length;j++)
                      if (obstacleGrid[i][j]==0){//如果当前位置不为障碍物
                          if (i-1>=0){  //如果上面的位置不超过边界(如果是障碍物也没事，反正到达障碍物的方法数为0，加上不影响）
                              ways[i][j] += ways[i-1][j];
                          }
                          if (j-1>=0){ //左边的位置不超过边界
                              ways[i][j]+=ways[i][j-1];
                          }
                      }

           return ways[obstacleGrid.length-1][obstacleGrid[0].length-1];
        }

}
