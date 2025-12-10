package com.example.neuronexus.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class PatientEditProfileViewModel : ViewModel() {

    // Status to tell Fragment if save was successful
    private val _saveStatus = MutableLiveData<Boolean>()
    val saveStatus: LiveData<Boolean> = _saveStatus

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    // Function to simulate saving data
    fun saveChanges(newName: String, newPhone: String, newPass: String) {

        // 1. Basic Validation
        if (newName.isBlank()) {
            _errorMessage.value = "Name cannot be empty"
            return
        }
        if (newPhone.isBlank()) {
            _errorMessage.value = "Phone cannot be empty"
            return
        }
        if (newPass.length < 6) {
            _errorMessage.value = "Password must be at least 6 characters"
            return
        }

        // 2. Simulate API Call / Database Update (with a small delay)
        viewModelScope.launch {
            // Simulate network delay
            delay(1000)

            // 3. Post Success
            _saveStatus.value = true
        }
    }
}