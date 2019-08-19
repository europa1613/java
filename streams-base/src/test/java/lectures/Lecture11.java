package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String reduce = names.stream()
            .reduce("", (a, b) -> String.join(",", a, b));
    System.out.println(reduce);

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String collect = names.stream()
            .collect(Collectors.joining());
    System.out.println(collect);//annajohnmarcoshelenayasmin

    String collect2 = names.stream()
            .collect(Collectors.joining(","));
    System.out.println(collect2);//anna,john,marcos,helena,yasmin

    String collect3 = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.joining("|"));
    System.out.println(collect3);//ANNA|JOHN|MARCOS|HELENA|YASMIN

  }
}
