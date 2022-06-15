package com.example.praktikum1ppb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener {
            calculateVolume()

        }
    }

    private fun calculateVolume() {
        val inputLength = edtLength.text.toString().trim()
        val inputWidth = edtWidth.text.toString().trim()
        val inputHeight = edtHeight.text.toString().trim()

        var isEmptyFields = false;

        if (inputLength.isEmpty()) {
            isEmptyFields = true
            edtLength.error = "Field Panjang Tidak Boleh Kosong"
        }
        if (inputWidth.isEmpty()) {
            isEmptyFields = true
            edtWidth.error = "Field Lebar Tidak Boleh Kosong"
        }
        if (inputHeight.isEmpty()) {
            isEmptyFields = true
            edtHeight.error = "Field Tinggi Tidak Boleh Kosong"
        }

        if (isEmptyFields == false) {
            val volume = inputLength.toDouble() * inputHeight.toDouble() * inputWidth.toDouble()
            tvResult.text = volume.toString()
        }
    }
}