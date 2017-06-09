package org.lavenderx.springboot.grpc;

import io.grpc.ServerInterceptor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface GRpcService {

    Class<? extends ServerInterceptor>[] interceptors() default {};

    boolean applyGlobalInterceptors() default true;
}
