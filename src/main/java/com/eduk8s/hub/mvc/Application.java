package com.eduk8s.hub.mvc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties("web.site")
public class Application {
    public String title;
    public String img;
    public String baseUrl;
}