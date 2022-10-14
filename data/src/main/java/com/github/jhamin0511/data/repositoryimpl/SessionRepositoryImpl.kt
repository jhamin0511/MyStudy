package com.github.jhamin0511.data.repositoryimpl

import com.github.jhamin0511.data.remote.SessionRemoteDataSource
import com.github.jhamin0511.domain.model.User
import com.github.jhamin0511.domain.repository.SessionRepository

class SessionRepositoryImpl(
    private val remoteDataSource: SessionRemoteDataSource
) : SessionRepository {

    override fun postSession(email: String, password: String, token: String): User {
        val session = remoteDataSource.postSession(email, password, token)
        return User(
            session.id,
            session.email,
            session.name,
            session.age,
            session.address,
            session.job
        )
    }
}
