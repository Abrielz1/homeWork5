package homework.generics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@EqualsAndHashCode
public class MyOptional<T> {

   private  T value;

    static <T> MyOptional of(T value) {

        if (value == null) {
            throw new InvalidParameterException();
        }
        return ofNullable(value);
    }

    static <T> MyOptional ofNullable(T value) {

        if (value != null) {
            return new MyOptional<T>(value);
        }

        return new MyOptional();
    }

    public  <T> T getValue() {
        return (T) value;
    }

    public boolean isPresent() {

        return this.getValue() != null;
    }

    public  <T> T orElse(T other) {
        if (MyOptional.of(value) == null) {
       return other;
    }
        return this.getValue();
    }
}
//public class MyOptional {
//    static MyOptional of(Object value) {
//        return new MyOptional();
//    }
//
//    static MyOptional ofNullable(Object value) {
//        return new MyOptional();
//    }
//
//    public Object get() {
//        return new Object();
//    }
//
//    public boolean isPresent() {
//        return true;
//    }
//
//    public Object orElse(Object other) {
//        return other;
//    }