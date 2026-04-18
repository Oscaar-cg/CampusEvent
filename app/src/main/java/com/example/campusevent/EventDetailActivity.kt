package com.example.campusevent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campusevent.databinding.ActivityEventDetailBinding

class EventDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val location = intent.getStringExtra("location")
        val image = intent.getIntExtra("image", 0)

        binding.detailTitle.text = title
        binding.detailDate.text = date
        binding.detailLocation.text = location
        binding.detailImage.setImageResource(image)

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}