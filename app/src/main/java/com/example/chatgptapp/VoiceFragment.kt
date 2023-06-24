package com.example.chatgptapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {

    companion object {
        fun newInstance(): Fragment1 {
            return Fragment1()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.voice_fragment, container, false)
        // Fragment 1'in kullanıcı arayüzünü burada oluşturabilirsiniz
        return view
    }
}
