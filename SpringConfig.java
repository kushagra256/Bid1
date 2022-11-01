package Bid.Configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@ComponentScan("Bid")
@EnableWebMvc
public class SpringConfig {
    @Bean
    public InternalResourceViewResolver getResolver() {
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    @Bean
    public LocalSessionFactoryBean getSessionFactoryBean() {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setHibernateProperties(hibernateProperties());
        bean.setAnnotatedClasses(Bid.Model.Bidactive.class);
        return bean;
    }
    private Properties hibernateProperties() {
        Properties properties=new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.Oracle12cDialect");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.2ddl.auto","update");
        properties.put("current_session_context_class","thread");
        return properties;
    }

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.Oracle.Driver");
        ds.setUrl("jdbc:oracle:thin:@10.1.50.198:1535/nsbt19c");
        ds.setUsername("sh");
        ds.setPassword("sh");
        return ds;
    }
}
