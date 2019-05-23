package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.*
import com.br.herbalistapp.persistence.LoginPersistence
import com.br.herbalistapp.services.UserService
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

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
        var cpf = findViewById<TextView>(R.id.campo_cpf).text.toString()
        var password = findViewById<TextView>(R.id.campo_senha_login).text.toString()
        var checkBox = findViewById<CheckBox>(R.id.campo_check_box)
        val userService = UserService(cpf.toLong(), "", "", password)
        Thread {
            val valid = userService.isValid()

            runOnUiThread {
                if (valid) {
                    val intent = Intent(this,DrawerLayoutActivity::class.java)
                    Toast.makeText(this,"logado",Toast.LENGTH_SHORT).show()
                    if (checkBox.isChecked) {
                        val loginPersistence = LoginPersistence(cpf, password)
                        loginPersistence.save()
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this,
                        "senha:$password ou cpf $cpf não estão cadastrados, cadastre-se",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    fun onClickBotaoCadastrar(){
        val intent = Intent(this,TelaCadastroActivity::class.java)
        startActivity(intent)
    }

}
