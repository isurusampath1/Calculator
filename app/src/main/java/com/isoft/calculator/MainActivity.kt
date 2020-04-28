package com.isoft.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.isoft.calculator.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var operation: String = ""
    private var value1: Double = 0.0
    private var value2: Double = 0.0
    private var finalResult: Double = 0.0
    private lateinit var stringBuilder: StringBuilder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        stringBuilder = StringBuilder()


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btn0.setOnClickListener{btnClick(binding.btn0)}
        binding.btn1.setOnClickListener{btnClick(binding.btn1)}
        binding.btn2.setOnClickListener{btnClick(binding.btn2)}
        binding.btn3.setOnClickListener{btnClick(binding.btn3)}
        binding.btn4.setOnClickListener{btnClick(binding.btn4)}
        binding.btn5.setOnClickListener{btnClick(binding.btn5)}
        binding.btn6.setOnClickListener{btnClick(binding.btn6)}
        binding.btn7.setOnClickListener{btnClick(binding.btn7)}
        binding.btn8.setOnClickListener{btnClick(binding.btn8)}
        binding.btn9.setOnClickListener{btnClick(binding.btn9)}
        binding.btnDeci.setOnClickListener{btnClick(binding.btnDeci)}

        binding.btnMulti.setOnClickListener { btnMaths(binding.btnMulti) }
        binding.btnAdd.setOnClickListener { btnMaths(binding.btnAdd) }
        binding.btnSub.setOnClickListener { btnMaths(binding.btnSub) }
        binding.btnDevision.setOnClickListener { btnMaths(binding.btnDevision) }

        binding.btnEql.setOnClickListener { btnEqual() }
        binding.btnClear.setOnClickListener { btnClick(binding.btnClear) }
        binding.btnDelete.setOnClickListener { btnClick(binding.btnDelete) }
    }

    fun btnClick(view:View){
        var value = binding.idResult.text.toString()
        when(view.id){
            binding.btn0.id -> {
                value += "0"
                stringBuilder.append("0")
            }
            binding.btn1.id -> {
                value += "1"
                stringBuilder.append("1")
            }
            binding.btn2.id -> {
                value += "2"
                stringBuilder.append("2")
            }
            binding.btn3.id -> {
                value += "3"
                stringBuilder.append("3")
            }
            binding.btn4.id -> {
                value += "4"
                stringBuilder.append("4")
            }
            binding.btn5.id -> {
                value += "5"
                stringBuilder.append("5")
            }
            binding.btn6.id -> {
                value += "6"
                stringBuilder.append("6")
            }
            binding.btn7.id -> {
                value += "7"
                stringBuilder.append("7")
            }
            binding.btn8.id -> {
                value += "8"
                stringBuilder.append("8")
            }
            binding.btn9.id -> {
                value += "9"
                stringBuilder.append("9")
            }
            binding.btnDeci.id -> {
                value += "."
                stringBuilder.append(".")
            }
            binding.btnClear.id -> {
                value = ""
                stringBuilder.clear()
            }
            binding.btnDelete.id -> {
                value = binding.idResult.text.toString()
                if (value.length > 0) {
                    value = value.substring(0, value.length - 1)
                }
                if (stringBuilder.length > 0){
                    stringBuilder.deleteCharAt(stringBuilder.length - 1)
                    //binding.lbResult.text = stringBuilder
                }
            }
        }
        binding.idResult.setText(value)

        //stringBuilder.append(value)
        binding.lbResult.text = stringBuilder
    }

    fun btnMaths(view: View){
        when(view.id){
            binding.btnMulti.id -> {
                operation = "*"
            }
            binding.btnAdd.id -> {
                operation = "+"
            }
            binding.btnSub.id -> {
                operation = "-"
            }
            binding.btnDevision.id -> {
                operation = "/"
            }

        }
        val value = binding.idResult.text.toString()
        value1 = value.toDouble()
        binding.idResult.text.clear()

        stringBuilder.append(operation)
        binding.lbResult.text = stringBuilder
    }

    fun btnEqual (){
        val value = binding.idResult.text.toString()
        value2 = value.toDouble()
        when(operation){
            "*" -> {
                finalResult = value1 * value2
            }
            "/" -> {
                finalResult = value1 / value2
            }
            "+" -> {
                finalResult = value1 + value2
            }
            "-" -> {
                finalResult = value1 - value2
            }

        }
        binding.idResult.setText(finalResult.toString())
        stringBuilder.append(" =")
        stringBuilder.append(finalResult)
        binding.lbResult.text = stringBuilder
    }
}
