package ru.nto.team

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

// TODO: implement domain errors and validation errors. This only makes unfinished routes usable.
class ApiException(val status: Int, message: String) : RuntimeException(message)
class StaffNotFoundException(val code: String) : RuntimeException("Staff with code '$code' not found")
class ConstraintViolationException(message: String) : RuntimeException(message)

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(ApiException::class)
    fun unfinished(error: ApiException): ResponseEntity<Map<String, String>> =
        ResponseEntity.status(error.status).body(mapOf("error" to error.message!!))

    @ExceptionHandler(StaffNotFoundException::class)
    fun handleStaffNotFound(error: StaffNotFoundException): ResponseEntity<Map<String, String>> =
        ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(mapOf("error" to error.message!!))

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleValidationError(error: ConstraintViolationException): ResponseEntity<Map<String, String>> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOf("error" to error.message!!))
}
