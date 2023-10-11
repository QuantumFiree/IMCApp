package co.edu.udenar.victor.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class IMCCalculo : AppCompatActivity() {
    lateinit var textMCI: TextView
    lateinit var button: Button
    lateinit var inputWeight: EditText
    lateinit var inputHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculo)

        // Inicializar las referencias después de haber llamado setContentView
        textMCI = findViewById(R.id.textMCI)
        button = findViewById(R.id.button)
        inputWeight = findViewById(R.id.inputWeight)
        inputHeight = findViewById(R.id.inputHeight)

        // Agregar el OnClickListener al botón
        button.setOnClickListener {
            // Llamar a la función para calcular el IMC
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        val peso = inputWeight.text.toString().toFloatOrNull()
        val altura = inputHeight.text.toString().toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            textMCI.text = imc.toString()
        } else {
            textMCI.text = "Error en la entrada"
        }
    }
}
