package com.deividasstr.daggervmargs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PasswordActivity : AppCompatActivity() {

    @Inject lateinit var injectingFactory: InjectingArgsViewModelFactory

    private fun getVmArgs(): PasswordVmArgs = PasswordVmArgs("password")

    private val viewModel: PasswordViewModel by viewModels { injectingFactory.create(getVmArgs()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.livePassword.observe(this, Observer {  state ->
            password.text = "Password is: ${state.password}"
            retry_count.text = "Retries left: ${state.retryCount}"
        })

        button.setOnClickListener { viewModel.retry() }
    }
}
