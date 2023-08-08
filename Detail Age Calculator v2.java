/*
Age Calculator : show age with years, months, days, hours, minutes and second.
Code by SK Naing.
You can use this code freely.
*/
/*
Do not change the code up to down or down to up.
codeတွေကို အပေါ်အောက် သွားမပြောင်းပါနဲ့။
*/
/*

How to use the code?
Codeအသုံးပြုနည်း။

edittext_birth_day
edittext_birth_month
edittext_birth_year
Add 3 EditText with the 3 names mentioned above.
အပေါ်ကid 3ခုနဲ့ EditText 3ခုaddပါ။

textview_yyyy_MM_dd
textview_total_months
textview_total_weeks
textview_total_days
textview_total_hour
textview_total_minute
textview_total_second
Add 7 TextView with the 7 names mentioned above.
အပေါ်ကid 7ခုနဲ့ TextView 7ခု​addပါ။

totalHours
totalMinutes
totalSeconds
Add 3 Number Variable with the 3 names mentioned above.
အပေါ်က နာမည် ၃ခုနဲ့ number variable ၃ခုaddပါ။

Add 1 Calendar component with the name calendar1.
calendar1 ဆိုတဲ့နာမည်နဲ့ Calendar component ၁ခုaddပါ။

Add 1 timer component with the name timer1.
timer1 ဆိုတဲ့နာမည်နဲ့ timer component ၁ခုaddပါ။

Add 1 Button and add the following codes to onClick.
Button ၁ခုaddပြီး onClickမှာ အောက်ကcodeတွေကို ထည့်ပါ။

Then you can run the project
ပြီးရင် projectကို runလို့ ရပါပြီ။

*/

try {
timer1.cancel();
} catch(Exception e) {

}

double birth_day = Double.parseDouble(edittext_birth_day.getText().toString());
double birth_month = Double.parseDouble(edittext_birth_month.getText().toString());
double birth_year = Double.parseDouble(edittext_birth_year.getText().toString());
calendar1 = Calendar.getInstance();
double now_day = Double.parseDouble(new SimpleDateFormat("dd").format(calendar1.getTime()));
double now_month = Double.parseDouble(new SimpleDateFormat("MM").format(calendar1.getTime()));
double now_year = Double.parseDouble(new SimpleDateFormat("yyyy").format(calendar1.getTime()));
double now_hour = Double.parseDouble(new SimpleDateFormat("HH").format(calendar1.getTime()));
double now_minute = Double.parseDouble(new SimpleDateFormat("mm").format(calendar1.getTime()));
double now_second = Double.parseDouble(new SimpleDateFormat("ss").format(calendar1.getTime()));

//Total Days
int birth_day2 = (int)birth_day;
int birth_month2 = (int)birth_month;
int birth_year2 = (int)birth_year;

int now_day2 = (int)now_day;
int now_month2 = (int)now_month;
int now_year2 = (int)now_year;
LocalDate startDate = LocalDate.of(birth_year2, birth_month2, birth_day2);
        LocalDate endDate = LocalDate.of(now_year2, now_month2, now_day2);

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        textview_total_days.setText(daysBetween + " days");
textview_total_days.setText(textview_total_days.getText().toString().concat(" + ".concat(String.valueOf((long)(now_hour)).concat(" hours"))));

//Total Weaks
        int totalDays = (int)daysBetween;
        int daysInAWeek = 7;

        int weeks = totalDays / daysInAWeek;
        int remainingDays = totalDays % daysInAWeek;

        textview_total_weeks.setText(weeks + " weeks + " + remainingDays + " days");

/*
Before calculating Total Weeks, must first calculate Total Days.
*/

//Total Months
     double startYear = 0;
double endYear = 0;
double ageYear = 0;
double startMonth = 0;
double endMonth = 0;
double resultMonth = 0;
double startDay = 0;
double allDay = 0;
String plusDay = "";
double day2 = 0;


startYear = birth_year;
endYear = now_year - 1;
ageYear = endYear - startYear;
resultMonth = ageYear * 12;

startMonth = birth_month;
endMonth = now_month - 1;
resultMonth = resultMonth + (12 - startMonth);
resultMonth = resultMonth + endMonth;

if ("04,06,09,11".contains(String.valueOf((long)(now_month)))) {
startDay = 30 - birth_day;
}

if ("01,03,05,07,08,10,12".contains(String.valueOf((long)(now_month)))) {
startDay = 31 - birth_day;
}

if (2 == birth_month) {
int input_year = (int)birth_year;
        boolean isLeapYear = false;

        if ((input_year % 4 == 0 && input_year % 100 != 0) || input_year % 400 == 0) {
            isLeapYear = true;
        }

        if (isLeapYear) {
            //leap year
     startDay = 29 - birth_day;
        } else {
            //not leap year
startDay = 28 - birth_day;
        }
}

allDay = startDay + now_day;

if ("02".contains(String.valueOf((long)(now_month)))) {
int input_year = (int)birth_year;
        boolean isLeapYear = false;

        if ((input_year % 4 == 0 && input_year % 100 != 0) || input_year % 400 == 0) {
            isLeapYear = true;
        }

       if (isLeapYear) {
            //leap year
      if (28 < allDay) {
resultMonth++;
day2 = allDay - 29;
   }
else {
plusDay = " + ".concat(String.valueOf((long)(allDay)).concat(" days"));
   }
        } else {
            //not leap year
  if (27 < allDay) {
resultMonth++;
day2 = allDay - 28;
   }
  else {
plusDay = " + ".concat(String.valueOf((long)(allDay)).concat(" dys"));
   }
        }
}
if ("04,06,09,11".contains(String.valueOf((long)(now_month)))) {
if (29 < allDay) {
resultMonth++;
day2 = allDay - 30;
}
else {
plusDay = " + ".concat(String.valueOf((long)(allDay)).concat(" days"));
}
}
if ("01,03,05,07,08,10,12".contains(String.valueOf((long)(now_month)))) {
if (30 < allDay) {
resultMonth++;
day2 = allDay - 31;
}
else {
plusDay = " + ".concat(String.valueOf((long)(allDay)).concat(" days"));
}
}
if ("".equals(plusDay)) {
if (1 > day2) {
textview_total_months.setText(String.valueOf((long)(resultMonth)).concat(" months + 0 days"));
}
else {
plusDay = " + ".concat(String.valueOf((long)(day2)).concat(" days"));
textview_total_months.setText(String.valueOf((long)(resultMonth)).concat(" months").concat(plusDay));
}
}
else {
textview_total_months.setText(String.valueOf((long)(resultMonth)).concat(" months").concat(plusDay));
}

//Total Hours, Minutes and Seconds
//Age with Hours
totalHours = (double)daysBetween * 24;
totalHours = totalHours + now_hour ;
textview_total_hours.setText(String.valueOf((long)(totalHours)).concat(" hours + ".concat(new SimpleDateFormat("mm").format(calendar1.getTime()).concat(" minutes"))));

//Age with Minutes
totalMinutes = totalHours * 60;
totalMinutes = totalMinutes + now_minute ;
textview_total_minutes.setText(String.valueOf((long)(totalMinutes)).concat(" minutess + ".concat(new SimpleDateFormat("ss").format(calendar1.getTime()).concat(" seconds"))));

//Age with Second
totalSeconds = totalMinutes * 60;
totalSeconds = totalSeconds + now_second ;
textview_total_seconds.setText(String.valueOf((long)(totalSeconds)).concat(" seconds"));

//Realtime Minutes and Seconds
timer1 = new TimerTask() {
@Override
public void run() {
runOnUiThread(new Runnable() {
@Override
public void run() {
totalSeconds++;
textview_total_seconds.setText(String.valueOf((long)(totalSeconds)).concat(" seconds"));

calendar1 = Calendar.getInstance();
textview_total_minutes.setText(String.valueOf((long)(totalMinutes)).concat(" minutes + ".concat(new SimpleDateFormat("ss").format(calendar1.getTime()).concat(" seconds"))));
if (00 == Double.parseDouble(new SimpleDateFormat("ss").format(calendar1.getTime()))) {
totalMinutes++;
textview_total_minutes.setText(String.valueOf((long)(totalMinutes)).concat(" minutes + ".concat(new SimpleDateFormat("ss").format(calendar1.getTime()).concat(" seconds"))));
textview_total_hours.setText(String.valueOf((long)(totalHours)).concat(" hours + ".concat(new SimpleDateFormat("mm").format(calendar1.getTime()).concat(" minutes"))));
}
}
});
}
};
_timer.scheduleAtFixedRate(timer1, (int)(0), (int)(1000));

//years, months, days Format
     double yyyyMMddYears = 0;
double yyyyMMddMonths = 0;
     double yyyyMMddDays = 0;
double totalDayOfMonth = 0;

if ("02".contains(String.valueOf((long)(now_month)))) {
int input_year = (int)birth_year;
        boolean isLeapYear = false;

        if ((input_year % 4 == 0 && input_year % 100 != 0) || input_year % 400 == 0) {
            isLeapYear = true;
        }

        if (isLeapYear) {
            //leap year
     totalDayOfMonth =29;
        } else {
            //not leap year
totalDayOfMonth =28;
               }
}

if ("04,06,09,11".contains(String.valueOf((long)(now_month)))) {
totalDayOfMonth = 30;
}

if ("01,03,05,07,08,10,12".contains(String.valueOf((long)(now_month)))) {
totalDayOfMonth = 31;
} 
yyyyMMddYears = now_year - birth_year;
if (birth_month > now_month) {
yyyyMMddYears--;
yyyyMMddMonths = birth_month - now_month;
yyyyMMddMonths = 12 - yyyyMMddMonths;
}
else {
yyyyMMddMonths = now_month - birth_month;
}
if (birth_day > now_day) {
yyyyMMddMonths--;
yyyyMMddDays = birth_day - now_day;
yyyyMMddDays = totalDayOfMonth - yyyyMMddDays;
}
else {
yyyyMMddDays = now_day - birth_day;
}
if (0 > yyyyMMddMonths) {
yyyyMMddYears--;
yyyyMMddMonths = 12 + yyyyMMddMonths;
}
else {

}
textview_yyyy_MM_dd.setText(String.valueOf((long)(yyyyMMddYears)).concat(" years + ".concat(String.valueOf((long)(yyyyMMddMonths)).concat(" months + ".concat(String.valueOf((long)(yyyyMMddDays)).concat(" days"))))));


/*

Hours, Minutes, Seconds Different Problem

This has more hours, minutes and seconds than some age calculators. This is because it takes into account the current hours, minutes and seconds. For example, if today is the 24th, some age calculators calculate until 12:00 on the 23rd. If it is the 24th, this also takes into account the current time of the 24th. For example, if the current time is 7 am on the 24th, this will be 7 hours more than some age calculators. 

//

Hours, Minutes, Seconds ကွားခြားမှု ပြဿနာ

ဒီဟာက တစ်ချို့age calculatorတွေထက် hours, minutsနဲ့ secondတွေ ပိုများနေတက်တယ်။
ဘာဖြစ်လို့လည်းဆိုတော့ ဒီဟာက ခုလက်ရှိ ရောက်နေတဲ့ hours, minutesနဲ့ secondsကိုပါ ထည့်တွက်ထားလို့ပါ။
ဥပမာ ဒီနေ့က 24ရက်နေ့ဆိုရင် တချို့age calculatorတွေက 23ရက်နေ့ရဲ့ ည12နာရီအထိဘဲ တွက်ပေးတယ်။
ဒီဟာကကျတော့ 24ရက်နေ့ဆိုရင် 24ရက်နေ့ရဲ့ ခုရောက်နေတဲ့အချိန်ကိုပါ ထည့်တွက်ပေးတယ်။
ဥပမာ ခုရောက်နေ့တဲ့အချိန်က 24ရက်နေ့ရဲ့ မနက်7နာရီဆိုရင် ဒီဟာက တချို့age calculatorတွေထက် 7နာရီ ပိုများနေလိမ့်မယ်။

*/
/*

Months + Days ကွာခြားမှု ပြဿနာ

ဒီဟာက တချို့age calculatorတွေထက် Monthsစုစုပေါင်းနဲ့Day(Months + Days)မှာ ၁ရက်၊ ၂ရက်၊ ၃ရက် စသည်ဖြင့် ပိုနည်းနေတက်တယ်။
ဘာဖြစ်လို့လည်းဆိုတော့ ဒီဟာက Months + Daysကို အတိအကျ တွက်ပေးလို့ပါ။
ဥပမာ မွေးနေ့က 2လပိုင်း 20ရက်နေ့ဖြစ်ပြီး ခုလက်ရှိအချိန်က 7လပိုင်း 15ရက်ဆိုရင် Monthsကိုတွက်တဲ့အခါ မွေးလဖြစ်တဲ့ 2လပိုင်းထက် ၁လပိုပြီး ၃လပိုင်း(2+1=3)ကနေ ခုလက်ရှိ ရောက်နေတဲ့ Monthsထက် 1လလျော့ပြီး(7-1=6) 6လပိုင်းအထိဘဲ တွက်ပေးရတယ်။
3လပိုင်းကနေ 6လပိုင်းအထိဆိုတော့ 4လရှိတယ်။(3,4,5,6)
ပြီးတော့ 2လပိုင်း 20ရက်နေ့မှာ မွေးပြီး၊ မွေးတဲ့လက စုစုပေါင်း 28ရက် ရှိတာဆိုတော့ 28ထဲက 20ကို နုတ်မယ်။(28-20=8) 8ရက်ကျန်မယ်။
ခုလက်ရှိအချိန်က 7လပိုင်း 15ရက်ဆိုတော့ 15ရက်ကို ယူမယ်။
ပြီးရင် ခုနက 8နဲ့ 15ကို ပေါင်းမယ်။(8+15=23) 23ရတယ်။
အဲ့ဒီ့တော့ 4 Months + 23 Days ရတယ်။

တချို့age calculatorတွေမှာကျတော့ လတွေကို 31ရက်နဲ့ဘဲ တွက်ပေးတယ်။
အပေါ်မှာ ပြောခဲ့သလို မွေးနေ့က 2လပိုင်း 20ရက်နေ့ဆိုရင် ဒီဟာမှာက(28-20=8)လို့ တွက်ပေးပေမဲ့ တချို့age calculatorတွေမှာကျတော့(31-20=11)လို့ တွက်ပေးလိမ့်မယ်။
အမှန်ဆိုရင် 2လပိုင်းက 28ရက်(ရက်ထပ်နှစ်ဆိုရင်29ရက်)ဘဲ ရှိတာဆိုတော့ 28ထဲက 20ကို နှုတ်ပေးရမှာ။

လက်တွေ့စမ်းကြည့်ချင်ရင် ဒီcodeကို runပြီး မွေးနေ့မှာ 5ရက် 2လ 2023လို့ ထည့်ပြီးတွက်ကြည့်။
တခြားage calculatorမှာလဲ 5ရက် 2လ 2023လို့ ထည့်ပြီးတွက်ကြည့်။
ဒီဟာက 3ရက် ပိုပြီး နည်းနေလိမ့်မယ်။

//

Months + Days Different Problem

This age calculator
7/2/2023 to 7/7/2023 = 5 Months + 28 Days

Other age calculator
7/2/2023 to 7/7/2023 = 6 Months + 0 Days

Different 3 Days, because :

This age calculator
28 - 7 = 21

Other age calculator
31 - 7 = 24

Actually, February have 28 days.
Therefore (28 - 7 = 21) is correct.

*/
/*

Code Link
https://raw.githubusercontent.com/mejoinpar333/ForShare/main/Detail%20Age%20Calculator%20v2.java

*/
