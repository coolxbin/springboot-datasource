package org.mallen.test.spring.boot.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 通过DataSourceBuilder创建datasource，这种方式只能设置简单的几个参数（url/username/password）
 *
 * @author mallen
 * @date 4/17/19
 */
// 如果需要运行，请打开该注释
//@SpringBootApplication
public class DataSourceBuilderTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DataSourceBuilderTest.class, args);
        DataSource ds = ctx.getBean(DataSource.class);
        SqlUtil.execute(ds);
    }



    @Bean
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
