import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //текст, наверное, формальность, так что возьмем его из описания function
        String inputString = "Returns a composed function that first applies this function to its input, " +
                "and then applies the after function to the result. If evaluation of either function throws " +
                "an exception, it is relayed to the caller of the composed function";
        /*
        Function<String, String[]> dictionaryBuffer = d -> Arrays.stream(d.toLowerCase(Locale.ROOT).split(" ")).distinct().sorted().toArray(String[]::new);

        //это было жестко, но результат выглядит как магия)

        String[] dictionary = dictionaryBuffer.apply(inputString);
        for (String s : dictionary) {
            System.out.println(s);
        }
        */
        //хотя можно и массив заменить

        Function<String, List<String>> dictionaryBuffer = d -> Arrays.stream(d.toLowerCase(Locale.ROOT).split(" "))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        List<String> dictionary = dictionaryBuffer.apply(inputString);
        dictionary.forEach(System.out::println);
    }
}