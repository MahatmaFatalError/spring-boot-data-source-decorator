/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.gavlyukovskiy.boot.jdbc.decorator.metrics;

import net.ttddyy.dsproxy.support.ProxyDataSource;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for data source proxy provider metrics.
 *
 * @author Arthur Gavlyukovskiy
 * @since 1.2.2
 */
@Configuration
@ConditionalOnClass(PublicMetrics.class)
public class DecoratedDataSourceMetricsProvidersConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DecoratedDataSourcePublicMetrics decoratedDataSourcePublicMetrics() {
        return new DecoratedDataSourcePublicMetrics();
    }

    @Configuration
    @ConditionalOnClass(ProxyDataSource.class)
    class ProxyDataSourceMetricsProviderConfiguration {

        @Bean
        public ProxyDataSourceMetricsProvider proxyDataSourceMetricsProvider() {
            return new ProxyDataSourceMetricsProvider();
        }
    }
}
