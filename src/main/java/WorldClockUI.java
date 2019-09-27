import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 功能：提供系统与用户交互的一系列菜单选项
 **/
public class WorldClockUI {

    private static WorldClockCore clocks;

    public static void main(String[] args) throws Throwable {
        clocks = new WorldClockCore();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("        码 农 酒 店 欢 迎 您        ");
        System.out.println("----------------------------------");

        String lastOption = "";
        while(!lastOption.equalsIgnoreCase( "q")){
            lastOption = displayMenu(scanner);
        }
        System.out.println("\n.......BYE.......");

    }

    public static String displayMenu(Scanner scanner) throws Throwable {
        ClockTime mainTime = clocks.getTimes().get(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(String.format("\n【 现在是%s时间 %s 】\n",
                mainTime.getClock().getName(), formatter.format(mainTime.getLocalDateTime())));
        System.out.println("您可输入：");
        System.out.println("[1] 查看世界时钟");
        System.out.println("[2] 调整世界时钟");
        System.out.println("[Q] 退出系统");
        System.out.println("您的输入是：");

        String option = scanner.next();
        switch (option){
            case "1":
                performAllEntry();
                return option;
            case "2":
                performEditEntry(scanner);
                return option;
            case "q":
            case "Q":
                return option;
            default:
                System.out.println("【您的输入选项无效，请重新输入】");
                return option;

        }

    }

    private static void performAllEntry() throws Throwable{
        System.out.println("\n\n世界时钟的时间如下：");
        for(ClockTime ct : clocks.getTimes()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String time = formatter.format(ct.getLocalDateTime());
            System.out.println(String.format("%s\t\t%s", ct.getClock().getName(),time));
        }

        System.out.println(".......请按任意键继续.......");
        System.in.read();
        System.out.println("\n");
    }

    private static void performEditEntry(Scanner scanner){
        scanner.nextLine();
        System.out.println("\n请输入正确的时间（仅北京时间）（yyyy-MM-dd HH:mm）");
        String when = scanner.nextLine();
        clocks.editTimes(when);
        System.out.println("调整成功！\n");
    }
}