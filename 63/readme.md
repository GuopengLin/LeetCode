## 63. Unique Paths II
我就写了动态规划的方法。。因为这是最简单的。。。  
动态规划第一步是要确定是否能用动态规划。。。当然这题非常显而易见。。。然后第二步应该找到状态转移方程。。第三步是做好初始化条件  
这题的状态转移方程就是  
ways[i][j] = ways[i-1][j]+ways[i][j-1].   
当然，到实际代码应该稍作修改。
接下来是代码。  
### 代码
```
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