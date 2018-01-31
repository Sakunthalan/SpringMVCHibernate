package com.niit.shop.shopback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shop.shopback.impl.CategoryImpl;
import com.niit.shop.shopback.impl.UserImpl;
import com.niit.shop.shopback.model.Supplier;


@Configuration
@ComponentScan({"com.niit.shop.shopback"})
@EnableTransactionManagement
public class HibernateConfig {
	@Autowired
    @Bean(name ="dataSource")
    public DataSource dataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/shop");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }
	
	private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        prop.put("hibernate.hbm2ddl.auto", "update");
        return prop;
    }
	
	@Autowired
    @Bean
    public SessionFactory sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.addProperties(getHibernateProperties());
        builder.addAnnotatedClass(Supplier.class);         
        return builder.buildSessionFactory();
    }
	
	@Bean
    @Autowired
    public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
	
	@Autowired
	@Bean(name="categorydao")
	public CategoryImpl getCategoryData(SessionFactory sessionFactory)
	{
		return new CategoryImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userdao")
	public UserImpl getUserData(SessionFactory sessionFactory)
	{
		return new UserImpl(sessionFactory);
	}
}
