package com.br.herbalistapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

open class DebugActivity : AppCompatActivity() {

    private val TAG = "HerbalistApp"
    private val clasName: String get() {
        val s = javaClass.name
        return s.substring(s.lastIndexOf("."))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG,"${clasName}.onStar() Chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"${clasName} onRestar Chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"${clasName} onResume chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"${clasName} onPause chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"${clasName} onStop chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"${clasName} onDestroy chamado")
    }

    open fun onClick(v: View?) {}
}
