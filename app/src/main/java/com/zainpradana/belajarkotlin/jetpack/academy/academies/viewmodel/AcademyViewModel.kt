package com.zainpradana.belajarkotlin.jetpack.academy.academies.viewmodel

import androidx.lifecycle.ViewModel
import com.zainpradana.belajarkotlin.jetpack.academy.data.CourseEntity
import com.zainpradana.belajarkotlin.jetpack.academy.data.source.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses()
}