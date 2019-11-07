package com.example.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class NotFoundAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [NotFoundException::class])
    fun handle(exception: NotFoundException, request: HttpServletRequest): ResponseEntity<ErrorDetail> {
        val detail = ErrorDetail(
                Date(),
                HttpStatus.NOT_FOUND.value(),
                "Resource not found",
                request.requestURI
        )
        return ResponseEntity(detail, HttpStatus.NOT_FOUND)
    }
}
