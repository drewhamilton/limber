package drewhamilton.limber.timber;

import org.jetbrains.annotations.NotNull;

import drewhamilton.limber.LoggingClient;
import timber.log.Timber;

class TreeClient implements LoggingClient {

    static TreeClient fromTimberAsTree() {
        return new TreeClient(Timber.asTree());
    }

    private Timber.Tree backingTree;

    private TreeClient(Timber.Tree backingTree) {
        this.backingTree = backingTree;
    }

    @Override
    public void v(String message, Object... args) {
        backingTree.v(message, args);
    }

    @Override
    public void v(Throwable t, String message, Object... args) {
        backingTree.v(t, message, args);
    }

    @Override
    public void v(Throwable t) {
        backingTree.v(t);
    }

    @Override
    public void d(String message, Object... args) {
        backingTree.d(message, args);
    }

    @Override
    public void d(Throwable t, String message, Object... args) {
        backingTree.d(t, message, args);
    }

    @Override
    public void d(Throwable t) {
        backingTree.d(t);
    }

    @Override
    public void i(String message, Object... args) {
        backingTree.i(message, args);
    }

    @Override
    public void i(Throwable t, String message, Object... args) {
        backingTree.i(t, message, args);
    }

    @Override
    public void i(Throwable t) {
        backingTree.i(t);
    }

    @Override
    public void w(String message, Object... args) {
        backingTree.w(message, args);
    }

    @Override
    public void w(Throwable t, String message, Object... args) {
        backingTree.w(t, message, args);
    }

    @Override
    public void w(Throwable t) {
        backingTree.w(t);
    }

    @Override
    public void e(String message, Object... args) {
        backingTree.e(message, args);
    }

    @Override
    public void e(Throwable t, String message, Object... args) {
        backingTree.e(t, message, args);
    }

    @Override
    public void e(Throwable t) {
        backingTree.e(t);
    }

    @Override
    public void wtf(String message, Object... args) {
        backingTree.wtf(message, args);
    }

    @Override
    public void wtf(Throwable t, String message, Object... args) {
        backingTree.wtf(t, message, args);
    }

    @Override
    public void wtf(Throwable t) {
        backingTree.wtf(t);
    }

    @Override
    public void log(int priority, String message, Object... args) {
        backingTree.log(priority, message, args);
    }

    @Override
    public void log(int priority, Throwable t, String message, Object... args) {
        backingTree.log(priority, t, message, args);
    }

    @Override
    public void log(int priority, Throwable t) {
        backingTree.log(priority, t);
    }

    @Override
    public @NotNull LoggingClient tag(String tag) {
        throw new UnsupportedOperationException("Timber supports the explicit tag() method, but individual Trees do not");
    }
}
