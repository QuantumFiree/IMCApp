package co.edu.udenar.victor.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.graphics.Color


class IMCCalculo : AppCompatActivity() {
    lateinit var textMCI: TextView
    lateinit var textMCIrecomended: TextView
    lateinit var button: Button
    lateinit var inputWeight: EditText
    lateinit var inputHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculo)

        // Inicializar las referencias después de haber llamado setContentView
        textMCI = findViewById(R.id.textMCI)
        textMCIrecomended = findViewById(R.id.textMCIrecomended)
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
            val imc = peso / Math.pow(altura.toDouble(), 2.0)

            //val imc = peso / (altura * altura)
            val imccut = String.format("%.2f", imc)
            textMCI.text = imccut.toString()

            val diagnostico = when {
                imc < 18.5 -> "Bajo Peso"
                imc < 24.9 -> "Normal"
                imc < 29.9 -> "Sobrepeso"
                else -> "Obesidad"
            }

            if(diagnostico == "Bajo peso"){
                textMCIrecomended.setTextColor(Color.parseColor("#FF0000"))
            }else if(diagnostico == "Normal") {
                textMCIrecomended.setTextColor(Color.parseColor("#2EFE2E"))

            }else {
                textMCIrecomended.setTextColor(Color.parseColor("#FF0000"))

            }

            textMCIrecomended.text = diagnostico
        } else {
            textMCI.text = "Error en la entrada"
        }


    }
}
