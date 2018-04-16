package drewhamilton.limber;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class Limber {

    private static LoggingClient client;

    /**
     * Initialize Limber with a logging {@link LoggingClient}.
     *
     * Limber currently only supports 1 {@link LoggingClient} at a time.
     */
    public static void initialize(LoggingClient client) {
        Limber.client = client;
    }

    /** Log a verbose message with optional format args. */
    public static void v(@NonNls String message, Object... args) {
        client.v(message, args);
    }

    /** Log a verbose exception and a message with optional format args. */
    public static void v(Throwable t, @NonNls String message, Object... args) {
        client.v(t, message, args);
    }

    /** Log a verbose exception. */
    public static void v(Throwable t) {
        client.v(t);
    }

    /** Log a debug message with optional format args. */
    public static void d(@NonNls String message, Object... args) {
        client.d(message, args);
    }

    /** Log a debug exception and a message with optional format args. */
    public static void d(Throwable t, @NonNls String message, Object... args) {
        client.d(t, message, args);
    }

    /** Log a debug exception. */
    public static void d(Throwable t) {
        client.d(t);
    }

    /** Log an info message with optional format args. */
    public static void i(@NonNls String message, Object... args) {
        client.i(message, args);
    }

    /** Log an info exception and a message with optional format args. */
    public static void i(Throwable t, @NonNls String message, Object... args) {
        client.i(t, message, args);
    }

    /** Log an info exception. */
    public static void i(Throwable t) {
        client.i(t);
    }

    /** Log a warning message with optional format args. */
    public static void w(@NonNls String message, Object... args) {
        client.w(message, args);
    }

    /** Log a warning exception and a message with optional format args. */
    public static void w(Throwable t, @NonNls String message, Object... args) {
        client.w(t, message, args);
    }

    /** Log a warning exception. */
    public static void w(Throwable t) {
        client.w(t);
    }

    /** Log an error message with optional format args. */
    public static void e(@NonNls String message, Object... args) {
        client.e(message, args);
    }

    /** Log an error exception and a message with optional format args. */
    public static void e(Throwable t, @NonNls String message, Object... args) {
        client.e(t, message, args);
    }

    /** Log an error exception. */
    public static void e(Throwable t) {
        client.e(t);
    }

    /** Log an assert message with optional format args. */
    public static void wtf(@NonNls String message, Object... args) {
        client.wtf(message, args);
    }

    /** Log an assert exception and a message with optional format args. */
    public static void wtf(Throwable t, @NonNls String message, Object... args) {
        client.wtf(t, message, args);
    }

    /** Log an assert exception. */
    public static void wtf(Throwable t) {
        client.wtf(t);
    }

    /** Log at {@code priority} a message with optional format args. */
    public static void log(int priority, @NonNls String message, Object... args) {
        client.log(priority, message, args);
    }

    /** Log at {@code priority} an exception and a message with optional format args. */
    public static void log(int priority, Throwable t, @NonNls String message, Object... args) {
        client.log(priority, t, message, args);
    }

    /** Log at {@code priority} an exception. */
    public static void log(int priority, Throwable t) {
        client.log(priority, t);
    }

    /** Set a one-time tag for use on the next logging call. */
    @NotNull
    public static LoggingClient tag(String tag) {
        return client.tag(tag);
    }

    private Limber() {
        throw new AssertionError("Can't instantiate Limber");
    }
}
