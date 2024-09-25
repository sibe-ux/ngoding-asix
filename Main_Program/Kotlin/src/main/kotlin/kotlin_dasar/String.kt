package kotlin_dasar

fun main() {

    var firstName = "sibe "
    var lastName = "test"
    var fullName = firstName + lastName
    println(fullName)

    var alamat = """
        oke jek,
        ini adalah multiline
        tapi menjorok kanan,
ini yang ga menjorok
taruh di paling kanan
    """
    println(alamat)

//    trim margin
    var tempat = """
        |oke jek,
        |ini adalah multiline
        |tapi menjorok kanan,
        |ini yang ga menjorok
        |taruh di paling kanan
    """.trimMargin()
    println(tempat + "\n")

    var lokasi = """
        >oke jek,
        >ini adalah multiline
        >tapi menjorok kanan,
        >ini yang ga menjorok
        >taruh di paling kanan
    """.trimMargin(">")
    println(lokasi)

//    string template
    var namaDepan = "Nasrul"
    var namaBelakang = "Wahabi"
    var namaLengkap = "$namaDepan $namaBelakang"
    println("\n"+namaLengkap+"\n")

    var desc = "aku $namaDepan $namaBelakang, char = ${namaLengkap.length}"
    println(desc)
}