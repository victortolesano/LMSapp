package com.br.herbalistapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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


