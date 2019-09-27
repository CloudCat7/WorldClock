import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorldClockCore {
    private List<ClockTime> times;

    public WorldClockCore() {
        this.times = new ArrayList<>();
        initTimes();
    }

    private void initTimes(){
        LocalDateTime now = LocalDateTime.now();
        editAllTimes(now);
    }

    private void editAllTimes(LocalDateTime localDateTime) {
        ClockTime bjTime = new ClockTime(localDateTime,Clock.valueOf("bj"));
        ClockTime nyTime = new ClockTime(localDateTime.minusHours(13),Clock.valueOf("ny"));
        ClockTime ldTime = new ClockTime(localDateTime.minusHours(8),Clock.valueOf("ld"));
        ClockTime mscTime = new ClockTime(localDateTime.minusHours(4),Clock.valueOf("msc"));
        ClockTime snTime = new ClockTime(localDateTime.plusHours(2),Clock.valueOf("sn"));
        times.add(bjTime);
        times.add(nyTime);
        times.add(ldTime);
        times.add(mscTime);
        times.add(snTime);
    }

    public void editTimes(String dateTime){
        LocalDateTime localDateTime = DateTimeConvert.convertStringToDateTime(dateTime);
        times.clear();
        editAllTimes(localDateTime);
    }

    public List<ClockTime> getTimes(){
        return times;
    }

}
