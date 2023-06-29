package com.example.chatgptapp

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.ViewModel
import java.util.Locale

class MainViewModel : ViewModel() {

    private val RQ_SPEECH_REC = 102

    fun askSpeechInput(context: Context) {
        if(!SpeechRecognizer.isRecognitionAvailable(context)) {
            Toast.makeText(context, "Speech Recognition not available", Toast.LENGTH_SHORT).show()
        } else {
            val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Ask AI")
            startActivityForResult(context as Activity, i, RQ_SPEECH_REC, null)
        }
    }

    fun handleSpeechResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RQ_SPEECH_REC && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            Log.d("Mesaj: ", result?.get(0).toString())
        }
    }

}
