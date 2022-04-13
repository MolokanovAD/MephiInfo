package ru.mephi.info.repository

import org.springframework.data.repository.CrudRepository
import ru.mephi.info.model.Group

interface GroupDao:CrudRepository<Group, Int>