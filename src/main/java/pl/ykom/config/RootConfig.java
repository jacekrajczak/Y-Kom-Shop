package pl.ykom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "pl.ykom.core")
public class RootConfig {

}
