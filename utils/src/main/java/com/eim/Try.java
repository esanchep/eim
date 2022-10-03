package com.eim;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Try<T> {

    private final Runnable<T> runnable;
    private final RuntimeException exception;

    public static <R> TyrBuilder<R> execute(final Supplier<R> supplier) {
        final TyrBuilder<R> tyrBuilder = new TyrBuilder<>();
        return tyrBuilder.runnable(supplier);
    }

    protected T run() {
        try {
            return runnable.run();
        } catch (final Exception exception) {
            log.error(exception.getMessage());
            if (null != this.exception) {
                throw this.exception;
            }
            return null;
        }
    }

    public static class TyrBuilder<R> {
        private Runnable<R> runnable;
        private RuntimeException exception;

        public TyrBuilder<R> runnable(final Runnable<R> runnable) {
            this.runnable = runnable;
            return this;
        }

        public TyrBuilder<R> orThrow(final RuntimeException exception) {
            this.exception = exception;
            return this;
        }

        public R run() {
            return new Try<>(runnable, exception).run();
        }
    }

}
