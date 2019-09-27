import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClockTest {

    Clock clocks;

    @Test
    void getName(){
        assertAll(
                ()->assertEquals("北京",Clock.valueOf("bj").getName()),
                ()->assertEquals("纽约",Clock.valueOf("ny").getName()),
                ()->assertEquals("伦敦",Clock.valueOf("ld").getName()),
                ()->assertEquals("莫斯科",Clock.valueOf("msc").getName()),
                ()->assertEquals("悉尼",Clock.valueOf("sn").getName()));
    }

}
