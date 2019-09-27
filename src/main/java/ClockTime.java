import java.time.LocalDateTime;

public class ClockTime {
    private LocalDateTime localDateTime;
    private Clock clock;

    public ClockTime(LocalDateTime localDateTime, Clock clock) {
        this.localDateTime = localDateTime;
        this.clock = clock;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Clock getClock() {
        return clock;
    }

}
