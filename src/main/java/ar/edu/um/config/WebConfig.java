package ar.edu.um.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = "ar.edu.um")
@EnableWebMvc
public class WebConfig  extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(converter());
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
	}
	
	
	//a donde tiene que ir a buscar las vistas
	@Bean(name = "jspViewResolver")
	public ViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setViewClass(JstlView.class); //se inyecta Java Server Page JSP
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	  configurer.enable();
	}

	@Bean(name="jsonMessage")
    public MappingJackson2HttpMessageConverter converter() {
		final ObjectMapper objectMapper=new ObjectMapper();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
	    return converter;
    }
	
	 @Bean
	 public TilesViewResolver getTilesViewResolver() {
	  TilesViewResolver tilesViewResolver = new TilesViewResolver();
	  tilesViewResolver.setViewClass(TilesView.class);
	  return tilesViewResolver;
	 }


	 @Bean
	 public TilesConfigurer getTilesConfigurer() {
	  TilesConfigurer tilesConfigurer = new TilesConfigurer();
	  tilesConfigurer.setCheckRefresh(true);
	  tilesConfigurer.setDefinitions("WEB-INF/tiles/tiles-definitions.xml");
	  tilesConfigurer.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
      	  
	  return tilesConfigurer;
	 }


}
