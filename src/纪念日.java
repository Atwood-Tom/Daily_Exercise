import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 纪念日 {
    /*
    * 2020 年 7 月 1 日是中国共产党成立 99 周年纪念日。
      中国共产党成立于 1921 年 7 月 23 日。
      请问从 1921 年 7 月 23 日中午 12 时到 2020 年 7 月 1 日中午 12 时一共包
      含多少分钟？
      * */
    public static void main(String[] args) throws ParseException {
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1=df.parse("1921-07-23 12:00:00");
        Date d2=df.parse("2020-07-01 12:00:00");
        System.out.println((d2.getTime()-d1.getTime())/1000/60);
    }
}
