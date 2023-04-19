package com.example.sweetheart.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sweetheart.data.repo.MainRepo
import com.example.sweetheart.ui.usecases.Validators
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepo: MainRepo
) : ViewModel() {

    val validators = Validators()
}