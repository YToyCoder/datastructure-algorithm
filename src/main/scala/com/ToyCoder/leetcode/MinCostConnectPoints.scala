package com.ToyCoder.leetcode

object MinCostConnectPoints {

  // problem
  // 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
  // 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
  // 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。

  import scala.collection.mutable.Set
  import scala.collection.mutable.Map
  // prim
  def apply(points: Array[Array[Int]]):Int = {
    // 1 * (n -1) + n - 2 + ... + 1
    points.length match {
      case 0 | 1 => 0
      case 2     => distance_between(points(0), points(1))
      case size => {
        val in_tree = Set[Array[Int]]()
        val out_tree = Set[Array[Int]]()
        points.foreach(out_tree.add _)
        out_tree -= points(0)
        in_tree += points(0)
        var cost = 0
        def do_calc(): Unit = {
          if(!out_tree.isEmpty) {
            val (el, c) = min_point(in_tree, out_tree)
            in_tree += el
            out_tree -= el
            cost += c
            do_calc()
          } 
        }
        do_calc()
        cost
      }
    }
  }

  def min_point(in: Set[Array[Int]], out: Set[Array[Int]]): ( Array[Int], Int) = {
    var r : Array[Int] = null
    var distance = Int.MaxValue
    for
      i <- in
      o <- out
      dist = distance_between(i, o)
      if(distance > dist) 
    do
      r = o
      distance = dist
    (r, distance)
  }
  def distance_between(a: Array[Int], b: Array[Int]) : Int = {
    Math.abs(a(0) - b(0)) + Math.abs(a(1) - b(1))
  }

  val map:Map[Array[Int], Map[Array[Int], Int]] = Map()

  def main(args: Array[String]): Unit = {
    println( apply(Array(Array(3,12),Array(-2,5),Array(-4,1))) )
  }
}
