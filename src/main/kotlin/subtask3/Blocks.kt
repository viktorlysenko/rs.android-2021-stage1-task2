package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.reflect.KClass

class Blocks {
    fun getSumIntInArray(blockA: Array<*>):Int{
        var resultSumm :Int = 0
        for (cell in blockA)
            if (cell is Int) resultSumm = resultSumm + cell

        return resultSumm
    }
    fun getResultString(blockA: Array<*>):String{

        var resultString: String = ""
        for (i in blockA)
            if (i is String){
                resultString="$resultString$i"
            }
        return resultString
    }

    fun getResultDate(blockA: Array<*>):String{
     val localDateNow: LocalDate = LocalDate.now()
     var minBetwen = 2021*365
     var resulDate = localDateNow
     for (cell in blockA)
         if (cell is LocalDate){
             val currMinBetwen = Math.abs(ChronoUnit.DAYS.between(cell,localDateNow).toInt())
             if (minBetwen >= currMinBetwen){
                 minBetwen = currMinBetwen
                 resulDate = cell
             }

         }
        return resulDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {

        return when(blockB) {
            String::class ->  getResultString(blockA)
            Int::class ->  getSumIntInArray(blockA)
            LocalDate::class ->  getResultDate(blockA)
            else -> println("type error")
        }
    }


}
