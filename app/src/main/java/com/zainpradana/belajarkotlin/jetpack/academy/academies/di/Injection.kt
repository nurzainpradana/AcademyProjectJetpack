package com.zainpradana.belajarkotlin.jetpack.academy.academies.di

import android.content.Context
import com.zainpradana.belajarkotlin.jetpack.academy.data.source.AcademyRepository
import com.zainpradana.belajarkotlin.jetpack.academy.data.source.remote.RemoteDataSource
import com.zainpradana.belajarkotlin.jetpack.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}