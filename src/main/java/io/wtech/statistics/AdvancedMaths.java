package io.wtech.statistics;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wtech.statistics.model.Employee;
import io.wtech.statistics.util.Parser;
import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AdvancedMaths {
    public static void main(String[] args) {
        // Descriptive Statistics
        // ========================

        final ObjectMapper mapper = new ObjectMapper();
        final Parser parser = new Parser(mapper);

        final String testDataUrl = "https://api.slingacademy.com/v1/sample-data/files/employees.json";

        final List<Employee> employees = Optional.ofNullable(parser.parse(testDataUrl)).orElse(Collections.emptyList());

        final int[] ageArray = employees.stream()
                .mapToInt(Employee::getAge)
                .toArray();

        final DescriptiveStatistics statistics = new DescriptiveStatistics();
        employees.forEach(e -> statistics.addValue(e.getSalary().intValue()));

        System.out.println("Statistics: " + statistics);

        final Frequency frequency = new Frequency();
        employees.forEach(e -> frequency.addValue(e.getAge()));

        Arrays.stream(ageArray)
                .distinct()
                .sorted()
                .forEachOrdered(e -> System.out.println( e + " : " + frequency.getCount(e)+ ", " + frequency.getPct(e)));


        final PearsonsCorrelation pcAgeSalary = new PearsonsCorrelation();

        final double correlation = pcAgeSalary.correlation(
                employees.stream().mapToDouble(Employee::getAge).toArray(),
                employees.stream().mapToDouble(i -> i.getSalary().doubleValue()).toArray()
        );

        System.out.println("Correlation: " + correlation);
    }
}
