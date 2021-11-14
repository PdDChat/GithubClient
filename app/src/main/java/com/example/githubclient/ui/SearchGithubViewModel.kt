package com.example.githubclient.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.githubclient.repository.GithubRepository
import kotlinx.coroutines.launch

class SearchGithubViewModel(private val repository: GithubRepository): ViewModel() {

    fun searchUserRepositories(name: String) {
        viewModelScope.launch {
            repository.searchUserRepositories(name)
        }
    }
}

@Suppress("UNCHECKED_CAST")
class SearchGithubViewModelFactory(
    private val repository: GithubRepository = GithubRepository()
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchGithubViewModel(repository) as T
    }
}