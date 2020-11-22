
package udemy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Priority;

@Priority(0)
@Configuration
@PropertySource("classpath:application20.properties")
public class ConfigurationClass {

    @Value("${jdbc.url}")
    public String jdbcUrl;

    public String getJDBC(){
        return jdbcUrl;
    }
}

