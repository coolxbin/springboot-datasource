package org.mallen.test.spring.boot.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

/**
 * 通过Spring Boot的AutoConfiguration创建datasource，配置类为{@link org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration}
 * 其内部使用的其实也是DataSourceProperties来创建，只是在@Bean方法上添加了注解：@ConfigurationProperties(prefix = "spring.datasource.hikari")，
 * 以便通过spring.datasource.hikari来设置属性
 *
 * @author mallen
 * @date 4/18/19
 */
@SpringBootApplication
public class SpringBootAutoConfigDataSourceTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootAutoConfigDataSourceTest.class, args);
        DataSource ds = ctx.getBean(DataSource.class);
        SqlUtil.execute(ds);
    }
}
