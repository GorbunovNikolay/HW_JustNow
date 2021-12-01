
fun main() {
    println(agoToText(60))
    println(agoToText(120))
    println(agoToText(300))
    println(agoToText(660))
    println(agoToText(1260))
    println(agoToText(1500))

    println(agoToText(3602))
    println(agoToText(3602 * 2))
    println(agoToText(3602 * 5))
    println(agoToText(3602 * 11))
    println(agoToText(3602 * 21))
    println(agoToText(3602 * 25))
}

fun agoToText(second : Int) : String {
    val minutes = (second / 60).toInt()
    val hours = (minutes / 60).toInt()
    val minutesString = signatureToNumerals("минуту", "минуты", "минут", minutes)
    val hoursString = signatureToNumerals("час", "часа", "часов", hours)

    return when {
        second in 0..60 -> "был(а) только что"
        second >= 61 && second <= 60 * 60 -> "был(а) в сети $minutes $minutesString назад"
        second >= 60 * 60 + 1  && second <= 24 * 60 * 60 -> "был(а) в сети $hours $hoursString назад"
        second >= 24 * 60 * 60 + 1  && second <= 2 * 24 * 60 * 60 -> "был(а) сегодня"
        second >= 2 * 24 * 60 * 60 + 1  && second <= 3 * 24 * 60 * 60 -> "был(а) вчера"
        second > 3 * 24 * 60 * 60 -> "был(а) давно"
        else -> "" //заглушка
    }
}

/**
 * Функция преобразует строку к множественному числу
 * Параметры:
 *  Слово1 - форма слова в ед. числе      ("шкаф")
 *  Слово2 - форма слова для числительных 2-4  ("шкафа")
 *  Слово3 - форма слова для числительных 5-10 ("шкафов")
 *  ЦелоеЧисло - целое число
 * Возвращаемое значение:
 * строка - одну из строк в зависимости от параметра ЦелоеЧисло
 */
fun signatureToNumerals(word: String, wordFrom2to4: String, wordFrom5to10: String, myInteger: Int) : String {
    var mySecond = myInteger
    // Изменим знак целого числа, иначе отрицательные числа будут неправильно преобразовываться
    if (mySecond < 0) mySecond *= -1

    // остаток
    val remains = mySecond % 10
    // для второго десятка - всегда третья форма
    if ((mySecond > 10)  && (mySecond < 20)) {
        return wordFrom5to10
    }
    else if (remains==1)  return word

    else if ((remains > 1) && (remains < 5)) return wordFrom2to4
    else return wordFrom5to10
}




