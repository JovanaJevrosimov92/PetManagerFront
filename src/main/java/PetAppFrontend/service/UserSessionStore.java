package PetAppFrontend.service;

import org.springframework.stereotype.Component;

@Component
public class UserSessionStore {
    private static String sessionId;

    public static void setSessionId(String Id) {
        sessionId = Id;
    }

    public static String getSessionId() {
        return sessionId;
    }
}
