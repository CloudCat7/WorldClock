import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorldClockCore {
    private List<ClockTime> times;
    private LocalDateTime oriTime;

    public WorldClockCore() {
        this.times = new ArrayList<>();
        initTimes();
    }

    private void initTimes(){
        LocalDateTime now = LocalDateTime.now();
        oriTime = now;
        editAllTimes(now);
    }

    public void editTimes(String dateTime){
        oriTime = LocalDateTime.now();
        LocalDateTime localDateTime = DateTimeConvert.convertStringToDateTime(dateTime);
        times.clear();
        editAllTimes(localDateTime);
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

    public List<ClockTime> getTimes(){
        return times;
    }

    public void updateTimes(){
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(oriTime,now);
        oriTime = now;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String curTime = formatter.format(getTimes().get(0).getLocalDateTime().plusNanos(duration.toNanos()));
        editTimes(curTime);
    }

}
