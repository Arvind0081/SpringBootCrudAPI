package com.arvind.crudapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

   @Bean
   public OpenAPI defineOpenApi() {
        // Development server
        Server devServer = new Server();
        devServer.setUrl("http://localhost:9090");
        devServer.setDescription("Development");
 
        // Production server
        Server prodServer = new Server();
        prodServer.setUrl("http://production.example.com");
        prodServer.setDescription("Production");

       Contact myContact = new Contact();
       myContact.setName("Arvind Chauhan");
       myContact.setEmail("chauhan0081@gmail.com");

       Info information = new Info()
               .title("Employee Management System API")
               .version("1.0")
               .description("This API exposes endpoints to manage employees.")
               .contact(myContact);
       return new OpenAPI().info(information).servers(List.of(devServer, prodServer));
   }
}
