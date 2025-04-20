package com.feeprocessing.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FallbackController {


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.status(200).body("hi testing...");
    }
	
    @GetMapping("/fallback/student-service")
    public ResponseEntity<String> studentServiceFallback() {
        return ResponseEntity.ok("Student Service is currently unavailable. Please try again later.");
    }

    @GetMapping("/fallback/catalog-service")
    public ResponseEntity<String> catalogServiceFallback() {
        return ResponseEntity.ok("Catalog Service is currently unavailable. Please try again later.");
    }

    @GetMapping("/fallback/fee-service")
    public ResponseEntity<String> feeServiceFallback() {
        return ResponseEntity.ok("Fee Service is currently unavailable. Please try again later.");
    }
}
