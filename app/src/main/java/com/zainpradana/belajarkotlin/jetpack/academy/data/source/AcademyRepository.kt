package com.zainpradana.belajarkotlin.jetpack.academy.data.source

import com.zainpradana.belajarkotlin.jetpack.academy.data.ContentEntity
import com.zainpradana.belajarkotlin.jetpack.academy.data.CourseEntity
import com.zainpradana.belajarkotlin.jetpack.academy.data.ModuleEntity
import com.zainpradana.belajarkotlin.jetpack.academy.data.source.remote.RemoteDataSource

// Untuk menghubungkan Remote Data Source
// sebagai filter antara remote dan local
class AcademyRepository private constructor(private val remoteDataSource: RemoteDataSource): AcademyDataSource {
    companion object {
        @Volatile
        private var instance: AcademyRepository? = null

        fun getInstance(remoteData: RemoteDataSource): AcademyRepository =
            instance ?: synchronized(this) {
                instance ?: AcademyRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllCourses(): List<CourseEntity> {
        val courseResponse = remoteDataSource.getAllCourses()
        val courseList = ArrayList<CourseEntity>()
        for (response in courseResponse) {
            val course = CourseEntity(response.id,
            response.title,
            response.description,
            response.date,
            false,
            response.imagePath)

            courseList.add(course)
        }
        return courseList
    }

    override fun getBookmarkedCourses(): List<CourseEntity> {
        val courseResponses = remoteDataSource.getAllCourses()
        val courseList = ArrayList<CourseEntity>()

        for (response in courseResponses) {
            val course = CourseEntity(response.id,
                response.description,
                response.title,
                response.date,
                false,
                response.imagePath)

            courseList.add(course)
        }
        return courseList
    }

    override fun getCourseWithModules(courseId: String): CourseEntity {
        val courseResponses = remoteDataSource.getAllCourses()
        lateinit var course: CourseEntity
        for (response in courseResponses) {
            if (response.id == courseId) {
                course = CourseEntity(
                    response.id,
                    response.title,
                    response.description,
                    response.date,
                    false,
                    response.imagePath
                )
            }
        }
        return course
    }

    override fun getAllModulesByCourse(courseId: String): List<ModuleEntity> {
        val moduleResponses = remoteDataSource.getModules(courseId)
        val moduleList = ArrayList<ModuleEntity>()
        for (response in moduleResponses) {
            val course = ModuleEntity(
                response.moduleId,
                response.courseId,
                response.title,
                response.position,
                false
            )

            moduleList.add(course)
        }
        return moduleList
    }

    override fun getContent(courseId: String, moduleId: String): ModuleEntity {
        val moduleResponse = remoteDataSource.getModules(courseId)
        lateinit var module: ModuleEntity

        for (response in moduleResponse) {
            if (response.moduleId == moduleId) {
                module = ModuleEntity(
                    response.moduleId,
                    response.courseId,
                    response.title,
                    response.position,
                    false
                )

                module.contentEntity = ContentEntity(remoteDataSource.getContent(moduleId).content)
                break
            }
        }
        return module
    }
}