package timber.log;

import android.os.Build;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A {@link Timber.Tree Tree} for debug builds. Automatically infers the tag from the calling class.
 *
 * Replaces Timber.DebugTree so tag can be inferred from the calling class after Timber is wrapped
 * by Limber.
 *
 * Copied from <a href="http://google.com">https://github.com/JakeWharton/timber/pull/314</a>; can
 * be changed to just extend {@link Timber.DebugTree} if that PR is accepted.
 */
public class LimberDebugTree extends Timber.Tree {

    private static final int MAX_LOG_LENGTH = 4000;
    private static final int MAX_TAG_LENGTH = 23;
    private static final int TIMBER_DEFAULT_CALL_STACK_INDEX = 5;
    private static final int LIMBER_ADDITION_TO_CALL_STACK_INDEX = 2;
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

    /**
     * Extract the tag which should be used for the message from the {@code element}. By default
     * this will use the class name without any anonymous class suffixes (e.g., {@code Foo$1}
     * becomes {@code Foo}).
     * <p>
     * Note: This will not be called if a manual tag was specified.
     */
    @Nullable
    protected String createStackElementTag(@NotNull StackTraceElement element) {
        String tag = element.getClassName();
        Matcher m = ANONYMOUS_CLASS.matcher(tag);
        if (m.find()) {
            tag = m.replaceAll("");
        }
        tag = tag.substring(tag.lastIndexOf('.') + 1);
        // Tag length limit was removed in API 24.
        if (tag.length() <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return tag;
        }
        return tag.substring(0, MAX_TAG_LENGTH);
    }

    /**
     * Define how deep the desired tag will be in the call stack. 5 by default, but may need to
     * be overridden if you're wrapping Timber or something.
     */
    protected int getTagDepth() {
        return TIMBER_DEFAULT_CALL_STACK_INDEX + LIMBER_ADDITION_TO_CALL_STACK_INDEX;
    }

    @Override final String getTag() {
        String tag = super.getTag();
        if (tag != null) {
            return tag;
        }

        // DO NOT switch this to Thread.getCurrentThread().getStackTrace(). The test will pass
        // because Robolectric runs them on the JVM but on Android the elements are different.
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        final int callStackIndex = getTagDepth();
        if (stackTrace.length <= callStackIndex) {
            throw new IllegalStateException(
                    "Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }
        return createStackElementTag(stackTrace[callStackIndex]);
    }

    /**
     * Break up {@code message} into maximum-length chunks (if needed) and send to either
     * {@link Log#println(int, String, String) Log.println()} or
     * {@link Log#wtf(String, String) Log.wtf()} for logging.
     *
     * {@inheritDoc}
     */
    @Override protected void log(int priority, String tag, @NotNull String message, Throwable t) {
        if (message.length() < MAX_LOG_LENGTH) {
            if (priority == Log.ASSERT) {
                Log.wtf(tag, message);
            } else {
                Log.println(priority, tag, message);
            }
            return;
        }

        // Split by line, then ensure each line can fit into Log's maximum length.
        for (int i = 0, length = message.length(); i < length; i++) {
            int newline = message.indexOf('\n', i);
            newline = newline != -1 ? newline : length;
            do {
                int end = Math.min(newline, i + MAX_LOG_LENGTH);
                String part = message.substring(i, end);
                if (priority == Log.ASSERT) {
                    Log.wtf(tag, part);
                } else {
                    Log.println(priority, tag, part);
                }
                i = end;
            } while (i < newline);
        }
    }
}
