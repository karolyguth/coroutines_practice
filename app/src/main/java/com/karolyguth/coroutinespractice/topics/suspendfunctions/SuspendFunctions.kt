package com.karolyguth.coroutinespractice.topics.suspendfunctions

import com.karolyguth.coroutinespractice.util.db.PeopleDao
import com.karolyguth.coroutinespractice.util.db.Person
import io.ktor.client.HttpClient
import io.ktor.client.request.get

suspend fun fetchData(
    peopleDao: PeopleDao,
    client: HttpClient
) {
    val response = client.get("/people/1")
    peopleDao.insertPerson(Person(name = "John Doe"))
}