package homework.generics;

public class MyOptional<T> {

    public MyOptional(T value) {
        this.value = value;
    }

    private final T value;

   private static final MyOptional<?> EMPTY = new MyOptional<>(null);

    static <T> MyOptional<T> of(T value) {

        if (value == null) {
            throw new InvalidParameterException();
        }

        return new MyOptional<>(value);
    }

    @SuppressWarnings("unchecked")
    static <T> MyOptional<T> ofNullable(T value) {

        if (value != null) {
            return new MyOptional<>(value);
        }

        return (MyOptional<T>) EMPTY;

//        return value == null ? (MyOptional<T>) EMPTY : new MyOptional<>(value);
    }

    public T getValue() {

        if (value == null) {
            throw new InvalidParameterException();
        }

        return value;
    }

    public boolean isPresent() {

        return value != null;
    }

    public T orElse(T other) {
        if (value == null) {
       return other;
    }
        return value;
    }
}