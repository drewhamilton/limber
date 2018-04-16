package drewhamilton.limber;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public interface LoggingClient {

    /** Log a verbose message with optional format args. */
    void v(@NonNls String message, Object... args);

    /** Log a verbose exception and a message with optional format args. */
    void v(Throwable t, @NonNls String message, Object... args);

    /** Log a verbose exception. */
    void v(Throwable t);

    /** Log a debug message with optional format args. */
    void d(@NonNls String message, Object... args);

    /** Log a debug exception and a message with optional format args. */
    void d(Throwable t, @NonNls String message, Object... args);

    /** Log a debug exception. */
    void d(Throwable t);

    /** Log an info message with optional format args. */
    void i(@NonNls String message, Object... args);

    /** Log an info exception and a message with optional format args. */
    void i(Throwable t, @NonNls String message, Object... args);

    /** Log an info exception. */
    void i(Throwable t);

    /** Log a warning message with optional format args. */
    void w(@NonNls String message, Object... args);

    /** Log a warning exception and a message with optional format args. */
    void w(Throwable t, @NonNls String message, Object... args);

    /** Log a warning exception. */
    void w(Throwable t);

    /** Log an error message with optional format args. */
    void e(@NonNls String message, Object... args);

    /** Log an error exception and a message with optional format args. */
    void e(Throwable t, @NonNls String message, Object... args);

    /** Log an error exception. */
    void e(Throwable t);

    /** Log an assert message with optional format args. */
    void wtf(@NonNls String message, Object... args);

    /** Log an assert exception and a message with optional format args. */
    void wtf(Throwable t, @NonNls String message, Object... args);

    /** Log an assert exception. */
    void wtf(Throwable t);

    /** Log at {@code priority} a message with optional format args. */
    void log(int priority, @NonNls String message, Object... args);

    /** Log at {@code priority} an exception and a message with optional format args. */
    void log(int priority, Throwable t, @NonNls String message, Object... args);

    /** Log at {@code priority} an exception. */
    void log(int priority, Throwable t);

    /** Set a one-time tag for use on the next logging call. */
    @NotNull
    LoggingClient tag(String tag);
}
