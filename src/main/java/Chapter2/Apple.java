package Chapter2;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Apple {
    private Color color;
    private int weight;

    public static List<Apple> getData(){
        ArrayList<Apple> apples = new ArrayList<>();
        Apple apple1 = new Apple(Color.GREEN, 100);
        Apple apple2 = new Apple(Color.RED, 110);
        Apple apple3 = new Apple(Color.GREEN, 120);
        Apple apple4 = new Apple(Color.YELLOW, 130);
        Apple apple5 = new Apple(Color.GREEN, 140);
        Apple apple6 = new Apple(Color.RED, 140);
        Apple apple7 = new Apple(Color.YELLOW, 130);
        Apple apple8 = new Apple(Color.GREEN, 150);
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);
        apples.add(apple6);
        apples.add(apple7);
        apples.add(apple8);
        return Collections.unmodifiableList(apples);
    }

    public enum Color{
        GREEN,
        RED,
        YELLOW
    }
}
