package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    val USERNAME = "aluno"
    val PASSWORD = "impacta"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        lms_app.setImageResource(R.drawable.lms_app)

        botao_login.setOnClickListener { onClickBotaoLogin() }
        botao_cadastrar.setOnClickListener { onClickBotaoCadastrar() }

    }

    fun onClickBotaoLogin(){
        var username = findViewById<TextView>(R.id.campo_usuario)
        var password = findViewById<TextView>(R.id.campo_senha_login)
        val valorUsuario = username.text.toString()
        val valorSenha = password.text.toString()

        if (valorUsuario.equals(USERNAME) && valorSenha.equals(PASSWORD)) {
            val intent = Intent(this,TelaPerfilActivity::class.java)
            Toast.makeText(this,"logado",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        else {
            // mensagem de erro
            Toast.makeText(this,
                            "senha:$valorSenha ou usuario $valorUsuario não estão cadastrados, cadastre-se",
                            Toast.LENGTH_SHORT).show()
        }

    }

    fun onClickBotaoCadastrar(){
        val intent = Intent(this,TelaCadastroActivity::class.java)
        startActivity(intent)
    }

}
