package com.zainpradana.belajarkotlin.jetpack.academy.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zainpradana.belajarkotlin.jetpack.academy.R
import com.zainpradana.belajarkotlin.jetpack.academy.academies.viewmodel.ViewModelFactory
import com.zainpradana.belajarkotlin.jetpack.academy.bookmark.adapter.BookmarkAdapter
import com.zainpradana.belajarkotlin.jetpack.academy.bookmark.viewmodel.BookmarkViewModel
import com.zainpradana.belajarkotlin.jetpack.academy.data.CourseEntity
import com.zainpradana.belajarkotlin.jetpack.academy.databinding.FragmentBookmarkBinding

class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

    lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_bookmark, container, false)
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]
            val courses = viewModel.getBookmarks()
            val adapter = BookmarkAdapter(this)
            adapter.setCourses(courses)

            with(fragmentBookmarkBinding.rvBookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagian aplikasi ini sekarang")
                    .setText(resources.getString(R.string.share_text, course.title))
                    .startChooser()
        }
    }

}