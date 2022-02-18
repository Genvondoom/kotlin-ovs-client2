val test = "hi,hello,|hi2,hello2"

fun main() {
    var tempMainlist = mutableListOf<ArrayList<String>>()
    var templist = arrayListOf<String>()
    var temp = ""
    for (x in test) {

        if (x != '|') {

            if (x != ',') {
                temp += x
            } else {
                println(temp)
                templist.add(temp)
                temp= ""
            }
        }
        else{
            tempMainlist.add(templist)
            templist.clear()
        }

    }
    println(tempMainlist)
}











