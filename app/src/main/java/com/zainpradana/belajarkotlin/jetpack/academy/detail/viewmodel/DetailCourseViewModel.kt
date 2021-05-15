package com.zainpradana.belajarkotlin.jetpack.academy.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.zainpradana.belajarkotlin.jetpack.academy.data.CourseEntity
import com.zainpradana.belajarkotlin.jetpack.academy.data.ModuleEntity
import com.zainpradana.belajarkotlin.jetpack.academy.data.source.AcademyRepository
import com.zainpradana.belajarkotlin.jetpack.academy.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository): ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
}