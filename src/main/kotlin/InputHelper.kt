class InputHelper() {
    private var year: Int
    private var month: Int

    init {
        month = calculateMonth()
        year = calculateYear()
    }


    private fun calculateMonth() : Int{
        var valid : Boolean = false
        var month: Int = 0
        while (!valid) {
            println("Please enter the desired month to display(1-12) ")
            month = Integer.valueOf(readLine())
            if (month in 1..12) {
                valid = true
            }
        }
        return month
//    println("Please enter the year that your desired month is in after 1752. ")
//    return Integer.valueOf(readLine())
    }

    fun getMonth(): Int {
        return month
    }

    fun getYear(): Int {
        return year
    }
}
    fun calculateYear() : Int {
        var valid : Boolean = false
        var year: Int = 0
        while (!valid) {
            println("Please enter the year that your desired month is in after 1752. ")
            year = Integer.valueOf(readLine())
            if (year >= 1753) {
                valid = true
            }
        }
        return year
    //    println("Please enter the year that your desired month is in after 1752. ")
    //    return Integer.valueOf(readLine())
    }






