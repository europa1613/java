package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

    @Test
    public void count() throws Exception {
        long count = MockData.getPeople()
                .stream()
                .filter(person -> "female".equalsIgnoreCase(person.getGender()))
                .count();
        System.out.println(count);

    }

    @Test
    public void min() throws Exception {
        Double minPrice = MockData.getCars()
                .stream()
                //.map(Car::getPrice)
                .mapToDouble(Car::getPrice)
                //.min(Comparator.naturalOrder())
                .min()
                .getAsDouble();
        System.out.println(minPrice);

    }

    @Test
    public void max() throws Exception {
        Double maxPrice = MockData.getCars()
                .stream()
                //.map(Car::getPrice)
                .mapToDouble(Car::getPrice)
                //.max(Comparator.naturalOrder())
                .max()
                .getAsDouble();
        System.out.println(maxPrice);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
        //cars = Collections.EMPTY_LIST;
        double avg = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(-1);
        System.out.println(avg);

    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
        System.out.println(sum);
        System.out.println(bigDecimalSum);

    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
    }

}