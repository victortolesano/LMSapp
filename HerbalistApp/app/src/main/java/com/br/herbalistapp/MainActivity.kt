package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.*
import com.br.herbalistapp.database.DatabaseManager
import com.br.herbalistapp.persistence.LoginPersistence
import com.br.herbalistapp.persistence.UserPersistence
import com.br.herbalistapp.services.UserService
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val usuarioCadastrado = savedInstanceState?.get("user") as UserPersistence?

        Log.d("k.silda usuario", usuarioCadastrado?.name + "")

        if (usuarioCadastrado == null) {
            val userLogado = LoginPersistence("", "").find()
            if (userLogado != null){
                val intent = Intent(this,
                    DrawerLayoutActivity::class.java)
                Toast.makeText(this,"bem-vindo de volta",Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        lms_app.setImageResource(R.drawable.lms_app)

        botao_login.setOnClickListener { onClickBotaoLogin() }
        botao_cadastrar.setOnClickListener { onClickBotaoCadastrar() }

        preencherLogin(usuarioCadastrado)
    }

    fun onClickBotaoLogin(){
        var username = findViewById<TextView>(R.id.campo_usuario)
        var password = findViewById<TextView>(R.id.campo_senha_login)
        var checkBox = findViewById<CheckBox>(R.id.campo_check_box)

        val valorUsuario = username.text.toString()
        val valorSenha = password.text.toString()

        val userRepository = DatabaseManager.getUserRepository()

        val user = userRepository.getByUsernameAndPassword(valorUsuario, valorSenha)

        if (user != null) {
            val intent = Intent(this,DrawerLayoutActivity::class.java)
            Toast.makeText(this,"logado, bem-vindo ${user.name}",Toast.LENGTH_SHORT).show()
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

    fun preencherLogin(user: UserPersistence?) {
        val usernameField = findViewById<TextView>(R.id.campo_usuario)
        val passwordField = findViewById<TextView>(R.id.campo_senha_login)

        usernameField.text = user?.name.orEmpty()
        passwordField.text = user?.password.orEmpty()
    }
}
