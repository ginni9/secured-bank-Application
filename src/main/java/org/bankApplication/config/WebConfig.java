package org.bankApplication.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


@Configuration
@EnableWebMvc
@ComponentScan("org.bankApplication.controller")
@PropertySource("classpath:application.properties")
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Bean
    public DataSource securityDataSource()
    {
        ComboPooledDataSource securityDataSource=new ComboPooledDataSource();
        try
        {
            securityDataSource.setDriverClass(env.getProperty("db.driver"));
            securityDataSource.setJdbcUrl(env.getProperty("db.url"));
            securityDataSource.setUser(env.getProperty("db.username"));
            securityDataSource.setPassword(env.getProperty("db.password"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return securityDataSource;
    }

}