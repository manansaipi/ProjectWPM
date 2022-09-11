package com.example.projectwpm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_layout)

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val submitButton: Button = findViewById((R.id.submitButton))
        val submitTextView: TextView = findViewById(R.id.submitTextView)

        submitTextView.text = "Hi"

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            submitTextView.text = "Hi $name"
        }
    }
}