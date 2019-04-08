package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.cadastro.*
import kotlinx.android.synthetic.main.login.*

class TelaCadastroActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro)

        botao_enviar_cadastro.setOnClickListener {
            Toast.makeText(this,"clicou no botao para cadastrar", Toast.LENGTH_SHORT).show()
        }
    }
}
