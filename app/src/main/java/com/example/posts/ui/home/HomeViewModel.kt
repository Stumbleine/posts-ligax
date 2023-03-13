package com.example.posts.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.posts.data.Result
import com.example.posts.data.database.PostDao
import com.example.posts.data.database.RoomRepository
import com.example.posts.domain.use_case.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val updatePostUseCase: UpdatePostUseCase,
    private val deletePostUseCase: DeletePostUseCase,
    private val deleteAllPostsUseCase: DeleteAllPostsUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState(isLoading = true))
        private set
    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    private val _tabSelected = MutableLiveData<Int>()
    val tabSelected: LiveData<Int> = _tabSelected

    fun setTab(index: Int) {
        _tabSelected.value = index
    }

    fun getTab(): Int? {
        return _tabSelected.value
    }

    init {
        getPosts()
        getFavorites()
    }

    fun getPosts() {
        viewModelScope.launch {
            getPostsUseCase().onEach { result ->
                when (result) {
                    is Result.Success -> {
                        state = state.copy(
                            posts = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Result.Error -> {
                        state = state.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(
                            UIEvent.ShowSnackBar(
                                result.message ?: "Unknown error"
                            )
                        )
                    }
                    is Result.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(this)
        }
    }

    fun getFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase().also { result ->
                when (result) {
                    is Result.Success -> {
                        Log.i("getFavorites->", result.data.toString())
                        state = state.copy(
                            favorites = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Result.Error -> {
                        state = state.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(
                            UIEvent.ShowSnackBar(
                                result.message ?: "Unknown error"
                            )
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

    fun setFavorite(id: Int, favorite: Boolean) {
        viewModelScope.launch {
            updatePostUseCase(id, favorite)
            getPosts()
            getFavorites()
        }
    }

    fun deletePost(id: Int) {
        Log.i("deletePost>id", id.toString())
        viewModelScope.launch {
            deletePostUseCase(id)
            getPosts()
            getFavorites()
        }
    }

    fun deleteAllPost() {
        Log.i("deleteAll>id", "deleteAll")
        viewModelScope.launch() {
            deleteAllPostsUseCase()
            getPosts()
            getFavorites()
        }
    }

    sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
    }
}