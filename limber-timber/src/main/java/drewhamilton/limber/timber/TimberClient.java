package drewhamilton.limber.timber;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import drewhamilton.limber.LoggingClient;
import timber.log.Timber;

public class TimberClient implements LoggingClient {

    /**
     * A view into Timber's planted trees as a tree itself. This can be used for injecting a logger
     * instance rather than using static methods or to facilitate testing.
     */
    @NotNull
    public Timber.Tree asTree() {
        return Timber.asTree();
    }

    /** Add a new logging tree. */
    public void plant(@NotNull Timber.Tree tree) {
        Timber.plant(tree);
    }

    /** Adds new logging trees. */
    public static void plant(@NotNull Timber.Tree... trees) {
        Timber.plant(trees);
    }

    /** Remove a planted tree. */
    public static void uproot(@NotNull Timber.Tree tree) {
        Timber.uproot(tree);
    }

    /** Remove all planted trees. */
    public static void uprootAll() {
        Timber.uprootAll();
    }

    /** Return a copy of all planted {@link Timber.Tree trees}. */
    @NotNull
    public static List<Timber.Tree> forest() {
        return Timber.forest();
    }

    public static int treeCount() {
        return Timber.treeCount();
    }

    //region LoggingClient implementation
    @Override
    public void v(String message, Object... args) {
        Timber.v(message, args);
    }

    @Override
    public void v(Throwable t, String message, Object... args) {
        Timber.v(t, message, args);
    }

    @Override
    public void v(Throwable t) {
        Timber.v(t);
    }

    @Override
    public void d(String message, Object... args) {
        Timber.d(message, args);
    }

    @Override
    public void d(Throwable t, String message, Object... args) {
        Timber.d(t, message, args);
    }

    @Override
    public void d(Throwable t) {
        Timber.d(t);
    }

    @Override
    public void i(String message, Object... args) {
        Timber.i(message, args);
    }

    @Override
    public void i(Throwable t, String message, Object... args) {
        Timber.i(t, message, args);
    }

    @Override
    public void i(Throwable t) {
        Timber.i(t);
    }

    @Override
    public void w(String message, Object... args) {
        Timber.w(message, args);
    }

    @Override
    public void w(Throwable t, String message, Object... args) {
        Timber.w(t, message, args);
    }

    @Override
    public void w(Throwable t) {
        Timber.w(t);
    }

    @Override
    public void e(String message, Object... args) {
        Timber.e(message, args);
    }

    @Override
    public void e(Throwable t, String message, Object... args) {
        Timber.e(t, message, args);
    }

    @Override
    public void e(Throwable t) {
        Timber.e(t);
    }

    @Override
    public void wtf(String message, Object... args) {
        Timber.wtf(message, args);
    }

    @Override
    public void wtf(Throwable t, String message, Object... args) {
        Timber.wtf(t, message, args);
    }

    @Override
    public void wtf(Throwable t) {
        Timber.wtf(t);
    }

    @Override
    public void log(int priority, String message, Object... args) {
        Timber.log(priority, message, args);
    }

    @Override
    public void log(int priority, Throwable t, String message, Object... args) {
        Timber.log(priority, t, message, args);
    }

    @Override
    public void log(int priority, Throwable t) {
        Timber.log(priority, t);
    }

    @Override
    public @NotNull LoggingClient tag(String tag) {
        Timber.tag(tag);
        return TreeClient.fromTimberAsTree();
    }
    //endregion
}
