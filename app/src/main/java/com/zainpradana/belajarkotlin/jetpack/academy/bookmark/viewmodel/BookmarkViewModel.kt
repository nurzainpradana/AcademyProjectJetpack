package com.zainpradana.belajarkotlin.jetpack.academy.bookmark.viewmodel

import androidx.lifecycle.ViewModel
import com.zainpradana.belajarkotlin.jetpack.academy.data.CourseEntity
import com.zainpradana.belajarkotlin.jetpack.academy.data.source.AcademyRepository
import com.zainpradana.belajarkotlin.jetpack.academy.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses()

}