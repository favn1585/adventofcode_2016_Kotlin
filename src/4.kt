import java.io.File

val checkSumSize = 5

fun main(args: Array<String>) {
    print(File("src/4.input").readLines().map { getNumber(it) }.sum())

    print(File("src/4.input").readLines().map { decrypt(it) })
}

//aaaaa-bbb-z-y-x-123[abxyz]
fun getNumber(line: String): Int {
    val checksum = line.split('[')[1].replace("]", "")
    val number = line.split('-').last().split('[')[0].toInt()

    if (getCheckSum(line.replace(String.format("-%s[%s]", number, checksum), "")) == checksum) {
        return number
    }

    return 0
}


//aaaaa-bbb-z-y-x
//5, 3, 1, 1, 1
fun getCheckSum(line: String): String {
    val normalizedLine = line.replace("-", "")
    val map = sortedMapOf<Char, Int>()

    //TODO Can I use map here? No matter I think
    for (char in normalizedLine.toCharArray()) {
        if (map.containsKey(char)) {
            map.replace(char, map.getValue(char) + 1)
        } else {
            map.put(char, 1)
        }
    }

    //TODO pair.values.min() nullable wtf?
    //map.values.min()?.let {  }

    //If there are more than 5 different letter types
    var values = map.values.distinct().sorted()
    val dropSize = values.size - checkSumSize
    if (dropSize > 0) {
        values = values.drop(dropSize)
    }
    values = values.sortedDescending()

    var checksum = ""

    var numberSize = values.size
    if (numberSize > checkSumSize) {
        numberSize = checkSumSize
    }

    for (i in 0..numberSize - 1) {
        //TODO descending to drop first. Are there a way to drop last items?
        var numberItems = map.filter { it.value == values[i] }.keys.sortedDescending()
        val maxItemsToAdd = checkSumSize - checksum.length

        if (maxItemsToAdd > 0) {
            //TODO somehow filter by index
            if (numberItems.size > maxItemsToAdd) {
                numberItems = numberItems.drop(numberItems.size - maxItemsToAdd)
            }

            numberItems = numberItems.sorted()

            checksum += numberItems.joinToString("")
        }
    }

    return checksum
}

//aaaaa-bbb-z-y-x
fun decrypt(line: String) {
    val number = line.split('-').last().split('[')[0].toInt()
    var alphabet = ""
    for (i in 0..500) {
        //FIXME What the hell are you doing)?????
        alphabet += "abcdefghijklmnopqrstuvwxyz"
    }

    var cypherText = ""

    for (char in line.toCharArray()) {
        for (i in 0..alphabet.length - 1) {
            if (alphabet[i] == char) {
                cypherText += alphabet[i + number]
                break
            }
        }
    }

    println(cypherText + " " + number)
}
