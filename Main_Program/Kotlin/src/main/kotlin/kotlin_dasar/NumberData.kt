package kotlin_dasar

fun main() {
//    Integer number
    val tas : Byte = 30
    var age: Int = 200
    var distance: Short = 2000
    var ages: Long = 10000L

    println(tas)

//    Floating point number
    val sample: Float = 10.10F
    var radius: Double = 2313.233

    println(sample)

//    literals
    var decimalLiteral: Int = 100
    val hexadecimalLiteral : Int = 0xFFF092
    var binaryLiteral: Int = 0b01010101

    println(hexadecimalLiteral)

//    underscore in number
    val tas1 : Byte = 3_0
    var age1: Int = 2_000
    var distance1: Short = 20_000
    val ages1: Long = 100_000L

    println(ages1)

//    konversi
    val number: Int = 100

    var byte: Byte = number.toByte()
    var short: Short = number.toShort()
    var int: Int = number.toInt()
    var long: Long = number.toLong()
    val float: Float = number.toFloat()
    var double: Double = number.toDouble()

    println(float)
}