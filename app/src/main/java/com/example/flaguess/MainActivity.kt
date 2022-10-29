package com.example.flaguess

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(R.layout.activity_main)

        val start = findViewById(R.id.start) as Button
        start.setOnClickListener{
            val name = findViewById(R.id.name) as EditText
            if(name.text.toString().isEmpty()){
                Toast.makeText(this,"Unesite Vaše ime",Toast.LENGTH_SHORT).show();
            }
            else{
                val intent = Intent(this, QuestionActivity::class.java)
                val name = findViewById(R.id.name) as EditText
                intent.putExtra(Constants.USERNAME,name.text.toString()
                )
                startActivity(intent)
                finish()
            }
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}