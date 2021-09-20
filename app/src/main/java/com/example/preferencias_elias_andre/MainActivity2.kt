package com.example.preferencias_elias_andre

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        cerrarsesion.setOnClickListener{logOut()}
    }
    private fun logOut(){
        val sp = getSharedPreferences("my prefers", Context.MODE_PRIVATE)
        with(sp.edit()){
            putString("active","false")
            apply()
        }
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}