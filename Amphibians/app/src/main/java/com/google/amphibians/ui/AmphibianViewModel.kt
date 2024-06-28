package com.google.amphibians.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.amphibians.network.Amphibian
import com.google.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel : ViewModel() {

    private val _status  = MutableLiveData<AmphibianApiStatus>()
    val status get() = _status

    private val _amphibians   = MutableLiveData<List<Amphibian>>()
    val amphibians  get() = _amphibians

    private val _amphibian   = MutableLiveData<Amphibian>()
    val amphibian  get() = _amphibian

    init {
        getAmphibianList()
    }

    private fun getAmphibianList() {
        viewModelScope.launch {
            _status.value = AmphibianApiStatus.LOADING
            try {
                _amphibians.value = AmphibianApi.retrofitService.getAmphibians()
                _status.value = AmphibianApiStatus.DONE
            }catch (exception : Exception){
                _amphibians.value = listOf()
                _status.value = AmphibianApiStatus.ERROR
            }
        }
    }

    fun onAmphibianClicked(amphibian: Amphibian) {
        _amphibian.value = amphibian
    }
}