package com.suixin.datasource.config;

import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * mybatisPlus配置
 *
 * @author STARS
 */
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = "com.suixin.**.dao")
public class MybatisPlusConfig {


    /**
     * 防止全表删改
     *
     * @return block attack inner interceptor
     */
    @Bean
    public BlockAttackInnerInterceptor blockAttackInnerInterceptor() {
        return new BlockAttackInnerInterceptor();
    }

}

