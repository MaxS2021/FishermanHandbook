package com.example.fishermanhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fishermanhandbook.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    lateinit var bind: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityContentBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.tvTitleC.text = intent.getStringExtra("title")
        bind.tvContentL.text = intent.getStringExtra("content")
        bind.imContent.setImageResource(intent.getIntExtra("imId", R.drawable.fishmenbook_logo))

    }
}