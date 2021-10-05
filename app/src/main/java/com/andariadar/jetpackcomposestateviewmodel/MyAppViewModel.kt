package com.andariadar.jetpackcomposestateviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyAppViewModel: ViewModel() {
    private val _number = MutableStateFlow(0)
    val number: StateFlow<Int> = _number

    fun onNumberAdd() {
        _number.value++
    }
}