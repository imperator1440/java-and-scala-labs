object main {

//  def fun1(number: List[Int], list: List[Int]): List[Int] =
//  {
//    fun2(number, list, 0)
//  }

  @scala.annotation.tailrec
  def fun2(number: List[Int], list: List[Int], index: Int): List[Int] ={
    if(index == number.size - 1) return list
    if(!list.contains(number(index))){
      fun2(number, list:+number(index), index + 1)
    }else  fun2(number, list, index + 1)
  }

  def main(args: Array[String]) {
    val numbers: List[Int] = List(1, 1, 2, 3, 3, 4, 5, 5)
    var list: List[Int] = List()
    for(counter <- numbers.indices){
      if(!list.contains(numbers(counter))){
        list = list :+ numbers(counter)
      }
    }

    println(list)

    var list2: List[Int] = List()
    list2 = fun2(numbers, list2, 0)

    println(list2)

  }


}
