import java.io.File

fun main(args: Array<String>) {
    getInput()
}

fun getInput() {
    var i = 0
    File("src/3_1.input").forEachLine { i += isValid(it) }
    print(i)
}

fun isValid(line: String): Int {
    val lineList = line.trim().split(" ")
    val x = lineList[0].trim().toInt()
    val y = lineList[1].trim().toInt()
    val z = lineList[2].trim().toInt()
    if (x + y > z && x + z > y && y + z > x) {
        return 1
    } else {
        return 0
    }
}