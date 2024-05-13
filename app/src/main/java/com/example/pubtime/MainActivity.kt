package com.example.pubtime

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var checkBoxFootball: CheckBox
    private lateinit var checkBoxTennis: CheckBox
    private lateinit var checkBoxSpeedway: CheckBox
    private lateinit var listView: ListView
    private lateinit var buttonSearch: Button
    private lateinit var distanceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar = findViewById(R.id.seekBar)
        checkBoxFootball = findViewById(R.id.checkBox)
        checkBoxTennis = findViewById(R.id.checkBox2)
        checkBoxSpeedway = findViewById(R.id.checkBox3)
        listView = findViewById(R.id.listView)
        buttonSearch = findViewById(R.id.button)
        distanceTextView = findViewById(R.id.distance)

        listView.visibility = View.GONE
        listView.divider = ColorDrawable(ContextCompat.getColor(this, R.color.darkBlue))
        listView.dividerHeight = 1

        buttonSearch.setOnClickListener {
            listView.visibility = View.VISIBLE
            updateListView(seekBar.progress)
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                distanceTextView.text = "${progress}km"
                updateListView(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

    }

    private fun updateListView(distance: Int) {
        val pubs = mutableListOf<String>()

        when (distance) {
            0 -> pubs.add("Brak barów w zadanej odległości :(")
            5 -> {
                if (checkBoxFootball.isChecked) pubs.add("pub superBowl - mecze piłkarskie")
                if (checkBoxTennis.isChecked) pubs.add("pub superRakieta - mecze tenisa")
                if (checkBoxFootball.isChecked) pubs.add("pub JackRussel - mecze piłkarskie")
            }
            10 -> {
                if (checkBoxFootball.isChecked) pubs.add("pub superBowl - mecze piłkarskie")
                if (checkBoxTennis.isChecked) pubs.add("pub superRakieta - mecze tenisa")
                if (checkBoxFootball.isChecked) pubs.add("pub JackRussel - mecze piłkarskie")
                if (checkBoxFootball.isChecked) pubs.add("pub footballGame - mecze piłkarskie")
                if (checkBoxSpeedway.isChecked) pubs.add("pub Racing - zawody żużlowe")
                if (checkBoxTennis.isChecked) pubs.add("pub biforek - mecze tenisowe")
            }
            15 -> {
                if (checkBoxFootball.isChecked) pubs.add("pub superBowl - mecze piłkarskie")
                if (checkBoxTennis.isChecked) pubs.add("pub superRakieta - mecze tenisa")
                if (checkBoxFootball.isChecked) pubs.add("pub JackRussel - mecze piłkarskie")
                if (checkBoxFootball.isChecked) pubs.add("pub footballGame - mecze piłkarskie")
                if (checkBoxSpeedway.isChecked) pubs.add("pub Racing - zawody żużlowe")
                if (checkBoxTennis.isChecked) pubs.add("pub biforek - mecze tenisowe")
                if (checkBoxFootball.isChecked && checkBoxSpeedway.isChecked && checkBoxTennis.isChecked) pubs.add("pub ekstraGame - mecze piłkarskie, mecze tenisa, zawody żużlowe")
                if (checkBoxFootball.isChecked) pubs.add("pub Wilki, mecze piłkarskie")
            }
            20 -> {
                if (checkBoxFootball.isChecked) pubs.add("pub superBowl - mecze piłkarskie")
                if (checkBoxTennis.isChecked) pubs.add("pub superRakieta - mecze tenisa")
                if (checkBoxFootball.isChecked) pubs.add("pub JackRussel - mecze piłkarskie")
                if (checkBoxFootball.isChecked) pubs.add("pub footballGame - mecze piłkarskie")
                if (checkBoxSpeedway.isChecked) pubs.add("pub Racing - zawody żużlowe")
                if (checkBoxTennis.isChecked) pubs.add("pub biforek - mecze tenisowe")
                if (checkBoxFootball.isChecked && checkBoxSpeedway.isChecked && checkBoxTennis.isChecked) pubs.add("pub ekstraGame - mecze piłkarskie, mecze tenisa, zawody żużlowe")
                if (checkBoxFootball.isChecked) pubs.add("pub Wilki, mecze piłkarskie")
                if (checkBoxFootball.isChecked) pubs.add("pub dzikie Koty, mecze piłkarskie")
                if (checkBoxTennis.isChecked) pubs.add("pub czarno na białym - mecze tenisa")
            }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pubs)
        listView.adapter = adapter
    }

}