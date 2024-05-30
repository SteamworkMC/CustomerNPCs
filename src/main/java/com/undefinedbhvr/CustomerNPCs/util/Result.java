package com.undefinedbhvr.CustomerNPCs.util;

/**
 * A simple Result type for handling errors in a more functional way.
 * This is obviously meant to be like Rust's type.
 *
 * I like Rust - UB
 *
 * @param <T>
 * @param <E>
 */
public sealed interface Result<T, E> permits Result.Ok, Result.Err {

    record Ok<T, E>(T value) implements Result<T, E> {}

    record Err<T, E>(E error) implements Result<T, E> {}
}

