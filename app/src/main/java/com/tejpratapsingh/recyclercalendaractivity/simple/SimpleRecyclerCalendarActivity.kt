package com.tejpratapsingh.recyclercalendaractivity.simple

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.tejpratapsingh.recyclercalendar.adapter.SimpleRecyclerCalendarAdapter
import com.tejpratapsingh.recyclercalendar.model.RecyclerCalendarConfiguration
import com.tejpratapsingh.recyclercalendar.views.SimpleRecyclerCalendarView
import com.tejpratapsingh.recyclercalendaractivity.R
import java.util.*

class SimpleRecyclerCalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_recycler_calendar)

        val toolbar: Toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeButtonEnabled(true)

        val calenderView: SimpleRecyclerCalendarView = findViewById(R.id.calendarRecyclerView)

        val date = Date()
        date.time = System.currentTimeMillis()

        val startCal = Calendar.getInstance()

        val endCal = Calendar.getInstance()
        endCal.time = date
        endCal.add(Calendar.MONTH, 3)

        val configuration: RecyclerCalendarConfiguration =
            RecyclerCalendarConfiguration(
                calenderViewType = RecyclerCalendarConfiguration.CalenderViewType.VERTICAL,
                calendarLocale = Locale.UK,
                includeMonthHeader = true
            )

        calenderView.initialise(
            startCal.time,
            endCal.time,
            configuration,
            date,
            object : SimpleRecyclerCalendarAdapter.OnDateSelected {
                override fun onDateSelected(date: Date) {
                    Toast.makeText(calenderView.context, "Date Selected: ${date.toGMTString()}", Toast.LENGTH_LONG).show()
                }
            })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}