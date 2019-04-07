package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)



        lms_app.setImageResource(R.drawable.lms2)

        botao_login.setOnClickListener {
            Toast.makeText(this,"clicou no botao",Toast.LENGTH_SHORT).show()
        }

        botao_cadastrar.setOnClickListener {
            Toast.makeText(this,"clicou no botao para cadastrar",Toast.LENGTH_SHORT).show()
        }

        botao_login.setOnClickListener { onClickBotao() }
        botao_cadastrar.setOnClickListener { onClickBotao() }

    }

    fun onClickBotao(){
        val intent = Intent(this,TelaPerfilActivity::class.java)
        startActivity(intent)
    }

}
