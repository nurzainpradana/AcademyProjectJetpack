package com.zainpradana.belajarkotlin.jetpack.academy.bookmark

import com.zainpradana.belajarkotlin.jetpack.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
