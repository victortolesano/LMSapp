package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.cadastro.*
import kotlinx.android.synthetic.main.login.*

class TelaCadastroActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro)

//        botao_enviar_cadastro.setOnClickListener {
//            Toast.makeText(this,"cadastro enviado", Toast.LENGTH_SHORT).show()
//        }

//        var fl: FrameLayout = FrameLayout(this)
//
//        var param : FrameLayout.LayoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
//                                                                        FrameLayout.LayoutParams.MATCH_PARENT )
//        val text_view: TextView = TextView(this)
//        text_view.layoutParams = param
//        fl.layoutParams = param
//        text_view.setText("LOADING")
//        fl.addView(text_view)
//        setContentView(fl)
    }

    fun enviarCadastro(view: View){
        val fl:FrameLayout = findViewById(R.id.frame_layout_cadastrar)
        fl.visibility = view.visibility
    }
}
