package subtask1

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        return try {
            val inputFormat:SimpleDateFormat = SimpleDateFormat(INPUT_DATE_FORMAT)
            inputFormat.isLenient = false
            val taskDate: Date = inputFormat.parse("$day.$month.$year")

            val newFormat: SimpleDateFormat = SimpleDateFormat(OUTPUT_DATE_FORMAT,Locale("RU"))

            newFormat.format(taskDate)
        }catch (e: ParseException){
            ERROR_DATE
        }

    }

    companion object{
        private const val ERROR_DATE :String = "Такого дня не существует"
        private const val INPUT_DATE_FORMAT :String = "dd.MM.yyyy"
        private const val OUTPUT_DATE_FORMAT :String = "dd MMMM, EEEE"
    }
}
