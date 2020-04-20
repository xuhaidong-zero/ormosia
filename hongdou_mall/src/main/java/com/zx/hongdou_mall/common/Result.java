package com.zx.hongdou_mall.common;

import lombok.Data;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Data
public class Result<T> {
    private final int status;
    private final String message;
    private final T data;

    public boolean successful() {
        return this.status / 100 == 2;
    }

    private static final Result<Object> SUCCESS = new Result<>(200, "操作成功", null);
    private static final Result<Object> ERROR = new Result<>(201, "查询失败", null);
    private static final Result<CollectionData<Object>> EMPTY_LIST_SUCCESS = new Result<>(200, "操作成功", new CollectionData<>(Collections.emptyList(), 0));
    private static final Result<Object> AUTHENTICATION_ERROR = new Result<>(401, "请登录", null);
    private static final Result<Object> AUTHORIZATION_ERROR = new Result<>(403, "访问被拒绝", null);
    private static final Result<Object> CONCURRENCY_ERROR = new Result<>(409, "并发请求", null);

    @SuppressWarnings("unchecked")
    public static <T> Result<T> success() {
        return (Result<T>) SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public static <T> Result<T> error() {
        return (Result<T>) ERROR;
    }

    @SuppressWarnings("unchecked")
    public static <T> Result<T> emptyListSuccess() {
        return (Result<T>) EMPTY_LIST_SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public static <T> Result<T> authenticationError() {
        return (Result<T>) AUTHENTICATION_ERROR;
    }

    @SuppressWarnings("unchecked")
    public static <T> Result<T> authorizationError() {
        return (Result<T>) AUTHORIZATION_ERROR;
    }

    @SuppressWarnings("unchecked")
    public static <T> Result<T> concurrencyError() {
        return (Result<T>) CONCURRENCY_ERROR;
    }

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    public static <T> Result<Map<String, T>> singletonSuccess(String key, T value) {
        return new Result<>(200, "操作成功", Collections.singletonMap(key, value));
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }

    public static <T> Result<CollectionData<T>> success(Collection<T> items, long totalItems) {
        return new Result<>(200, "操作成功", new CollectionData<>(items, totalItems));
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(400, message, null);
    }

    public static <T> Result<T> authenticationError(String message) {
        return new Result<>(401, message, null);
    }

    //并发
    public static <T> Result<T> concurrencyError(String message) {
        return new Result<>(409, message, null);
    }

    @Getter
    public static class CollectionData<T> {
        private final Collection<T> items;
        private final long totalItems;

        private CollectionData(Collection<T> items, long totalItems) {
            this.items = items;
            this.totalItems = totalItems;
        }
    }

}
