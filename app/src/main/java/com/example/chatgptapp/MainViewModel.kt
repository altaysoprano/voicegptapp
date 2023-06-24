package com.example.chatgptapp

import android.app.AlertDialog
import android.content.Context
import android.view.WindowManager
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // ViewModel ile ilgili veriler ve işlevler buraya yerleştirilebilir

    fun showAskAlertDialog(context: Context) {
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("Ask")
            .setMessage("How can I help you?")
            .setPositiveButton("OK") { dialog, which ->
                // OK butonuna tıklanınca yapılacak işlemler
            }
            .setNegativeButton("Cancel") { dialog, which ->
                // Cancel butonuna tıklanınca yapılacak işlemler
            }
            .create()

        val layoutParams = alertDialog.window?.attributes
        layoutParams?.horizontalMargin = context.resources.getDimensionPixelSize(R.dimen.dialog_margin).toFloat()
        layoutParams?.verticalMargin = context.resources.getDimensionPixelSize(R.dimen.dialog_margin).toFloat()
        alertDialog.window?.attributes = layoutParams

        alertDialog.show()
        alertDialog.window?.attributes = layoutParams
    }
}
