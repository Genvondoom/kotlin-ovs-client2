import java.net.Socket
import kotlin.reflect.typeOf


val client = Socket("127.0.0.1", 3309)
val input = client.getInputStream()
val output = client.getOutputStream()

fun send(message: String): String {

    output.write(message.toByteArray())
    return reciever()

}
fun send2(message: String): ArrayList<List<String>> {

    output.write(message.toByteArray())
    var list = arrayListOf<List<String>>()
    var status = ""
    while (true) {
        var tempMsg = reciever()
        if (tempMsg != "stop") {
            var temp = tempMsg.split(",").toList()
            list.add(temp)
        }
        else{
            break
        }

    }
    return list


}

fun reciever(): String {
    val recv = mutableListOf<Char>()
    var mesg = ""
    var conn = true
    while (conn) {

        val nextbyte = input.read()
        if (nextbyte.toChar() != '.')
            recv.add(nextbyte.toChar())
        else {
            val msg = recv.joinToString("")
            mesg = msg
            recv.clear()
            conn = false


        }

    }
    return mesg
}


fun main() {

    //println(send("login,18/1799,THimberland2"))
    //println(send("logout"))
    //create election
    //println(send("signup,18/1765,olatunjivictor1819@gmail.com,THimberland9"))
    println(send("login,18/1765,THimberland9"))
    //name, category, sch_dept, startingDate, startingtime, duration
    //println(send("create election,eah election,education and humanities,16/05/2022,04:20PM,2"))

    val list = send2("view election")
    println(list)
    val election = send2("select election,EH021822")
    println(election[0])
    print(send("join election,voter"))


    client.close()

}