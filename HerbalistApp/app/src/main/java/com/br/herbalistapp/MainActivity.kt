package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.*
import com.br.herbalistapp.persistence.LoginPersistence
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    val USERNAME = "aluno"
    val PASSWORD = "impacta"



    override fun onCreate(savedInstanceState: Bundle?) {
        val userLogado = LoginPersistence("", "").find()
        if (userLogado != null){
            val intent = Intent(this,
                DrawerLayoutActivity::class.java)
            Toast.makeText(this,"logado",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        lms_app.setImageResource(R.drawable.lms_app)



        botao_login.setOnClickListener { onClickBotaoLogin() }
        botao_cadastrar.setOnClickListener { onClickBotaoCadastrar() }

    }

    fun onClickBotaoLogin(){
        var username = findViewById<TextView>(R.id.campo_usuario)
        var password = findViewById<TextView>(R.id.campo_senha_login)
        var checkBox = findViewById<CheckBox>(R.id.campo_check_box)
        val valorUsuario = username.text.toString()
        val valorSenha = password.text.toString()

        if (valorUsuario.equals(USERNAME) && valorSenha.equals(PASSWORD)) {
            val intent = Intent(this,DrawerLayoutActivity::class.java)
            Toast.makeText(this,"logado",Toast.LENGTH_SHORT).show()
            if (checkBox.isChecked) {
                val loginPersistence = LoginPersistence(valorUsuario, valorSenha)
                loginPersistence.save()
            }
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
