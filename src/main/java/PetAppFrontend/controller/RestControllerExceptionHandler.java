//package PetAppFrontend.controller;
//
//
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//@ControllerAdvice
//public class RestControllerExceptionHandler {
//    private static final Logger log = LoggerFactory.getLogger(RestControllerExceptionHandler.class);
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleException(Exception e) {
//        log.error("An error occurred: {}", e.getMessage());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + e.getMessage());
//    }
//}
