object main {
  def toLeet(str: String): Unit ={
    var string =""
    var string2 =""
    for(i <- 0 until str.length){
      string += Leet(str(i))
    }
    for(i <- 0 until str.length){
      string2 += matchTest(str(i))
    }
    println(string)
    println(string2)
  }

  def Leet(tmp: Char): String ={

    var str:String = tmp.toString
    if(str == "A" || str == "a") str = "4"
    if(str == "B" || str == "b") str = "I3"
    if(str == "C" || str == "c") str = "["
    if(str == "D" || str == "d") str = ")"
    if(str == "E" || str == "e") str = "3"
    if(str == "F" || str == "F") str = "|="
    if(str == "G" || str == "g") str = "6"
    if(str == "H" || str == "h") str = "#"
    if(str == "I" || str == "i") str = "|"
    if(str == "J" || str == "j") str = "_|"
    if(str == "K" || str == "k") str = "|<"
    if(str == "L" || str == "l") str = "1"
    if(str == "M" || str == "m") str = "^^"
    if(str == "N" || str == "n") str = "^"
    if(str == "O" || str == "o") str = "0"
    if(str == "P" || str == "p") str = "|o"
    if(str == "Q" || str == "q") str = "()_"
    if(str == "R" || str == "r") str = "I2"
    if(str == "S" || str == "s") str = "5"
    if(str == "T" || str == "t") str = "7"
    if(str == "U" || str == "u") str = "(_)"
    if(str == "V" || str == "v") str = "|_|"
    if(str == "W" || str == "w") str = "vv"
    if(str == "X" || str == "x") str = "><"
    if(str == "Y" || str == "y") str = "j"
    if(str == "Z" || str == "z") str = "2"
    str.toString
  }

  def matchTest(tmp: Char): String = tmp match{
    case 'A' | 'a' => "4"
    case 'B' | 'b' => "I3"
    case 'C' | 'c' => "["
    case 'D' | 'd' =>  ")"
    case 'E' | 'e' => "3"
    case 'F' | 'f' => "|="
    case 'G' | 'g' => "6"
    case 'H' | 'h' => "#"
    case 'I' | 'i' => "|"
    case 'J' | 'j' => "_|"
    case 'K' | 'k' => "|<"
    case 'L' | 'l' => "1"
    case 'M' | 'm' => "^^"
    case 'N' | 'n' => "^"
    case 'O' | 'o' => "0"
    case 'P' | 'p' => "|o"
    case 'Q' | 'q' => "()_"
    case 'R' | 'r' => "I2"
    case 'S' | 's' => "5"
    case 'T' | 't' => "7"
    case 'U' | 'u' => "(_)"
    case 'V' | 'v' => "|_|"
    case 'W' | 'w' => "vv"
    case 'X' | 'x' => "><"
    case 'Y' | 'y' => "j"
    case 'Z' | 'z' => "2"
    case _ => tmp.toString
  }


  def main(args: Array[String]): Unit = {
    val str = "WEGH wehwe we"

    toLeet(str)
  }

}
