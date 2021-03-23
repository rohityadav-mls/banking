package com.banking.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.banking.model.User;


@Configuration
@ComponentScan(basePackages = { "com.banking.controller" })
public class WebConfig {

   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
   
   @Bean
	public DriverManagerDataSource getConnect() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/bank");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;
	}

	@Bean
	public LocalSessionFactoryBean getSession() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getConnect());
		lsfb.setAnnotatedClasses(User.class);
		Properties hp = new Properties();
		hp.setProperty("hibernate.show_sql", "true");
		hp.setProperty("hibernate.dialet", "org.hibernate.dialect.MySQLDialect");
		hp.setProperty("hibernate.hbm2ddl.auto", "create");
		hp.setProperty("hibernate.format_sql", "true");
		lsfb.setHibernateProperties(hp);
		return lsfb;
	}
}
