import org.junit.jupiter.api.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WorldClockCoreTest {

    private WorldClockCore clocks;

    @BeforeEach
    void init(){
        clocks = new WorldClockCore();
    }

    @Test
    @DisplayName("输入正确格式时间调整世界时钟测试")
    void EditTime(){
        clocks.editTimes("2018-05-07 10:00");
        List<ClockTime> times = clocks.getTimes();
        assertNotNull(times); // 验证时钟列表是否为空
        ClockTime bjTime = times.get(0); // 获得北京时间
        ClockTime nyTime = times.get(1); // 获得纽约时间
        ClockTime ldTime = times.get(2); // 获得伦敦时间
        ClockTime mscTime = times.get(3); // 获得莫斯科时间
        ClockTime snTime = times.get(4); // 获得悉尼时间
        // 判断世界时钟是否为调整后的时间
        // 使用assertAll测试多个断言的错误
        assertAll(
                ()->assertEquals("2018-05-07 10:00",
                        bjTime.getLocalDateTime().format(
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                ()->assertEquals("2018-05-06 21:00",
                        nyTime.getLocalDateTime().format(
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                ()->assertEquals("2018-05-07 02:00",
                        ldTime.getLocalDateTime().format(
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                ()->assertEquals("2018-05-07 06:00",
                        mscTime.getLocalDateTime().format(
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                ()->assertEquals("2018-05-07 12:00",
                        snTime.getLocalDateTime().format(
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
    }

}