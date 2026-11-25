package ru.nto.team

import jakarta.validation.constraints.Pattern
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

// TODO: complete auth API behavior; this compilable route delegates to an unfinished service.
@RestController
class StaffController(private val service: StaffService) {
    @GetMapping("/api/{code}/auth")
    @Validated
    fun profile(
        @PathVariable
        @Pattern(regexp = "^[A-Za-z0-9]{4}$")
        code: String
    ) = service.profile(code)
}
