import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ScheduleManager {
    
    
    static void printCurrentDateTime(){
        LocalDateTime time=LocalDateTime.now();//LocalDateTimeクラスのstaticメソッド　nowを呼ぶ
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("現在の日時: "+time.format(format));
    }

    static void printDaysLeftThisYear(){
        LocalDate today=LocalDate.now();
        LocalDate endOfYear=LocalDate.of(today.getYear(),12,31);
        long betweenNewyear=Duration.between(today.atStartOfDay(),endOfYear.atStartOfDay()).toDays();//大晦日と今日の間の日数
        System.out.println("今年はあと"+betweenNewyear+"日残っています。");
    }
    
    static void printDaysUntilBirthday(int month,int day){
        Scanner sc=new Scanner(System.in);
        LocalDate today= LocalDate.now();//今日の日付を取得する
        LocalDate birthDay=LocalDate.of(today.getYear(),month,day);//今年の何月何日
        System.out.println("誕生日の月を入力してください:");
        month=sc.nextInt();
        System.out.println("誕生日の日を入力してください:");
        day=sc.nextInt();

        if(today.isBefore(birthDay)){
            long countDownBirthday=Duration.between(today.atStartOfDay(), birthDay.atStartOfDay()).toDays();
            System.out.println("今年の誕生日まであと"+countDownBirthday+"日");
        }else if(today.isAfter(birthDay)){
            LocalDate birthDayNext =birthDay.plusYears(1);
            long countDownNextBirthday=Duration.between(today.atStartOfDay(),birthDayNext.atStartOfDay()).toDays();
            System.out.println("今年の誕生日はもう過ぎました。来年の誕生日まであと"+countDownNextBirthday+"日です。");
        }else{
            System.out.println("今日は誕生日です！おめでとうございます！");
        }
        
    }

    static void getDayOfWeek(){//日付から曜日を取得
        LocalDate today=LocalDate.now();
        String dayOfWeek=today.getDayOfWeek().toString();
        System.out.println("今日は:"+dayOfWeek+"です。");
    }

    static void countDownChristmas(){
        LocalDate today=LocalDate.now();
        LocalDate christmas=LocalDate.of(today.getYear(),12,25);
        long betweenChristmas=Duration.between(today.atStartOfDay(), christmas.atStartOfDay()).toDays();
        System.out.println("クリスマスまであと"+betweenChristmas+"日");
    }
}
