package com.example.posts.ui.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.domain.use_case.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.posts.data.Result
import com.example.posts.domain.use_case.GetUserUseCase
import com.example.posts.domain.use_case.getCommentsUseCase
import kotlinx.coroutines.launch

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val getUserUseCase: GetUserUseCase,
    private  val getCommentsUseCase: getCommentsUseCase,
    private val savedStateHandle: SavedStateHandle
):ViewModel(){


     var state by mutableStateOf(DetailState())
         private set
    init {
        Log.i("init","ingresa a init")
        getPost()
        getComments()
    }
    private fun getPost() {
        savedStateHandle.get<Int>("id")?.let { postId ->
            viewModelScope.launch {
                getPostUseCase(postId).also { result ->
                    when (result) {
                        is Result.Success -> {
                            state = state.copy(
                                post = result.data,
                                isLoading = false
                            )
                            state.post?.let { getUser(it.userId) }
                        }
                        is Result.Error -> {
                            state = state.copy(
                                isLoading = false
                            )
                        }
                        is Result.Loading -> {
                            state = state.copy(
                                isLoading = true
                            )
                        }
                    }
                }
            }
        }
    }
    private fun getComments(){
        savedStateHandle.get<Int>("id")?.let { postId ->
            viewModelScope.launch {
                getCommentsUseCase(postId).also { result ->
                    when (result) {
                        is Result.Success -> {
                            state = state.copy(
                                comments = result.data?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Result.Error -> {
                            state = state.copy(
                                isLoading = false
                            )
                        }
                        is Result.Loading -> {
                            state = state.copy(
                                isLoading = true
                            )
                        }
                    }
                }
            }
        }
    }
    private fun getUser(userId:Int){
            viewModelScope.launch {
                getUserUseCase(userId).also { result ->
                    when (result) {
                        is Result.Success -> {
                            state = state.copy(
                                user = result.data,
                                isLoading = false
                            )
                        }
                        is Result.Error -> {
                            state = state.copy(
                                isLoading = false
                            )
                        }
                        is Result.Loading -> {
                            state = state.copy(
                                isLoading = true
                            )
                        }
                    }
                }
            }
    }

}