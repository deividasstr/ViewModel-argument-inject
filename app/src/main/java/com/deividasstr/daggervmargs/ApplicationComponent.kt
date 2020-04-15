package com.deividasstr.daggervmargs

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [AssistedViewModelModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(): ApplicationComponent
    }

    fun inject(passwordActivity: PasswordActivity)
}