package com.example.loginsample

import java.io.*
import  android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginsample.databinding.ActivityMainBinding
import com.example.loginsample.databinding.ActivityRegistroConferenceBinding

class RegistroConference : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroConferenceBinding
    private val filename = "datos.txt"
    private val TAG = "RegistroActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*enableEdgeToEdge()
        setContentView(R.layout.activity_registro_conference)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        binding = ActivityRegistroConferenceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnSaves = binding.btnSave
        val btnViews = binding.btnView

        btnSaves.setOnClickListener { saveData() }
        btnViews.setOnClickListener { readData() }
    }

    private fun saveData() {
        val edtName = binding.txtRegName.text.toString()
        val edtLastName = binding.txtRegApellido.text.toString()
        val edtEmail = binding.txtRegEmail.text.toString()
        val edtPhone = binding.txtRegTelefono.text.toString()
        val edtDate = binding.txtRegNacimiento.text.toString()

        // Crear el contenido a guardar
        val contenido = "Nombre: $edtName\nApellido: $edtLastName\nEmail: $edtEmail\nTelefono: $edtPhone\nFechaNacimiento: $edtDate"

        // Guardar en archivo de texto plano
        try {
            val fileOutputStream = openFileOutput(filename, MODE_PRIVATE)
            fileOutputStream.write(contenido.toByteArray())
            fileOutputStream.close()
            Log.d(TAG, "Datos guardados exitosamente")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun readData() {
        try {
            val fileInputStream: FileInputStream = openFileInput(filename)
            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder = StringBuilder()
            var texto: String?

            while (bufferedReader.readLine().also { texto = it } != null) {
                stringBuilder.append(texto).append("\n")
            }

            bufferedReader.close()

            // Mostrar el contenido leído en la consola con Log
            Log.d(TAG, "Datos leídos: \n$stringBuilder")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d(TAG, "Error al leer los datos")
        }
    }
}