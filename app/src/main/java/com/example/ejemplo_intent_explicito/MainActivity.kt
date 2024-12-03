package com.example.ejemplo_intent_explicito

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var boton:Button
    lateinit var texto:EditText
    lateinit var texto4:TextView
    var milauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        dato:ActivityResult->
        if(dato.resultCode== Activity.RESULT_OK)
        {

            //Obtengo el dato
            texto4.text=dato.data?.extras?.getString("clave2")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        texto4=findViewById(R.id.textView4)
        boton=findViewById<Button>(R.id.button)
        texto=findViewById(R.id.editTextText)
        boton.setOnClickListener {
            var intent= Intent(this,segunda_actividad::class.java)
            var bundle=Bundle()
            bundle.putString("clave",((texto.text?:"").toString()))
            intent.putExtras(bundle)
            //startActivity(intent)
            milauncher.launch(intent)
        }
    }
}