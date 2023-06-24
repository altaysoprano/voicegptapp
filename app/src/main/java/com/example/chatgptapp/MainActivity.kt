package com.example.chatgptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, Fragment1.newInstance())
            }
        }

        val askButton: Button = findViewById(R.id.ask_button)

        askButton.setOnClickListener {
            viewModel.showAskAlertDialog(this)
        }
    }
}
