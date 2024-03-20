package ai.colbys.sandbox.fp;

public class Application {

    public static void main(String[] args) {
        var initialValue = "Hello";
        var world = "world";
        var helpMe = "help me";
        var number = 123;

        var newValue = VM.of(initialValue)
            .arg(world)
            .actMulti(Application::appendString)
            .arg(helpMe, true)
            .actMulti(Application::appendString)
            .arg(number, true)
            .actMulti(Application::appendNumber)
            .act(String::toUpperCase)
            .complete();
        System.out.println(newValue);
    }

    public static String appendString(final String value, final Object... args) {
        return value + " " + args[0];
    }

    public static String appendNumber(final String value, final Object... args) {
        return String.format(value + ", %d", args[0]);
    }
}
