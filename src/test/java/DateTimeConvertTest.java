import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateTimeConvertTest {

    @Test
    @DisplayName("转换符合格式要求的日期")
    void convertNormalDateString(){
        LocalDateTime result = DateTimeConvert.convertStringToDateTime("2019-09-29 20:00:00");
        assertEquals(LocalDateTime.of(2019,9,29,20,00,00),result);
    }

    @Test
    @DisplayName("转换无效格式的日期，系统抛出异常")
    void convertInvalidDateString(){
        Throwable exception = assertThrows(RuntimeException.class,
                ()->DateTimeConvert.convertStringToDateTime("2019-9-29 20:00:00"));
        assertEquals("输入调整时间格式不正确：[2019-9-29 20:00:00]，输入时间格式为[yyyy-MM-dd HH:mm:ss]",
                exception.getMessage());
    }

}
