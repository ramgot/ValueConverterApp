package ru.turing.firstLesson

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var converterMods: RadioGroup
    private lateinit var resultText: TextView
    private lateinit var inputValueText: EditText
    private lateinit var convertButton: Button
    private var isTemperatureMode: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputValueText = findViewById(R.id.text_before_converting)
        resultText = findViewById(R.id.text_after_converting)
        convertButton = findViewById(R.id.button_convert)
        converterMods = findViewById(R.id.radio_group)


        converterMods.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                if (isTemperatureMode) {
                    isTemperatureMode = !isTemperatureMode
                    inputValueText.hint = "Введите конвертируемое расстояние, м"
                    resultText.text = "Результат будет тут"
                } else {
                    isTemperatureMode = !isTemperatureMode
                    inputValueText.hint = "Введите конвертируемую температуру, °C"
                    resultText.text = "Результат будет тут"
                }
            }
        }

        convertButton.setOnClickListener { view ->
            convert()
        }
    }

    private fun convert() {
        resultText.text = ""
        var inputValue = inputValueText.text.toString().toDouble()
        if (isTemperatureMode) {
            inputValue += 273
        } else {
            inputValue /= 1000
        }
        resultText.text = inputValue.toString()
    }
}

