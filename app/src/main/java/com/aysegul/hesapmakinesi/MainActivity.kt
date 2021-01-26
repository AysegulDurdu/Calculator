package com.aysegul.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var yeniIslem = true
    var eskiSayi = ""
    var operator = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayiClick(view: View){
        if (yeniIslem)
            sonucText.setText("")
        yeniIslem = false
        var tiklananButton = sonucText.text.toString()
        var secilenButton = view as Button
        when(secilenButton.id){
            button0.id -> {tiklananButton += "0"}
            button1.id -> {tiklananButton += "1"}
            button2.id -> {tiklananButton += "2"}
            button3.id -> {tiklananButton += "3"}
            button4.id -> {tiklananButton += "4"}
            button5.id -> {tiklananButton += "5"}
            button6.id -> {tiklananButton += "6"}
            button7.id -> {tiklananButton += "7"}
            button8.id -> {tiklananButton += "8"}
            button9.id -> {tiklananButton += "9"}
            buttonNegative.id -> {tiklananButton = "-$tiklananButton"}
        }
        sonucText.setText(tiklananButton)
    }

    fun islemClick(view: View){
        yeniIslem = true
        eskiSayi = sonucText.text.toString()
        var secilenButton = view as Button
        when(secilenButton.id){
            buttonDiv.id -> {operator = "/"}
            buttonMul.id -> {operator = "x"}
            buttonSub.id -> {operator = "-"}
            buttonAdd.id -> {operator = "+"}
        }
    }

    fun equalClick(view: View){
        var yeniSayi = sonucText.text.toString()
        var sonuc = 0.0
        when(operator){
            "/" -> {sonuc = eskiSayi.toDouble() / yeniSayi.toDouble()}
            "x" -> {sonuc = eskiSayi.toDouble() * yeniSayi.toDouble()}
            "-" -> {sonuc = eskiSayi.toDouble() - yeniSayi.toDouble()}
            "+" -> {sonuc = eskiSayi.toDouble() + yeniSayi.toDouble()}
        }
        sonucText.setText(sonuc.toString())
        yeniIslem = true
    }

    fun acClick(view: View){
        sonucText.setText("0")
        yeniIslem = true
    }
}