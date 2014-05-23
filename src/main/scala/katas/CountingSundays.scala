package katas

/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

object CountingSundays {
  def apply() = {
    def cal = Stream.from(1900).map(year => {
      1.to(12).map(month => {
        def days: Int = {
          assert(month >= 1 && month <= 12)
          val leap = 2 // feb
          val ds30 = Set(4, 6, 9, 11)
          val ds31 = 1.to(12).toSet -- ds30 - leap
          (ds30.zip(Stream.continually(30)) ++ ds31.zip(Stream.continually(31))).toMap.getOrElse(month, {
            val isLeap = {
              val isCentury = year % 1000 == 0
              if (isCentury) year % 400 == 0 else year % 4 == 0
            }
            if (isLeap) 29 else 28
          })
        }
        1.to(days).map(day => {
          (year, month, day)
        })
      })
    }).flatten.flatten.zip(Stream.continually(1.to(7)).flatten).map({case ((y,m,d),wd) => (y,m,d,wd)})
    cal.dropWhile(_._1 == 1900).filter(_._3 == 1).filter(_._4 == 7)
      .takeWhile({case (y,m,d,_) => y <= 2000 && m <= 12 && d <= 31})
      .length
  }
}
