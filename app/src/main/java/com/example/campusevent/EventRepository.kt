package com.example.campusevent

object EventRepository {

    fun getEvents(): List<Event> {
        return listOf(
            Event("Lunar new Year", "March 10, 2026", "SUU Ballroom", R.drawable.event1),
            Event("Basketball Game", "March 15, 2026", "SUU Arena", R.drawable.event2),
            Event("Basketball Tournament", "March 26, 2026", "SUU Arena", R.drawable.event3)
        )
    }
}