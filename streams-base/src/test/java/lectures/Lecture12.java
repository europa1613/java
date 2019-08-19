package lectures;

import beans.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
    @Test
    public void understandingCollect() throws Exception {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(Collectors.toList());

        emails.forEach(System.out::println);

        //Collectors.toList()
        List<String> emails2 = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        () -> new ArrayList<>(),
                        (list, ele) -> list.add(ele),
                        (list1, list2) -> list1.addAll(list2)
                );

        emails2.forEach(System.out::println);

        List<String> emails3 = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );

        emails3.forEach(System.out::println);
    }
}
