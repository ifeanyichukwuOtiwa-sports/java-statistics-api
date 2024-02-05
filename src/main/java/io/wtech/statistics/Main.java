package io.wtech.statistics;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wtech.statistics.model.Employee;
import io.wtech.statistics.util.Parser;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger("io.wtech.statistic.MainApplication");

    public static void main(String[] args) {
        final ObjectMapper mapper = new ObjectMapper();
        final Parser parser = new Parser(mapper);

        final String testDataUrl = "https://api.slingacademy.com/v1/sample-data/files/employees.json";

        final List<Employee> employees = Optional.ofNullable(parser.parse(testDataUrl)).orElse(Collections.emptyList());


        employees.stream()
                .mapToInt(Employee::getAge)
                .average()
                .ifPresentOrElse(averageAge -> log.log(Level.INFO, "\u001B[32m Average age: %s \u001B[0m".formatted(averageAge)), () -> log.log(Level.SEVERE, String.format("%s", Double.NaN)));

        final int ageSum = employees.stream()
                .mapToInt(Employee::getAge)
                .sum();
        log.log(Level.INFO, "\u001B[32mSum of all ages: %s\u001B[0m".formatted(ageSum));

        final long ageCount = employees.stream()
                .mapToInt(Employee::getAge)
                .count();
        log.log(Level.INFO, "\u001B[32mCount of all ages: %s\u001B[0m".formatted(ageCount));

        employees.stream()
                .mapToInt(Employee::getAge)
                .max()
                .ifPresentOrElse(max -> log.log(Level.INFO, "\u001B[32mMax age: %s\u001B[0m".formatted(max)), () -> log.log(Level.WARNING, "0"));

        employees.stream()
                .mapToInt(Employee::getAge)
                .min()
                .ifPresentOrElse(min -> log.log(Level.INFO, "\u001B[32mMin age: %s\u001B[0m".formatted(min)), () -> log.log(Level.WARNING, "0"));

        final IntSummaryStatistics intSummaryStatistics = employees.stream()
                .mapToInt(Employee::getAge)
                .summaryStatistics();

        log.log(Level.INFO, "\u001B[32mStatistics of all ages: %s\u001B[0m".formatted(intSummaryStatistics));

    }
}