package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

        cad_botao_enviar_cadastro.setOnClickListener {
            onClickEnviarCadastro()
        }

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

    fun onClickEnviarCadastro() {
        var nome = findViewById<TextView>(R.id.cad_nome)
        var email = findViewById<TextView>(R.id.cad_campo_Email)
        var cpf = findViewById<TextView>(R.id.campo_cpf)
        var senha = findViewById<TextView>(R.id.cad_campo_senha)
    }

    fun enviarCadastro(view: View){
        val fl:FrameLayout = findViewById(R.id.frame_layout_cadastrar)
        fl.visibility = view.visibility
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // adiciona itens na barra de ação
        menuInflater.inflate(R.menu.drawer_layout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        var id = item?.itemId

        if (id == R.id.action_sair){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Saindo", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}