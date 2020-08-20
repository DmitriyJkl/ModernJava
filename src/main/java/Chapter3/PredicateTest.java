package Chapter3;

import Chapter2.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        new PredicateTest().test();
    }

    private void test() {
        Predicate<Apple> redApple = a -> a.getColor().equals(Apple.Color.RED);
        Apple redapple = new Apple(Apple.Color.RED, 100);
        System.out.println(redApple.test(redapple));
        System.out.println(redApple.negate().test(redapple));
        Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() >= 140);
        Predicate<Apple> redAndHeavyAppleOrGreen = redAndHeavyApple.or(a -> Apple.Color.GREEN.equals(a.getColor()));

        List<Apple> data = Apple.getData();
        System.out.println("--redAndHeavyApple predicate test--");
        data.stream().filter(redAndHeavyApple).forEach(System.out::println);
        System.out.println("--redAndHeavyAppleOrGreen predicate test--");
        data.stream().filter(redAndHeavyAppleOrGreen).forEach(System.out::println);
    }
}
