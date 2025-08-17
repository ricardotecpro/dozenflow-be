package com.dozenflow.be.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller to handle requests to the root path and redirect to the API documentation.
 */
@Controller
@Hidden // This hides the controller from the Swagger UI documentation
public class RootController {

    @GetMapping("/")
    public String redirectToSwaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}