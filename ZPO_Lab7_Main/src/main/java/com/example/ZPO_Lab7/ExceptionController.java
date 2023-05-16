package com.example.ZPO_Lab7;


import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.json.JSONObject;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HttpClientErrorException.class)
    public String handleHttpClientErrorException(HttpClientErrorException ex, Model model) {
        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
            String errorMessage = extractErrorMessage(ex);
            model.addAttribute("errorMessage", errorMessage);
            return "error-page";
        }
        throw ex;
    }

    private String extractErrorMessage(HttpClientErrorException ex) {
        try {
            JSONObject errorJson = new JSONObject(ex.getResponseBodyAsString());
            return errorJson.getString("message");
        } catch (JSONException e) {
            return ex.getMessage();
        }
    }

}







