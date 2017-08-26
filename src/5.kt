fun main(args: Array<String>) {
    var password = ""
    val input = "abbhdwsy"

    var index = 0

    //Pt1
    while (password.length < 8) {
        val hash = Crypto.md5(input + index)
        if (hash.substring(0, 5) == "00000") {
            password += hash.get(5)
            print(password.last())
        }
        index++
    }

    //Pt2
    index = 0
    var passArray = arrayListOf('.', '.', '.', '.', '.', '.', '.', '.')
    while (passArray.contains('.')) {
        var hash = Crypto.md5(input + index)
        if (hash.substring(0, 5) == "00000") {
            try {
                //Char converted to int gives char code but we need number formatting
                val passIndex = hash.get(5).toString().toInt()
                if (passIndex < 8 && passArray[passIndex] == '.') {
                    passArray[passIndex] = hash.toCharArray()[6]
                }
            } catch (e: NumberFormatException) {
                //Go dummy
            }
        }
        index++
    }
    print(passArray)
}