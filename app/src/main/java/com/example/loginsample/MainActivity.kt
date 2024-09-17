package com.example.loginsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginsample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configuramos la vista con la debendencia viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Lo relacionamos con los layout creados en xml, por lo que deb coincidir con el nombre establecido
        val edtUsername = binding.edtUsername
        val edtPassword = binding.edtPassword
        val btnLogin = binding.btnLogin

        // Creacion de un evento para el login, donde el resultado se impromira por consola.
        btnLogin.setOnClickListener {
            //Si ponemos los campos de anera correcta, el mensaje por consola deberia ser de bienvenida
            if (edtUsername.text.toString() == "admin" && edtPassword.text.toString() == "admin") {
                Toast.makeText(applicationContext, "Bienvenido a mi App", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Bienvenido a mi App")
            } else {//de lo contrario sale error.
                Toast.makeText(applicationContext, "Error en la autenticación", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Error en la autenticación")
            }
        }

        //Añadimos la navegabilidad
        val btnRegistro = binding.txtRegister2

        btnRegistro.setOnClickListener{
            val intent : Intent = Intent(this, RegistroConference::class.java)
            startActivity(intent)
        }
    }
}