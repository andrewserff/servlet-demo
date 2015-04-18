/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.servlet.Servlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author andrewserff
 */
@Configuration
public class ServletConfig {
    
    @Bean //exposes the TestServlet at /test
    public Servlet test() {
        return new TestServlet();
    }
}
