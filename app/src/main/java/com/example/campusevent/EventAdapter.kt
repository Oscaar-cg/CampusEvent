package com.example.campusevent

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val eventList: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.eventImage)
        val title: TextView = itemView.findViewById(R.id.eventTitle)
        val date: TextView = itemView.findViewById(R.id.eventDate)
        val location: TextView = itemView.findViewById(R.id.eventLocation)
        val button: Button = itemView.findViewById(R.id.detailsButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

        val currentEvent = eventList[position]

        holder.title.text = currentEvent.title
        holder.date.text = currentEvent.date
        holder.location.text = currentEvent.location
        holder.image.setImageResource(currentEvent.imageResId)

        holder.button.setOnClickListener {

            val context = holder.itemView.context
            val intent = Intent(context, EventDetailActivity::class.java)

            intent.putExtra("title", currentEvent.title)
            intent.putExtra("date", currentEvent.date)
            intent.putExtra("location", currentEvent.location)
            intent.putExtra("image", currentEvent.imageResId)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return eventList.size
    }
}