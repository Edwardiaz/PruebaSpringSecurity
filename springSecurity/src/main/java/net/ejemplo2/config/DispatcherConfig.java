package net.ejemplo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


	@Configuration
	@EnableWebMvc
	@ComponentScans(
	value = {@ComponentScan("net.ejemplo2.dao"),
			 @ComponentScan("net.ejemplo2.servicio"),
			 @ComponentScan(basePackages = {"net.ejemplo2.controller"})}) // Scans the following packages for classes with @Controller annotations
	public class DispatcherConfig  implements WebMvcConfigurer {
	    @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }

	    @Bean
	    public ViewResolver getViewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	    
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	      registry.addViewController("/login").setViewName("login");
	    }
	}