package models;
@FunctionalInterface
public interface TiFunction<S,T,U,R> {
    R apply(S s, T t, U u);
}
