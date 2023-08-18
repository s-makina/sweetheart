package com.example.sweetheart.ui.usecases

class ValidateDate {
    fun execute(date: Long?): ValidationResult {
        if (date == null) {
            return ValidationResult(
                successful = false,
                errorMessage = "Required"
            )
        }
        return ValidationResult(successful = true)
    }
}