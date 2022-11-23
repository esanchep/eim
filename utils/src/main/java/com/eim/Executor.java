/*
 * Copyright (c) Giesecke+Devrient Mobile Security GmbH 2022-2022
 */
package com.eim;

@FunctionalInterface
public interface Executor<T> extends Runnable {
    void execute() throws Exception;
}
