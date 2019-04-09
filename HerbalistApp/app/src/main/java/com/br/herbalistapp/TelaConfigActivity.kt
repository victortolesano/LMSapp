package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.configuracoes.*

class TelaConfigActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.configuracoes)

        configuracao_layout.setImageResource(R.drawable.configuracao_layout)

        botao_alterar_senha.setOnClickListener { onClickBotaoAlterarSenha() }

    }

    fun onClickBotaoAlterarSenha(){
        val intent = Intent(this,TelaAlterarSenhaActivity::class.java)
        Toast.makeText(this,"alterar senha", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

}


