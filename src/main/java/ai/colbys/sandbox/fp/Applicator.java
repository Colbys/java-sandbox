package ai.colbys.sandbox.fp;

@FunctionalInterface
public interface Applicator<T, R> {

    R apply(T source);
}
