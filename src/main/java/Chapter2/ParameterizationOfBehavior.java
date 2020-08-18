package Chapter2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParameterizationOfBehavior {
    public static void main(String[] args) {
        prettyPrintAppleTask();
        filterTest();
    }

    private static void filterTest() {
        List<Apple> data = Apple.getData();
        List<Apple> greenApples = filter(data, a -> Apple.Color.GREEN.equals(a.getColor()));
        greenApples.forEach(System.out::println);
    }

    private static void prettyPrintAppleTask() {
        List<Apple> data = Apple.getData();
        prettyPrintApple(data, a -> System.out.printf("Apple color is %s, weight is %d\n", a.getColor(), a.getWeight()));
    }

    public static <T> void prettyPrintApple(List<T> inventory, Consumer<T> printer){
        inventory.forEach(a -> printer.accept(a));
    }

    public static <T> List<T> filter(List<T> data, Predicate<T> predicate){
        return data.stream()
                .filter(el -> predicate.test(el))
                .collect(Collectors.toList());
    }
}
