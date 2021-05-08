package com.zainpradana.belajarkotlin.jetpack.academy.reader

interface CourseReaderCallback {
    // Digunakan untuk pindah dari halaman satu ke halaman lain
    fun moveTo(position: Int, moduleId: String)
}