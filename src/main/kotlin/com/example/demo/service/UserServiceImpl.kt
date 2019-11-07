package com.example.demo.service

import com.example.demo.entity.User
import com.example.demo.exception.NotFoundException
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val repository: UserRepository) : UserService {

    override fun findOne(id: Long): User {
       return repository
               .findById(id)
               .orElseThrow { NotFoundException() }
    }

    override fun findAll(): List<User> = repository.findAll()

    override fun create(user: User): User = repository.save(user)

    override fun update(id: Long, user: User): User {
        return repository
                .findById(id)
                .map { old -> repository.save(old.copy(firstName = user.firstName, lastName = user.lastName)) }
                .orElseThrow { NotFoundException() }
    }

    override fun delete(id: Long) = repository.delete(findOne(id))
}
