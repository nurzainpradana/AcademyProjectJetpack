package com.zainpradana.belajarkotlin.jetpack.academy.bookmark.viewmodel

import androidx.lifecycle.ViewModel
import com.zainpradana.belajarkotlin.jetpack.academy.data.CourseEntity
import com.zainpradana.belajarkotlin.jetpack.academy.utils.DataDummy

class BookmarkViewModel: ViewModel() {

    fun getBookmars(): List<CourseEntity> = DataDummy.generatedDummyCourses()

}