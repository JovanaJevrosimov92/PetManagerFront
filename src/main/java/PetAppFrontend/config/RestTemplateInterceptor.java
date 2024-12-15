//package PetAppFrontend.config;
//
//import org.springframework.http.HttpRequest;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
//    @Override
//    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        // Dinamički dohvatiti trenutni JSESSIONID
//        String sessionId = fetchSessionIdFromCookiesOrSession();
//        request.getHeaders().add("Cookie", "JSESSIONID=" + sessionId);
//        return execution.execute(request, body);
//    }
//
//    private String fetchSessionIdFromCookiesOrSession() {
//        // Ova metoda treba da dobavi JSESSIONID iz kolačića ili sesije korisnika
//        return "dinamički_session_id"; // Implementirati ovu logiku
//    }
//}
