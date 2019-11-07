package com.example.demo.controller

import com.example.demo.dto.*
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController(@Autowired private val service: UserService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<UserDTO>> {
        val users = service.findAll().map { user -> user.toUserDTO() }
        return ResponseEntity.ok(users)
    }

    @GetMapping("{id}")
    fun findOne(@PathVariable("id") id: Long): ResponseEntity<UserDTO> {
        val user = service.findOne(id)
        return ResponseEntity.ok(user.toUserDTO())
    }

    @PostMapping
    fun create(@Valid @RequestBody createUserDTO: CreateUserDTO): ResponseEntity<UserDTO> {
        val user = service.create(createUserDTO.toUser())
        return ResponseEntity.ok(user.toUserDTO())
    }

    @PutMapping("{id}")
    fun update(@PathVariable("id") id: Long,
               @Valid @RequestBody updateUserDTO: UpdateUserDTO): ResponseEntity<UserDTO> {
        val user = service.update(id, updateUserDTO.toUser())
        return ResponseEntity.ok(user.toUserDTO())
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<UserDTO> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
