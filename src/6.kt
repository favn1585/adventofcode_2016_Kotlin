import java.io.File

val wordSize = 8

fun main(args: Array<String>) {
    pt1()
    pt2()
}

fun pt1() {
    for(i in 0..wordSize-1) {
        var column = ""
        File("src/6.input").forEachLine { column += it.get(i) }
        val checksum = getCheckSum(column)
        //print(checksum.get(0))
    }
}

fun pt2() {
    for(i in 0..wordSize-1) {
        var column = ""
        File("src/6.input").forEachLine { column += it.get(i) }
        val checksum = getCheckSum(column)
        println(checksum)

        //k/t,q/p,s/o,d/o,m/c,z/c,f/y,t/o,

        //tpooccyo

        //kqsdmzft

        //????
    }
}