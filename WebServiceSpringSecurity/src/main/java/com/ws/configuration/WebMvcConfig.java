package com.ws.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ws.dao.DaoAllListImpl;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.ws.Service.ServiceAllListImpl;
import com.ws.Service.ServiceById;
import com.ws.Service.ServiceGenerImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.ws.*")
//@PropertySource({"classpath:db.properties"})
public class WebMvcConfig implements WebMvcConfigurer {
 
	@Autowired
	private Environment environment;
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
 
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
//    @Bean
//	public DataSource dataSource() {
////		BasicDataSource dataSource = new BasicDataSource();
//		MysqlDataSource ds = null;
////    	BasicDataSource dataSource = (BasicDataSource)HibernateUtil.getSessionFactory();
//		Properties h = new Properties();
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("db.properties");
//			h.load(fis);
//			ds = new MysqlDataSource();
//			ds.setUrl(h.getProperty("MYSQL_DB_URL"));
//			ds.setUser(h.getProperty("MYSQL_DB_USERNAME"));
//			ds.setPassword(h.getProperty("MYSQL_DB_PASSWORD"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
////		dataSource.setDriverClassName(h.getProperty("com.mysql.cj.jdbc.Driver"));
////		dataSource.setUrl(h.getProperty("jdbc:mysql://ubuntu-mysql.creativa.com:3306/comercio2?useSSL=false"));
////		dataSource.setUsername(h.getProperty("developer"));
////		dataSource.setPassword(h.getProperty("rjniKzBeWObf"));
////		return dataSource;
////		ds.setDriverClassName(h.getProperty("com.mysql.cj.jdbc.Driver"));
//		
//		return ds;
//	}
    
//    @Bean
////    @Qualifier("data")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://ubuntu-mysql.creativa.com:3306/comercio2?useSSL=false");
//        dataSource.setUsername("developer");
//        dataSource.setPassword("rjniKzBeWObf");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//
//        return dataSource;
//    }
    
    @Bean(name = "serviceImpl")
    public ServiceAllListImpl serviceImpl() {
    	return new ServiceAllListImpl();
    }
    
    @Bean(name = "byIdImpl")
    public ServiceById byIdImpl() {
    	return new ServiceById();
    }
    
    @Bean(name = "genericImpl")
    public ServiceGenerImpl genericImpl() {
    	return new ServiceGenerImpl();
    }
    
    @Bean(name = "listDao")
    public DaoAllListImpl listDao() {
    	return new DaoAllListImpl();
    }
    
//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//    }
    
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver createMultipartResolver() {
//        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("utf-8");
//        return resolver;
//    }
 
}
