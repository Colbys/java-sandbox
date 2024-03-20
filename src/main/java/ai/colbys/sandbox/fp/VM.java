package ai.colbys.sandbox.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VM<T> {
    private final T value;
    private final List<Object> args;

    private VM(T value, List<Object> args) {
        this.value = value;
        this.args = args;
    }

    public static <T> VM<T> of(T obj) {
        return new VM<>(obj, new ArrayList<>());
    }

    public VM<T> arg(final Object arg) {
        args.add(arg);
        return this;
    }

    public VM<T> arg(final Object arg, final boolean cleanArgs) {
        if (cleanArgs) {
            this.args.clear();
        }
        return arg(arg);
    }

    public VM<T> args(final Object... args) {
        this.args.addAll(Arrays.asList(args));
        return this;
    }

    public VM<T> cleanArgs(final boolean cleanArgs) {
        if (cleanArgs) {
            this.args.clear();
        }
        return this;
    }

    public <R> VM<R> act(Applicator<T, R> applicator) {
        return new VM<>(applicator.apply(value), args);
    }

    public <R> VM<R> actMulti(ArgsApplicator<T, R> applicator) {
        return new VM<>(applicator.apply(value, args.toArray()), args);
    }

    public T complete() {
        return value;
    }
}
