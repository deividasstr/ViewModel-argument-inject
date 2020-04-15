package com.deividasstr.daggervmargs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Reusable
import javax.inject.Inject

@Reusable
class InjectingArgsViewModelFactory @Inject constructor(
        private val factories: Map<Class<out ViewModel>, @JvmSuppressWildcards AssistedViewModelFactory<out ViewModel, in ViewModelArgument>>
) {

    fun create(args: ViewModelArgument): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(model: Class<T>): T {
                factories[model]?.let { factory ->
                        return factory.create(args) as T
                } ?: throw IllegalArgumentException("Unknown VM $model")
            }
        }
    }
}