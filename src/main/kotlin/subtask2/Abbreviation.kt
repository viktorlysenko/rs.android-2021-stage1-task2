package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        var aUpperCase = a.toUpperCase()
        var indexA = 0
        var indexB = 0
        while(indexA <= aUpperCase.length - 1 && indexB <= b.length-1) {
            if(aUpperCase[indexA] == b[indexB]) {
                indexB++
            }
            indexA++
        }
        println(indexB)
        return if (b.length == indexB) "YES" else "NO"
    }
}
