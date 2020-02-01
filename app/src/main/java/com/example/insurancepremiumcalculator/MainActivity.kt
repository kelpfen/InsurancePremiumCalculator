package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  myData : totalPremiumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(totalPremiumViewModel::class.java)

        display()

        btn_calc.setOnClickListener()
        {
            myData.premiumAmount = calculatePremium()
            display()
            //val totalPremium: Double = calculatePremium()
            //txt_totalPremium.text = "%.2f".format(totalPremium)
        }
        btn_reset.setOnClickListener(){
            radioButton_female.isChecked = false;
            radioButton_male.isChecked = false;
            checkBox_smoker.isChecked = false;
            spinner_age.setSelection(0);
            myData.premiumAmount = 0.0
            //....

        }
    }
    fun display(){
        if(myData.premiumAmount != 0.0)
        txt_totalPremium.text = myData.premiumAmount.toString()
    }
    fun calculatePremium():Double{

        return when(spinner_age.selectedItemPosition) {
            0 -> 60.00
            1 -> 70.00 +
                    (if (radioButton_male.isChecked) 50.00 else 0.00) +
                    (if (checkBox_smoker.isChecked) 100.00 else 0.00)
            2 -> 90.00 +
                    (if (radioButton_male.isChecked) 100.00 else 0.00) +
                    (if (checkBox_smoker.isChecked) 150.00 else 0.00)
            3 -> 120.00 +
                    (if (radioButton_male.isChecked) 150.00 else 0.00) +
                    (if (checkBox_smoker.isChecked) 200.00 else 0.00)
            4 -> 150.00 +
                    (if (radioButton_male.isChecked) 200.00 else 0.00) +
                    (if (checkBox_smoker.isChecked) 250.00 else 0.00)
            5 -> 150.00 +
                    (if (radioButton_male.isChecked) 200.00 else 0.00) +
                    (if (checkBox_smoker.isChecked) 300.00 else 0.00)

            else ->  150.0
        }


    }

}
