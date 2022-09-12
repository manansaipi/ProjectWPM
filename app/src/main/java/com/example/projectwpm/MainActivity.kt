package com.example.projectwpm

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var submitTextView: TextView

    private fun initComponent(){
        nameEditText = findViewById(R.id.nameEditText)
        submitButton = findViewById((R.id.submitButton))
        submitTextView = findViewById(R.id.submitTextView)
    }

    private fun checkFingerPrint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE","Available")
        }else{
            Log.w("FEATURE","Not Available")
        }
    }

    private fun checkPlatformVersion(){
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.S)
            Log.i("SDK", "Not Available Feauture bcs SDK feature is lower than 31")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_layout)

        initComponent()

        submitTextView.text = resources.getString(R.string.app_name)

         submitButton.setOnClickListener {

             checkFingerPrint()
             checkPlatformVersion()
             val sample = resources.openRawResource(R.raw.sample)
                 .bufferedReader()
                 .use { it.readText() }
             Log.i("RAW", sample)

             val json = assets.open("sample.json")
                 .bufferedReader()
                 .use { it.readText() }

             Log.i("ASSET", json)

//             resources.getDrawable((R.drawable.pzn), theme)

             Log.d("PZN", "debuh")
             Log.i("ValueResource",resources.getInteger(R.integer.maxPage).toString())

             submitButton.setBackgroundColor(resources.getColor(R.color.background, theme))

            val name = nameEditText.text.toString()
             Log.i("PZN", "info")
             Log.i("ValueResource",resources.getBoolean(R.bool.isProductionMode).toString())

             submitTextView.text = resources.getString(R.string.submitTextView, name)
             Log.w("PZN", "warning")
             Log.i("ValueResource",resources.getIntArray(R.array.number).joinToString(","))

             resources.getStringArray(R.array.names).forEach {
                 Log.i("PZN", it)
             }
             Log.e("PZN", "error")
             Log.i("ValueResource",resources.getColor(R.color.background, theme).toString())

         }
    }
}