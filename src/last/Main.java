package last;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Report report1 = new Report(1L, "no_punkz", 1, LocalDate.of(2021, 9, 25), "Из-за внешних факторов...");
        Report report2 = new Report(2L, "no_punkz", 2, LocalDate.of(2021, 9, 26), "Бился над компаратором...");
        Report report3 = new Report(3L, "no_punkz", 5, LocalDate.of(2021, 9, 27), "Продолжаю мучать...");
        Report report4 = new Report(4L, "sad_walther", 5, LocalDate.of(2025, 2, 18), "Потел...");

        List<Report> reports = new ArrayList<>();
        reports.add(report1);
        reports.add(report2);
        reports.add(report3);
        reports.add(report4);

        String history = Report.reportHistory(reports, "no_punkz", 2);
        System.out.println(history);
    }
}