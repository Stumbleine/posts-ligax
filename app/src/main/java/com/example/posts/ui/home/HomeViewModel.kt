package com.example.posts.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.domain.use_case.GetPostsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.posts.data.Result
import com.example.posts.data.database.PostDao
import com.example.posts.data.database.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {

    var state by mutableStateOf(HomeState(isLoading = true))
        private set
    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    private val _tabSelected = MutableLiveData<Int>()
    val tabSelected: LiveData<Int> = _tabSelected
    fun setTab (index:Int){
        _tabSelected.value = index
    }
    fun getTab (): Int? {
        return _tabSelected.value
    }
    init {
        getPosts()
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
                        _eventFlow.emit(UIEvent.ShowSnackBar(
                            result.message ?: "Unknown error"
                        ))
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

    sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
    }

}