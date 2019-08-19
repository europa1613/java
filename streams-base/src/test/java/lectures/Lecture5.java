package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

    final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();

        List<Car> carsFiltered = cars.stream()
                .filter(carPredicate)
                .collect(Collectors.toList());
        System.out.println(carsFiltered.size());

    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> people = MockData.getPeople();

        List<PersonDTO> dtos = people.stream()
                .map(person -> {
                    PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
                    return dto;
                })
                .collect(Collectors.toList());
        //dtos.forEach(System.out::println);
        System.out.println(dtos.size());

        List<PersonDTO> dtos2 = people.stream()
                .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                .collect(Collectors.toList());
        //dtos2.forEach(System.out::println);
        System.out.println(dtos2.size());

        List<PersonDTO> dtos3 = people.stream()
                .map(PersonDTO::map)
                .collect(Collectors.toList());
        //dtos2.forEach(System.out::println);
        System.out.println(dtos3.size());

        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
        List<PersonDTO> dtos4 = people.stream()
                .map(personPersonDTOFunction)
                .collect(Collectors.toList());
        //dtos2.forEach(System.out::println);
        System.out.println(dtos4.size());

    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        double average = MockData.getCars().stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(-1);
        System.out.println(average);

    }

    @Test
    public void test() throws Exception {

    }
}



