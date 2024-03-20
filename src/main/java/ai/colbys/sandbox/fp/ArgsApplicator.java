package ai.colbys.sandbox.fp;

@FunctionalInterface
public interface ArgsApplicator<T, R> {

    R apply(T source, Object... args);
}
