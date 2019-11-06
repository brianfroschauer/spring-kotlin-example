package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(@Autowired private val service: UserService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<User>> {
        val users = service.findAll()
        return ResponseEntity.ok(users)
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Long): ResponseEntity<User> {
        val user = service.findOne(id)
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun create(@Valid @RequestBody user: User): ResponseEntity<User> {
        val created = service.create(user)
        return ResponseEntity.ok(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long,
               @Valid @RequestBody user: User): ResponseEntity<User> {
        val updated = service.update(user)
        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<User> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
