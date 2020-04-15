package com.deividasstr.daggervmargs

import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@AssistedModule
@Module(includes = [AssistedInject_AssistedViewModelModule::class])
abstract class AssistedViewModelModule {

    companion object {
        @Provides
        fun provideInt(): Int {
            return 5
        }
    }

    @Binds
    @IntoMap
    @ViewModelKey(PasswordViewModel::class)
    abstract fun passwordViewModelFactory(factory: PasswordViewModel.Factory): AssistedViewModelFactory<out ViewModel, in ViewModelArgument>
}

/*@AssistedModule
@Module(includes = [AssistedInject_AssistedViewModelModule::class])
object AssistedViewModelModule {

    @Provides
    fun provideInt(): Int {
        return 5
    }

    @Provides
    @IntoMap
    @ViewModelKey(PasswordViewModel::class)
    fun passwordViewModelFactory(factory: PasswordViewModel.Factory): AssistedViewModelFactory<out ViewModel, in ViewModelArgument> {
        return factory as AssistedViewModelFactory<out ViewModel, in ViewModelArgument>
    }
}*/
