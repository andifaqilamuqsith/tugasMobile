package com.d121211060.Bola.ui.activities.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211060.Bola.MyApplication
import com.d121211060.Bola.data.models.Result
import com.d121211060.Bola.data.repository.BolaRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val match: List<Result>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val bolaRepository: BolaRepository): ViewModel() {

    // initial state
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getMatches() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = bolaRepository.getBola()
            mainUiState = MainUiState.Success(result.result.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    // block yg prtama dipanggil ktika ini dibuka
    init {
        getMatches()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val bolaRepository = application.container.bolaRepository
                MainViewModel(bolaRepository)
            }
        }
    }
}