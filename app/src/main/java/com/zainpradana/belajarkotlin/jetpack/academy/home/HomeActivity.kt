package com.zainpradana.belajarkotlin.jetpack.academy.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zainpradana.belajarkotlin.jetpack.academy.R
import com.zainpradana.belajarkotlin.jetpack.academy.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPageAdapter = SectionsPageAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPageAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}