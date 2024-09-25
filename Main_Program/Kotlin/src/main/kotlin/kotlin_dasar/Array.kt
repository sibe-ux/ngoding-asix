package kotlin_dasar

fun main() {

//    default length array adalah fix/can't changed
    val member = arrayOf("sibe","test","oke")
    val kelas: Array<Int> = arrayOf(1,2,3)
    val rank: Array<Double> = arrayOf(1.2,3.4,5.6)

    val sibe = member[0]
    val test = member[1]
    val oke = member.get(2)

    println(sibe)
    println(oke)

    member[0] = "habi"
    member.set(2,"okejek")

    println(member[0])
    println(member[2])

//    array nullable
    val names: Array<String?> = arrayOfNulls(5)
    names[0] = "sibe"
    names[1] = null
    names[2] = "oke"
    names[3] = null
    names[4] = "jek"
    println(names.size) // output 5
}