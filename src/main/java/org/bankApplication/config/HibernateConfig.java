package org.bankApplication.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.bankApplication.model.BankBranch;
import org.bankApplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan("org.bankApplication")

public class HibernateConfig {

    @Autowired
    private Environment env;



    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();
        props.put(DRIVER, env.getProperty("db.driver"));
        props.put(URL, env.getProperty("db.url"));
        props.put(USER, env.getProperty("db.username"));
        props.put(PASS, env.getProperty("db.password"));

        // Setting Hibernate properties
        props.put(DIALECT, env.getProperty("hibernate.dialect"));
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT,
                env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));



        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(Customer.class, BankBranch.class);

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}