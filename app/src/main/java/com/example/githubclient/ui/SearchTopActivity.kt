package com.example.githubclient.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.githubclient.databinding.ActivitySearchTopBinding

class SearchTopActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchTopBinding

    private val viewModel: SearchGithubViewModel by lazy {
        ViewModelProvider(this, SearchGithubViewModelFactory())[SearchGithubViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchTopBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        setupView()
    }

    private fun setupView() {
        binding.searchUserNameButton.setOnClickListener {
            val name = binding.editUserName.text.toString()
            viewModel.searchUserRepositories(name)
        }
    }
}