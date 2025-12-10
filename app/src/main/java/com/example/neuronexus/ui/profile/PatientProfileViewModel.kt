package com.example.neuronexus.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PatientProfileViewModel : ViewModel() {

    // 1. Name
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    // 2. Email
    private val _userEmail = MutableLiveData<String>()
    val userEmail: LiveData<String> = _userEmail

    // 3. Contact
    private val _userContact = MutableLiveData<String>()
    val userContact: LiveData<String> = _userContact

    // 4. CNIC
    private val _userCnic = MutableLiveData<String>()
    val userCnic: LiveData<String> = _userCnic

    // 5. Image (Optional, for now we use static drawable)

    init {
        loadUserProfile()
    }

    private fun loadUserProfile() {
        _userName.value = "Alex Martines"
        _userEmail.value = "alex.martines@gmail.com"
        _userContact.value = "+92 300 1234567"
        _userCnic.value = "42101-7654321-1"
    }
}