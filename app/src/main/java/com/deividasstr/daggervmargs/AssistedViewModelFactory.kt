package com.deividasstr.daggervmargs

import androidx.lifecycle.ViewModel

interface AssistedViewModelFactory<Vm : ViewModel, Args: ViewModelArgument> {
    fun create(arguments: Args): Vm
}