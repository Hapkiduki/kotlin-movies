package com.hapkiduki.movies.presentation.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hapkiduki.movies.common.Resource
import com.hapkiduki.movies.domain.usecases.GetPlayingNowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getPlayingNowUseCase: GetPlayingNowUseCase
) : ViewModel() {
    private val _state = mutableStateOf(MoviesState())
    val state: State<MoviesState> = _state

    init {
        getPlayingNowMovies()
    }

    private fun getPlayingNowMovies() {
        getPlayingNowUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> _state.value = MoviesState(error = result.message!!)
                is Resource.Loading -> _state.value = MoviesState(isLoading = true)
                is Resource.Success -> {
                    _state.value = MoviesState(movies = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}