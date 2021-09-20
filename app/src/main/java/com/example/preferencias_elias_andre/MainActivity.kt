package com.example.preferencias_elias_andre

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  sp = getSharedPreferences("my prefers", Context.MODE_PRIVATE)
        checkLogIn(sp)
        button.setOnClickListener{rememberUser(sp) }

    }
    private fun rememberUser(sp : SharedPreferences){

        val email = editTextTextEmailAddress.text.toString().trim()
        val pass = editTextTextPassword.text.toString().trim()
        val swich = switch1
        if (email.isNotEmpty() && pass.isNotEmpty()){

            if (swich.isChecked){
                with(sp.edit()){
                    putString("email", email)
                    putString("password", pass)
                    putString("active", "true")
                    putString("remember", "true")
                    apply()
                }
            } else {
                with(sp.edit()){
                    putString("active", "false")
                    putString("remember", "false")
                    apply()
                }

            }
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        } else {
            Toast.makeText(this, "Fallo ... Intentelo de nuevo", Toast.LENGTH_SHORT).show()
        }



    }
    private fun checkLogIn(sp: SharedPreferences){
        if (sp.getString("active","")=="true"){
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        } else {
            if (sp.getString("remember","")=="true"){
                editTextTextEmailAddress.setText(sp.getString("email",""))
                editTextTextPassword.setText(sp.getString("password",""))
            }
        }
    }
}