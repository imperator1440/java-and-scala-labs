
object main {

  def encrypt(str: String): String = {
    var tmpStr: String = ""
    for (i <- 0 until str.length) {
      var temp = str(i)
      temp = temp match {
        case 'x' => 'a'
        case 'y' => 'b'
        case 'z' => 'c'
        case 'X' => 'A'
        case 'Y' => 'B'
        case 'Z' => 'C'
        case _ =>
          val temp1: Byte = temp.toByte
          val res = 3 + temp1
          res.toChar
      }
      tmpStr = tmpStr :+ temp
    }
    tmpStr
  }

  def decrypt (str: String) : String={
    var tmpStr : String = ""
    for (i <- 0 until str.length) {
      var temp = str(i)
      temp = temp match {
        case 'a' => 'x'
        case 'b' => 'y'
        case 'c' => 'z'
        case 'A' => 'X'
        case 'B' => 'Y'
        case 'C' => 'Z'
        case _ =>
          val temp1: Byte = temp.toByte
          val res = -3 + temp1
          res.toChar
      }
      tmpStr = tmpStr :+ temp
    }
    tmpStr
  }

  def inputInfo(map: Map[String, (String, String)]) : Map[String, (String, String)] = {
    var tmpMap : Map[String, (String, String)] = map
    var password : String =""
    var info : String =""
    var name : String =""

    while (name == "") {
      println("Enter name:")
      name = scala.io.StdIn.readLine()
    }

    while (info == "") {
      println("Enter info:")
      info = scala.io.StdIn.readLine()
    }
    info = encrypt(info)
    while (password == "") {
      println("Enter password:")
      password = scala.io.StdIn.readLine()
    }
    tmpMap += (name -> (info, password))
    tmpMap
  }

  def outInfo(map: Map[String, (String, String)]) : Unit = {
    var name : String = ""
    while (name == "") {
      println("Enter name:")
      name = scala.io.StdIn.readLine()
    }
    val value = map.get(name)
    value match {
      case Some(value) =>  if(value._1 != null && !value._1.isEmpty)  println(value._1)
      case None => println("information is not found")
    }
  }

  def outInfoWithPass(map: Map[String, (String, String)]) : Unit = {
    var name : String = ""
    var password : String =""
    var info : String =""
    while (name == "") {
      println("Enter name:")
      name = scala.io.StdIn.readLine()
    }
    val value = map.get(name)
    value match {
      case Some(value) =>   println("Enter password:")
        password = scala.io.StdIn.readLine()
        if(value._1 != null && !value._1.isEmpty) {
          if(password.equals(value._2)){
            info = value._1
            info = decrypt(info)
            println(info)
          }else{
            println("Wrong password")
          }
        }
      case None => println("information is not found")
    }
  }

  def main(args: Array[String]): Unit = {
      var flg : Boolean = true
      var values : Map[String, (String, String)] = Map.empty
      var ch : String = ""
      while(flg) {
        println("1) Add information\n2) Check information without password\n3) Check with password \n4) Exit")
        ch = scala.io.StdIn.readLine()
          ch = ch match {
            case "1" => values = inputInfo(values)
              "1"

            case "2" => outInfo(values)
              "2"

            case "3" => outInfoWithPass(values)
              "3"

            case "4" => flg = false
              "4"

            case _ => println("error")
              "5"
          }
      }

  }
}

