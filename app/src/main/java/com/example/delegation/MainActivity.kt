package com.example.delegation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lexusDelegation = LexusDelegation()
        val parentLexus = LexusParent()

        //lexus delegation
        myPrint(lexusDelegation.maxSpeed,"delegation car maxSpeed is")
        myPrint(lexusDelegation.getCarRating(),"delegation car rating is")
        myPrint()
        //lexus parent
        myPrint(lexusDelegation.maxSpeed,"parent car maxSpeed is")
        myPrint(parentLexus.getCarRating(),"parent car rating is")
    }


}

fun myPrint(value:Int? = null,message:String = ""){
    Log.i("++++++++++++++++++++++++++++++", "$message ${value?:""}")
}