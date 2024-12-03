package com.example.ejemplo_intent_explicito

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class segunda_actividad : AppCompatActivity() {
    lateinit var boton:Button
    lateinit var texto:TextView
    lateinit var miedittext:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda_actividad)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        this.boton=findViewById(R.id.button2)
        this.texto=findViewById(R.id.textView2)
        this.miedittext=findViewById(R.id.editTextText2)

        //Obtengo el intent
        var miintent=intent
        this.texto.text= intent.extras?.getString("clave").toString()


        this.boton.setOnClickListener {
            miintent= Intent()
            if(this.miedittext.text!=null) {
                miintent.putExtra("clave2", this.miedittext.text.toString())
            }
            else
                miintent.putExtra("clave2","yoquese")
            setResult(Activity.RESULT_OK,miintent)
            finish()
        }
    }
}