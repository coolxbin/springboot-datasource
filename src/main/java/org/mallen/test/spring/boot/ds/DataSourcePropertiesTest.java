package org.mallen.test.spring.boot.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 通过DataSourceProperties创建datasource，这种方式与DataSourceBuilder类似，只不过数据源的属性可以自动获取而已（通过spring.datasource.*指定）。
 * 同样，这种方式也只能设置简单的几个参数（url/username/password）。
 *
 * @author mallen
 * @date 4/17/19
 */
// 如果需要运行，请打开该注释
//@SpringBootApplication
public class DataSourcePropertiesTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DataSourcePropertiesTest.class, args);
        DataSource ds = ctx.getBean(DataSource.class);
        SqlUtil.execute(ds);
    }

    @Bean
    public DataSource dataSource(@Autowired DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }
}
