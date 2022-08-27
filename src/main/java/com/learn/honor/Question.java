package com.learn.honor;

import java.util.Arrays;
import java.util.Scanner;

public class Question {

  public void Q1(){
    Scanner  scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    scanner.nextLine();
    String data = scanner.nextLine();

    char[] chars = data.toCharArray();
    // 0 - 8 9 - 
    for(int i=0; i < size; i++){
      if(chars[i * 9] - '0' == 0){
        for(int j=0; j < 4; j++){
          char temp = chars[i * 9 + 1 + j];
          chars[i * 9 + 1 + j] = chars[i * 9 + 8 - j];
          chars[i * 9 + 8 - j] = temp;
        }
      }
      chars[i * 9] = ' ';
    }
    System.out.println(String.valueOf(chars, 1, chars.length - 1));
    scanner.close();
  }

  public void Q2(){
    Scanner scanner = new Scanner(System.in);
    int size = Integer.parseInt(scanner.nextLine().trim());

    int pre_end = 8;
    for(int i=0; i < size; i++){
      int s_2 = Integer.parseInt(scanner.nextLine().trim());
      int sum = 0;
      int[][] list = new int[s_2][2];
      for(int j=0; j<s_2; j++){
        String[] start_and_end = scanner.nextLine().split(" ");
        int start = Integer.parseInt(start_and_end[0].trim());
        int end   = Integer.parseInt(start_and_end[1].trim());
        list[j] = new int[]{start, end};
      }
      pre_end = 8;
      Arrays.sort(list, (a, b) -> a[0] - b[0]);
      for(int j=0; j<s_2; j++){
        if(list[j][0] >= pre_end){
          sum += list[j][1] - list[j][0];
          pre_end = list[j][1];
        }
      }
      System.out.println(sum);
    }
    scanner.close();
  }

  public static void main(String[] args) {
    new Question().Q1();
  }

}
