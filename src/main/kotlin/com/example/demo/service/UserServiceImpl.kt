package com.example.demo.service

import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val repository: UserRepository) : UserService {

    override fun findOne(id: Long): User {
       return repository
               .findById(id)
               .orElseThrow { RuntimeException() }
    }

    override fun findAll(): List<User> = repository.findAll()

    override fun create(user: User): User = repository.save(user)

    override fun update(user: User): User {
        return repository
                .findById(user.id)
                .map { old -> old.copy(firstName = user.firstName, lastName = user.lastName) }
                .orElseThrow { RuntimeException() }
    }

    override fun delete(id: Long) = repository.deleteById(id)
}
