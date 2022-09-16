package com.learn.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class SearchAndSort {

  public static <T> List<T> findKClosest(
    List<T> ls, // source
    int k, // number
    T x, // close to x
    /** (a, b) => a - b */
    BiFunction<T,T, Integer> compare,
    BiFunction<T,T, Integer> distanceBetween
  ) {
    int crossover_point = findCrossOver(ls, 0, ls.size() - 1, x, compare);
    // left and right
    /**
     * <--- left ---- right --->
     */
    int left = crossover_point, right = crossover_point + 1; 
    int count = 0;
    List<T> ans = new ArrayList<>(k);
    while(left >= 0 && right < ls.size() && count < k){
      if(distanceBetween.apply(ls.get(left),x) >= distanceBetween.apply(ls.get(right), x))
        ans.add(ls.get(left--));
      else ans.add(ls.get(right++));
    }
    return ans;
  }

  /**
   * find the el (cross over point) index before which are smaller than or equal to {@code x} and after which greater than {@code x}
   * binary search
   * @param <T>
   * @param arr
   * @param start
   * @param end
   * @param x
   * @return
   */
  private static <T> int findCrossOver(List<T> arr, int start, int end, T x, BiFunction<T,T,Integer> compare){
    if(compare.apply(x, arr.get(end)) > 0) return end;
    if(compare.apply(x, arr.get(start)) < 0) return start;
    int left = start, right = end, mid = (left + right) / 2;
    while(compare.apply(arr.get(mid), x) > 0 || compare.apply(arr.get(mid + 1), x) <= 0){
      if(compare.apply(arr.get(mid), x) > 0){
        right = mid;
      }else 
        left = mid;
    }
    return mid;
  }

  public static <T extends Comparable<T> > List<T> findKclosest(List<T> ls, int k, T x, BiFunction<T,T,Integer> distanceBetween){
    return findKClosest(ls, k, x, T::compareTo, distanceBetween);
  }

  public static <T extends Comparable<T> > int binary_search(List<T> ls, T target){
    int start = 0;
    int end = ls.size();
    while(start < end){
      final int mid = (start + end) >> 1;
      int comp_result = target.compareTo(ls.get(mid));
      if(comp_result == 0)
        return mid;
      else if(comp_result < 0)
        end = mid;
      else
        start = mid;
    }
    return -1;
  }

}