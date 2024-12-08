package com.example.ebook

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var loadButton: Button
    private lateinit var bookTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadButton = findViewById(R.id.loadButton)
        bookTextView = findViewById(R.id.bookTextView)

        loadButton.setOnClickListener {
            val bookText = Database.text
            val wordList = loadBook(bookText)
            bookTextView.text = wordList.joinToString(" ")
        }
    }

    private fun loadBook(text: String): List<String> {
        return text.split("\\s+".toRegex())
    }
}