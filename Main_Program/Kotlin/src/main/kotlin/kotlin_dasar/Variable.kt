package kotlin_dasar

// const variable harus di luar func
const val APP = "mobile"
const val DESC = "android"

fun main() {

//    var = mutable
//    val = immutable

    // Nullable variable (not recommended)
    var namaDepan: String? = "sibe"
    namaDepan = null

//    error karena namaDepan bisa null
//    println(namaDepan.length)

//    cara yang benar
    println(namaDepan?.length)

    println("$APP : $DESC")
}