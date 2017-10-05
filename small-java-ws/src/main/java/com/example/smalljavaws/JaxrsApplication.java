package com.example.smalljavaws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/small-java-ws/")
public class JaxrsApplication extends Application {

}
