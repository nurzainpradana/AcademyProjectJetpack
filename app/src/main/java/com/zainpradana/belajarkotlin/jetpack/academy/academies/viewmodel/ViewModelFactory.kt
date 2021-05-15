package com.zainpradana.belajarkotlin.jetpack.academy.academies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zainpradana.belajarkotlin.jetpack.academy.academies.di.Injection
import com.zainpradana.belajarkotlin.jetpack.academy.bookmark.viewmodel.BookmarkViewModel
import com.zainpradana.belajarkotlin.jetpack.academy.data.source.AcademyRepository
import com.zainpradana.belajarkotlin.jetpack.academy.detail.viewmodel.DetailCourseViewModel
import com.zainpradana.belajarkotlin.jetpack.academy.reader.viewmodel.CourseReaderViewModel

// Membuat View Model Factory buatan sendiri
class ViewModelFactory private constructor(private val mAcademyRepository: AcademyRepository): ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(AcademyViewModel::class.java) -> {
                return AcademyViewModel(mAcademyRepository) as T
            }

            modelClass.isAssignableFrom(DetailCourseViewModel::class.java) -> {
                return DetailCourseViewModel(mAcademyRepository) as T
            }

            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                return BookmarkViewModel(mAcademyRepository) as T
            }

            modelClass.isAssignableFrom(CourseReaderViewModel::class.java) -> {
                return CourseReaderViewModel(mAcademyRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}