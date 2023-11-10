package ru.turing.firstLesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private lateinit var radioButton: RadioButton
    private lateinit var radioGroup: RadioGroup
    private lateinit var textView: TextView
    private lateinit var plainText: EditText
    private lateinit var button: Button
    var isTemperatureMode: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plainText = findViewById<EditText>(R.id.text_before_converting)
        textView = findViewById<TextView>(R.id.text_after_converting)
        button = findViewById<Button>(R.id.button_convert)
        radioGroup = findViewById<RadioGroup>(R.id.radio_group)


        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                if (isTemperatureMode) {
                    isTemperatureMode = !isTemperatureMode
                    plainText.hint = "Введите конвертируемое расстояние, м"
                    textView.text = "Результат будет тут"
                } else {
                    isTemperatureMode = !isTemperatureMode
                    plainText.hint = "Введите конвертируемую температуру, °C"
                    textView.text = "Результат будет тут"
                }
            }
        }

        button.setOnClickListener{view ->
            convert()
        }
    }

    private fun convert() {
        textView.text = ""
        try {
            var input = plainText.text.toString().toDouble()
            if (isTemperatureMode) {
                input += 273
            } else {
                input /= 1000
            }
            textView.text = input.toString()
        }
        catch (e: Exception) {
            textView.text = "Некорректный формат ввода!"
        }
    }
}

