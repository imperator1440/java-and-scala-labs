import Array.{ofDim, _}

object main {

  def mul(res: Int, elem: Int) : Int = res * elem


  def result(res: Int, elem: Int , mull: (Int, Int) => Int): Int ={
    val resultsOfMul = mull(res, elem)
    resultsOfMul
  }

  def main(args: Array[String]): Unit = {
    val myMatrix = ofDim[Int](5,5)
    var res = 1
    var highRes = 1
    for(i <- 0 to 4){
      for(j <- 0 to 4){
        myMatrix(i)(j) = (i * 5) + j + 1
      }
    }

    for(i <- 0 to 4){
      for(j <- 0 to 4){
        print(myMatrix(i)(j) + " ");
      }
      println()
    }

    for(i <- 0 to 4){
      for(j <- 0 to 4){
       if(i == j) res *= myMatrix(i)(j)
       if((i + j) == 4) res *=  myMatrix(i)(j)
      }
    }

    for(i <- 0 to 4){
      for(j <- 0 to 4){
        if(i == j) highRes = result(highRes, myMatrix(i)(j), mul)
        if((i + j) == 4) highRes = result(highRes, myMatrix(i)(j), mul)
      }
    }

    println("Result: " + res)
    println("Result high: " + highRes)
  }
}
