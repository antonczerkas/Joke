package last;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Report {

    private Long id;

    private String studentUserName;

    private Integer hours;

    private LocalDate date;

    private String title;

    public Report(Long id, String studentUserName, Integer hours, LocalDate date, String title) {
        this.id = id;
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }
    public Long getId() {
        return id;
    }
    public String getStudentUserName() {
        return studentUserName;
    }
    public Integer getHours() {
        return hours;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getTitle() {
        return title;
    }

    public static String reportHistory(List<Report> reports, String studentUserName, int count){
        StringBuilder result = new StringBuilder();
        reports.stream()
                .filter(report -> Objects.equals(report.getStudentUserName(), studentUserName))
                .sorted(Comparator.comparing(Report::getDate).reversed())
                .limit(count)
                .sorted(Comparator.comparing(Report::getDate))
                .forEach(report -> {
                    result.append(report.getStudentUserName()).append("\n")
                            .append(report.getDate()).append("\n") // Добавляем дату
                            .append(report.getHours()).append("\n") // Добавляем количество часов
                            .append(report.getTitle()).append("\n") // Добавляем заголовок
                            .append("-----------------\n"); // Добавляем разделитель
                });
        return result.toString();
    }
}