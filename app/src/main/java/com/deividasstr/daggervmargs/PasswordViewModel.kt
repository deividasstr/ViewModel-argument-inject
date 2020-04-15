package com.deividasstr.daggervmargs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class PasswordViewModel @AssistedInject constructor(
    @Assisted private val arguments: PasswordVmArgs,
    retryTimes: Int
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory : AssistedViewModelFactory<PasswordViewModel, PasswordVmArgs>{
        override fun create(arguments: PasswordVmArgs): PasswordViewModel
    }

    private var retryCountdown = retryTimes

    private val passwordStateProvider = MutableLiveData<PasswordState>().apply {
        value = PasswordState(retryCountdown, arguments.password)
    }

    val livePassword: LiveData<PasswordState> = passwordStateProvider

    fun retry() {
        retryCountdown--
        passwordStateProvider.postValue(PasswordState(retryCountdown, arguments.password))
    }
}