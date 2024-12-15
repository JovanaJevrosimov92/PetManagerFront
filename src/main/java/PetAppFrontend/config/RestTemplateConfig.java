//package PetAppFrontend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class RestTemplateConfig {
//
//    private final RestTemplateInterceptor restTemplateInterceptor;
//
//    public RestTemplateConfig(RestTemplateInterceptor restTemplateInterceptor) {
//        this.restTemplateInterceptor = restTemplateInterceptor;
//    }
//
//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Dodavanje interceptora
//        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>(restTemplate.getInterceptors());
//        interceptors.add(restTemplateInterceptor);
//        restTemplate.setInterceptors(interceptors);
//
//        return restTemplate;
//    }
//}
