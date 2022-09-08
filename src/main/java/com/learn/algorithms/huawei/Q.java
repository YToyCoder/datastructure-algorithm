package com.learn.algorithms.huawei;

import java.util.Objects;
import java.util.Scanner;

public class Q {
  int no=0,up=1,down=2,r=3,l=4;
  void q_2(char[][] chars){
    int[][] visited = new int[chars.length][chars[0].length];
    int[] loc = new int[]{-1, -1};
    for(int i=0; i<chars.length; i++){
      for(int j=0; j<chars[0].length; j++){
        if(Objects.equals( chars[i][j], 'S') || Objects.equals( chars[i][j], 'E')){
          loc[0] = i;
          loc[1] = j;
          visited[i][j] = 1;
          break;
        }
      }
      if(loc[0] != -1) break;
    }
    int val = Math.max(
      Math.max(
        visit(chars, new int[]{loc[0], loc[1] - 1}, visited, 0, up), 
        visit(chars, new int[]{loc[0] - 1, loc[1]}, visited, 0, l)
      ), 
      Math.max(
        visit(chars, new int[]{loc[0], loc[1] + 1}, visited, 0, down), 
        visit(chars, new int[]{loc[0] + 1, loc[1]}, visited, 0, r)
      )
    );
    System.out.println(val == 0 ? -1 : val);
  }

  int visit(char[][] chars, int[] loc,int[][] visited, int pre_len, int o){
    if(0 <= loc[0] && loc[0] < chars.length && 0 <= loc[1] && loc[1] < chars[0].length && visited[loc[0]][loc[1]] == 0){
      final char c = chars[loc[0]][loc[1]];
      if(Objects.equals(c, 'X')){
        return 0;
      }else if(Objects.equals(c, 'B')){
        visited[loc[0]][loc[1]] = 1;
        return Math.max(
          Math.max(
            visit(chars, new int[]{loc[0], loc[1] - 1}, visited, pre_len + get_Move(o, up), up), 
            visit(chars, new int[]{loc[0] - 1, loc[1]}, visited, pre_len + get_Move(o, l), l)
          )
          , 
          Math.max(
            visit(chars, new int[]{loc[0], loc[1] + 1}, visited, pre_len + get_Move(o, down), down), 
            visit(chars, new int[]{loc[0] + 1, loc[1]}, visited, pre_len + get_Move(o, r), r)
          )
        );
      }else return pre_len + 1;
    }
    return 0;
  }

  int get_Move(int pre, int cur){
    return pre == no || pre == cur ? 1 : 2;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int row = scanner.nextInt();
    int col = scanner.nextInt();
    scanner.nextLine();
    char[][] s = new char[row][col];
    for(int i=0; i<row; i++){
      s[i] = scanner.nextLine().toCharArray();
    }
    new Q().q_2(s);
    scanner.close();
  }

}
