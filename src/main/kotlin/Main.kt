fun main() {
    val inputHelper = InputHelper()
    val month = inputHelper.getMonth()
    val year = inputHelper.getYear()
    val count = getOffset(month, year)
    displayCalendar(month, year, count)
}

fun displayCalendar(month : Int, year : Int, count : Int){
    val m = sizeOfMonth(month, year)
    var dow = count

    println("S  M  T  W  T  F  S")
    for (i in 1..dow) {
        print("   ")
    }
    for (dom in 1..m) {
        if (dom < 10) {
            print("$dom  ")
            dow += 1
        }else {
            print("$dom ")
            dow += 1
        }
        if (dow % 7 == 0) {
            print("\n")
        }
    }
//    if (dow % 7 != 0){
//        print("\n")
//    }
}

fun getOffset(month: Int, year: Int): Int {
    val count1: Int = getDaysYears(year)
    val count2: Int = getDaysMonths(month, year)
//    print(count2)
//    print(((count1 + count2) + 1) % 7)
    return (((count1 + count2) + 1) % 7)

}

fun getDaysYears(year: Int): Int {
    val years = getYearsList(year)
    val count1 = years.size * 365
    val leaps = leapYearCount(years)
//    println("count1 $count1 + $leaps")
    return count1 + leaps
}

fun getYearsList(year:Int) : MutableList<Int>{
    val years: MutableList<Int> = mutableListOf<Int>()
    for (i in (1753..year)) {
        years.add(i)
    }
    return years
}

fun leapYearCount(years : MutableList<Int>) : Int {
    var count : Int = 0
    for (year in years) {
        val lyear = determineLeapYears(year)
        if (lyear) {
            count += 1
        }
    }
//    print(count)
    return count
}

fun determineLeapYears(year:Int) : Boolean {
    var lyear : Boolean? = null
    if (year % 4 == 0 && year % 100 != 0) {
        lyear = true
        if (year % 400 == 0) {
            lyear = true
        }
    } else {
        lyear = false
    }
    return lyear
}

fun getDaysMonths(month : Int, year : Int) : Int{
    var count : Int = 0
    for (i in 1 until month) {
        var daysMonth = sizeOfMonth(i, year)
        count += daysMonth
    }

    return count
}

fun sizeOfMonth(month : Int, year : Int) : Int {
    var days = 0
    if (month == 4 || month == 6 || month == 9 || month == 11) {
        days = 30
    } else if (month == 2) {
        var lyear : Boolean = determineLeapYears(year)
        if (lyear) {
            days = 29
        } else {
            days = 28
        }
    }else {
        days = 31
    }
    return days
}



