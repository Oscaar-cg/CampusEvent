package com.example.campusevent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.campusevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var originalList: List<Event>
    private var isFiltered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        originalList = EventRepository.getEvents()

        binding.eventRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.eventRecyclerView.adapter = EventAdapter(originalList)

        binding.filterButton.setOnClickListener {

            if (!isFiltered) {
                val filtered = originalList.filter {
                    it.title.contains("Basketball")
                }
                binding.eventRecyclerView.adapter = EventAdapter(filtered)
                isFiltered = true
            } else {
                binding.eventRecyclerView.adapter = EventAdapter(originalList)
                isFiltered = false
            }
        }
    }
}