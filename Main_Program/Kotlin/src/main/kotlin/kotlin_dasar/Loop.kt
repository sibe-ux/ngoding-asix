package kotlin_dasar

fun main() {

//    for loop
    println("increase")
    // gunakan step jika mau naik lebih dari 1
    for (x in 1 .. 5 step 2){
        println(x)
    }

    println("\ndecrease")
    for (x in 5 downTo 1){
        println(x)
    }

    // while loop
    println("\nwhile")
    var x = 1
    while (x <= 10){
        println(x)
        x++
    }

    // Array Loop
    val fish = mutableListOf("nila","lele","gurame")
    for (z in fish) println(z)

}