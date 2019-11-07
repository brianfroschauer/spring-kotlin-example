package com.example.demo.service

import com.example.demo.entity.User

interface UserService {

    fun findAll(): List<User>

    fun findOne(id: Long): User

    fun create(user: User): User

    fun update(id: Long, user: User): User

    fun delete(id: Long)
}
