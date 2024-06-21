package com.iglo.githubsearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.migration.CustomInjection.inject
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val usersService: UsersService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        val adapter = UserAdapter()
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            val users = usersService.getUsers()
            adapter.submitList(users)
        }
    }
}