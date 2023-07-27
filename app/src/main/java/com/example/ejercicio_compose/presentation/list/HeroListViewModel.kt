package com.example.ejercicio_compose.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicio_compose.domain.model.HeroModel
import com.example.ejercicio_compose.domain.usecase.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import android.content.Context


class HeroListViewModel(
    private val context: Context,
    private val getHeroListUseCase: GetHeroListUseCase
): ViewModel() {
    private val _dataList = MutableLiveData<List<HeroModel>>()
    val dataList: LiveData<List<HeroModel>> get() = _dataList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun getData() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    getHeroListUseCase.invoke()
                }
                _dataList.value = result
            } catch (unknown: UnknownHostException) {
                _error.value = "Error de network"
            } catch (t: Throwable) {
                _error.value = "Error en la aplicación"
            }
        }
    }
}