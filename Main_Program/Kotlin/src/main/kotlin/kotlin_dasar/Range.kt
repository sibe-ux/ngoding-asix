package kotlin_dasar

fun main() {

    val range = 0..100
    println(range)
    println(range.count())
    println(range.contains(40))
    println(range.contains(211))
    println(range.first)
    println(range.last)
    println(range.step)

    val rangeReverse = 100 downTo 1
    println(rangeReverse)
    println(rangeReverse.step)

//    range with step
    val range1 = 1..100 step 5
    val range2 = 100 downTo 1 step 10
    println(range1)
    println(range2)
    println(range1.count())
    println(range2.count())
}