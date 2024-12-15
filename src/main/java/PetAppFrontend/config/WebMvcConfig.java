//package PetAppFrontend.config;
//
//import jakarta.servlet.http.HttpSessionEvent;
//import jakarta.servlet.http.HttpSessionListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//    @Bean
//    public HttpSessionListener httpSessionListener() {
//        return new HttpSessionListener() {
//            @Override
//            public void sessionCreated(HttpSessionEvent se) {
//                System.out.println("Sesija kreirana: " + se.getSession().getId());
//            }
//
//            @Override
//            public void sessionDestroyed(HttpSessionEvent se) {
//                System.out.println("Sesija uništena: " + se.getSession().getId());
//            }
//        };
//    }
//}
