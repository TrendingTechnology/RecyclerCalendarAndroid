package com.tejpratapsingh.recyclercalendar.views

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.tejpratapsingh.recyclercalendar.adapter.SimpleRecyclerCalendarAdapter
import com.tejpratapsingh.recyclercalendar.model.RecyclerCalendarConfiguration
import java.util.*

class SimpleRecyclerCalendarView : RecyclerView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun initialise(
        startDate: Date,
        endDate: Date,
        configuration: RecyclerCalendarConfiguration,
        selectedDate: Date,
        dateSelectListener: SimpleRecyclerCalendarAdapter.OnDateSelected
    ) {
        val simpleRecyclerCalendarView: SimpleRecyclerCalendarAdapter =
            SimpleRecyclerCalendarAdapter(
                startDate = startDate,
                endDate = endDate,
                configuration = configuration,
                selectedDate = selectedDate,
                dateSelectListener = dateSelectListener
            )

        adapter = simpleRecyclerCalendarView
    }
}