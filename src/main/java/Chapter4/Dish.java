package Chapter4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString(onlyExplicitlyIncluded = true)
public final class Dish {
    @ToString.Include
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type{
        MEAT, FISH, OTHER
    }
}
