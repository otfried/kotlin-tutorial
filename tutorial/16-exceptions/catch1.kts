import org.otfried.cs109.readString

val str = readString("Enter a number> ")

try {
  val x = str.toInt()
  println("You said: $x")
} 
catch (e: NumberFormatException) {
  println("'$str' is not a number")
}
