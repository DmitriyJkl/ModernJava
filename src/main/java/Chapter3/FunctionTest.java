package Chapter3;

import java.util.function.DoubleFunction;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        new FunctionTest().test();
    }

    private void test() {
        Function<Integer, Integer> f = i -> ++i;
        Function<Integer, Integer> g = x -> x*2;
        Function<Integer, Integer> h = f.andThen(g);//g(f(x))
        System.out.println(h.apply(1));
        Function<Integer, Integer> c = f.compose(g);//f(g(x))
        System.out.println(c.apply(1));
        System.out.println(integrate(x -> x + 10, 3.0, 7.0));
    }

    private double integrate(DoubleFunction<Double> f, double a, double b) {
        return (f.apply(a) + f.apply(b))*(b - a)/2.0;
    }
}
