package com.alibaba.cloud.examples.configs;

import io.github.mweirauch.micrometer.jvm.extras.ProcessMemoryMetrics;
import io.github.mweirauch.micrometer.jvm.extras.ProcessThreadMetrics;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 添加自定义标签, 适配监控面板
 *
 * @author JY
 */
@Configuration
public class PrometheusSupport {
    /*
     * 打标签
     * */
    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(
            @Value("${spring.application.name}") String applicationName) {
        return (registry) -> registry.config().commonTags("application", applicationName);
    }

    /* 拓展JVM监控面板依赖  面板ID=4701 */
    @Bean
    public MeterBinder processMemoryMetrics() {
        return new ProcessMemoryMetrics();
    }

    /* 普罗米修斯JVM监控面板依赖 ID=4701 */
    @Bean
    public MeterBinder processThreadMetrics() {
        return new ProcessThreadMetrics();
    }


}
