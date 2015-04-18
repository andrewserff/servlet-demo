### servlet-demo
This is a test application that shows a problem with Spring Boot I'm having.  


I'm trying to integrate a 3rd party servlet into my Spring Boot application and when I try to submit a POST to the servlet, I see the following in the logs: 

    PageNotFound: Request method 'POST' not supported

I've made a simple test that show this. I started using an [auto generated Spring Boot project][1]. Then I created the following Servlet:

    public class TestServlet extends HttpServlet {
        private static final Logger log = LoggerFactory.getLogger(TestServlet.class);
        
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
            log.info("doPost was called!!");
        }
        
    }

Then I my created Configuration like so:

    @Configuration
    public class ServletConfig {
        @Bean //exposes the TestServlet at /test
        public Servlet test() {
            return new TestServlet();
        }        
    }

Then I run the application within Tomcat7.  I see in the logs:

    ServletRegistrationBean: Mapping servlet: 'test' to [/test/]

Then I try to hit the endpoint with cUrl like so:

    curl -v http://localhost:8080/test -data-binary '{"test":true}'
or

    curl -XPOST -H'Content-type: application/json' http://localhost:8080/session -d '{"test":true}'

I've tried adding a @RequestMapping, but that didn't work either. Can anyone help me figure out how to support another Servlet inside my Spring Boot application?

  [1]: http://start.spring.io/