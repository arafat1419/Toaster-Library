package com.arafat1419.androidlibraryone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arafat1419.androidlibraryone.databinding.ActivityMainBinding
import com.arafat1419.mylibrary.ToasterMessage

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val toasterMessage: ToasterMessage by lazy {
        ToasterMessage(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            toasterMessage.show("Ini adalah pesan")
        }
    }
}