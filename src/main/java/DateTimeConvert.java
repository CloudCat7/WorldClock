import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConvert {
    public static LocalDateTime convertStringToDateTime(String dateTimeString){
        LocalDateTime localDateTime;
        LocalDate today;
        try{
           localDateTime = LocalDateTime.parse(dateTimeString.toUpperCase(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Throwable t){
            throw new RuntimeException("输入调整时间格式不正确：["+
                    dateTimeString.toUpperCase() + "]，输入时间格式为[yyyy-MM-dd HH:mm]");
        }
        return localDateTime;
    }
}
