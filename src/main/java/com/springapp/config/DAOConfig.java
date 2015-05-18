package com.springapp.config;

//import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;




import javax.sql.DataSource;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: au011262
 * Date: 11/09/14
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@ComponentScan(basePackages = "com.springapp.dao")
@EnableTransactionManagement
@EnableJpaRepositories("com.springapp.dao")
@PropertySource("file:${appbase}/database.properties")


public class DAOConfig {

    @Autowired
    private org.springframework.core.env.Environment env;


    @Bean()
    public DataSource getDataSource()
    {
        final DriverManagerDataSource ds = new DriverManagerDataSource();
        //final HikariDataSource ds = new HikariDataSource();
        //ds.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("hibernate.connection.poolsize")));
        //ds.setJdbcUrl(env.getRequiredProperty("hibernate.connection.url"));
        ds.setUrl(env.getRequiredProperty("hibernate.connection.url"));
        ds.setDriverClassName(env.getRequiredProperty("hibernate.connection.driver_class"));
        ds.setUsername(env.getRequiredProperty("hibernate.connection.username"));
        ds.setPassword(env.getRequiredProperty("hibernate.connection.password"));
        
              
        /*ds.addDataSourceProperty("url", env.getRequiredProperty("hibernate.connection.url"));
        ds.addDataSourceProperty("user", env.getRequiredProperty("hibernate.connection.username"));
        ds.addDataSourceProperty("password", env.getRequiredProperty("hibernate.connection.password"));
        ds.addDataSourceProperty("cachePrepStmts", true);
        ds.addDataSourceProperty("prepStmtCacheSize", 250);
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        ds.addDataSourceProperty("useServerPrepStmts", true);*/

        
        return ds;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getDataSource());
        emf.setPackagesToScan("com.springapp.dao");

        //let Hibernate know which database we're using.
        //note that this is vendor specific, not JPA
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        va.setShowSql(Boolean.parseBoolean(env.getRequiredProperty("hibernate.show_sql")));
        va.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));

        // ORM specific properties
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto","create-drop");
        jpaProperties.setProperty("hibernate.dialect",env.getRequiredProperty("hibernate.dialect"));

        emf.setJpaVendorAdapter(va);
        emf.setJpaProperties(jpaProperties);
        emf.setPackagesToScan("com.springapp.dao");
        emf.setDataSource(getDataSource());

        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
    
    
    
    /*Post-processor to perform exception translation on @Repository classes
    (from native exceptions such as JPA PersistenceExceptions to
    Spring&rsquo;s DataAccessException hierarchy).
    */

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
       return new PersistenceExceptionTranslationPostProcessor();
    }

}


