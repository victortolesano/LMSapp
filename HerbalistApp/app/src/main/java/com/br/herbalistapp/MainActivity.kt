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


        lms_app.setImageResource(R.drawable.lms_app)

        botao_login.setOnClickListener { onClickBotaoLogin() }
        botao_cadastrar.setOnClickListener { onClickBotaoCadastrar() }

    }

    fun onClickBotaoLogin(){
        val intent = Intent(this,TelaPerfilActivity::class.java)
//        intent.putExtra("nome","${R.id.campo_nome}")
        startActivity(intent)
    }

    fun onClickBotaoCadastrar(){
        val intent = Intent(this,TelaCadastroActivity::class.java)
        startActivity(intent)
    }

}
