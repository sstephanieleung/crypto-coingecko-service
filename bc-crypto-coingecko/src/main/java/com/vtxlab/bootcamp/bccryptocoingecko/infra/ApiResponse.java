package com.vtxlab.bootcamp.bccryptocoingecko.infra;

import lombok.Getter;

@Getter
// @Builder
public class ApiResponse<T> {

    private String code;
    private String message;
    private T data;

    public ApiResponse(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>(Syscode.NORMAL_RESPONSE);
    }

    public static class Builder<T> {

        private String code;
        private String message;
        private T data;

        // Implicity have one No Argument Constructor
        public Builder(Syscode SysCode) {
            this.code = SysCode.getCode();
            this.message = SysCode.getMessage();
        }

        public Builder<T> code(String code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse<>(this);
        }

        public Builder<T> ok() {
            Syscode SysCode = Syscode.NORMAL_RESPONSE;
            this.code = SysCode.getCode();
            this.message = SysCode.getMessage();
            return this;
        }

        public Builder<T> status(Syscode SysCode) {
            this.code = SysCode.getCode();
            this.message = SysCode.getMessage();
            return this;
        }
    }
}
