package sample.hibernate4.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class HibernateConfiguration {

	@Bean
	public DataSource getDataSource() {
		
		return DataSourceBuilder.create()
				.username("postgres")
				.url("jdbc:postgresql://localhost:5432/postgres")
				.driverClassName("org.postgresql.Driver")
				.password("sylar")
				.build();
	}   

	@Bean
    public LocalSessionFactoryBean  getSessionFactory()
    {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());        
		sessionFactory.setPackagesToScan(new String[]{"sample.hibernate4.domain"});
        return sessionFactory;
    }
	
    @Bean
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        
        return properties;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
}