package org.lavenderx.springboot.grpc.autoconfigure;

import org.lavenderx.springboot.grpc.GRpcServerBuilderConfigurer;
import org.lavenderx.springboot.grpc.GRpcServerRunner;
import org.lavenderx.springboot.grpc.GRpcService;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GRpcServerProperties.class)
@AutoConfigureOrder
public class GRpcAutoConfiguration {

    @Bean
    @ConditionalOnBean(annotation = GRpcService.class)
    public GRpcServerRunner grpcServerRunner(GRpcServerBuilderConfigurer configurer) {
        return new GRpcServerRunner(configurer);
    }

    @Bean
    @ConditionalOnMissingBean(GRpcServerBuilderConfigurer.class)
    public GRpcServerBuilderConfigurer serverBuilderConfigurer() {
        return new GRpcServerBuilderConfigurer();
    }
}
