package com.eduk8s.hub;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.eduk8s.hub.config.Eduk8sPortalConfig;
import com.eduk8s.hub.mustache.HubMustacheEnvironmentCollector;
import com.samskivert.mustache.Mustache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eduk8s.hub"})
@ConfigurationPropertiesScan("com.eduk8s.hub.config")
public class HubApplication /*implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(HubApplication.class, args);
	}

    @Bean
    public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader templateLoader, Environment environment) {
      HubMustacheEnvironmentCollector collector = new HubMustacheEnvironmentCollector();
      System.out.println("Title" + environment.getProperty("web.site.title"));
      collector.setEnvironment(environment);

      return Mustache.compiler().defaultValue("Some Default Value").withLoader(templateLoader).withCollector(collector)
          .withFormatter(new Mustache.Formatter() {
            public String format(Object value) {
              if (value instanceof Date)
                return _fmt.format((Date) value);
              else
                return String.valueOf(value);
            }
            protected DateFormat _fmt = new SimpleDateFormat("yyyy/MM/dd");
          });

    }

/*
    @Autowired
    private Eduk8sPortalConfig properties;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Properties: " + properties);
    }
*/
}
