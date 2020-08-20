package Chapter3;

import Chapter2.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        new ComparatorTest().test();
    }

    private void test() {
        List<Apple> data = new ArrayList<>(Apple.getData());
        Comparator<Apple> comp = Comparator.comparing(Apple::getWeight);
        data.sort(comp
                .reversed()
                .thenComparing(Apple::getColor));
        data.forEach(System.out::println);
    }
}
