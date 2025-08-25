package com.reyes.greetingapp;

import jakarta.validation.Valid; // Add this import
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // Add this import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate; // Add this import
import java.time.format.DateTimeParseException; // Add this import

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@Valid @ModelAttribute Greeting greeting, BindingResult bindingResult, Model model) { // <-- MODIFIED LINE

        // 1. Check for basic validation errors (from @NotNull, @Min, @Max, @Size in Greeting.java)
        if (bindingResult.hasErrors()) {

            return "greeting";
        }

        // 2. Additional validation for valid date (e.g., February 30th)
        try {
            // Attempt to create a LocalDate object from the user's input
            LocalDate date = LocalDate.of(greeting.getYear(), greeting.getMonth(), greeting.getDay());

            // If LocalDate.of() succeeds, the date is valid. You can optionally
            // store this LocalDate in the Greeting object or use it as needed.
            // For now, ill just proceed.

        } catch (DateTimeParseException e) {
            // If LocalDate.of() throws DateTimeParseException, the date is invalid (e.g., Feb 30)
            bindingResult.rejectValue("day", "date.invalid", "The entered date is not a valid calendar date.");
            return "greeting";
        } catch (Exception e) {
            // Catch any other unexpected date-related errors
            bindingResult.rejectValue("year", "date.general.error", "An unexpected error occurred with the date.");
            return "greeting";
        }

        // If no validation errors (basic or date-specific), proceed to the result page
        model.addAttribute("greeting", greeting); // Ensure the model attribute is added for the result page
        return "result";
    }
}