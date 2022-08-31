package com.learn.honor;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    Q_8_30();
  }

  static void Q_8_30(){
    Scanner scanner = new Scanner(System.in);
    List<String> standard = Stream.of(scanner.nextLine().split(" "))
      .filter(el -> el.length() != 0)
      .collect(Collectors.toList());
    List<String> anwser = Stream.of(scanner.nextLine().split(" "))
      .filter(el -> el.length() != 0)
      .collect(Collectors.toList());
    int max = max_value(standard, anwser, 0, 0);
    System.out.println(standard.size() + max);
    scanner.close();
  }

  private static int max_value(List<String> standard, List<String> anwser, int s_start, int a_start){
    if(s_start == standard.size()) return - ( anwser.size() - a_start );
    if(a_start == anwser.size()) return - 2 * (standard.size() - s_start );
    if(Objects.equals(standard.get(s_start), anwser.get(a_start))){
      return Math.max(
        Math.max( 
          max_value(standard, anwser, s_start + 1, a_start + 1), 
          max_value(standard, anwser, s_start + 1, a_start) - 2 /* missing */
        ), 
        /* add */max_value(standard, anwser, s_start, a_start + 1) - 1
      );
    }else {
      int temp = Math.max( 
        max_value(standard, anwser, s_start + 1, a_start /* missing */) - 2, 
        max_value(standard, anwser, s_start, a_start + 1) - 1
      );
      return is_replace(standard.get(s_start), anwser.get(a_start)) ? 
      Math.max(
        temp, 
        max_value(standard, anwser, s_start + 1, a_start + 1) - 1
      ) : 
      temp;
    }
  }

  private static boolean is_replace(String replace, String source){
    char[] scs = source.toCharArray();
    char[] rcs = replace.toCharArray();
    Arrays.sort(scs);
    Arrays.sort(rcs);
    int count = 0;
    int left = 0;
    int left_r = 0;
    
    while(left_r < replace.length() && left < source.length()){
      while(left_r < replace.length() && left < source.length() && !Objects.equals( scs[left], rcs[left_r])){
        if(scs[left] < rcs[left_r]){
          left++;
        }else left_r++;
      }
      if(left_r < replace.length() && left < source.length())
        count++;
      left++;
      left_r++;
    }
    return count > replace.length() / 2;
  }

}
