package com.br.herbalistapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class TelaPerfilActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil)
        var params = intent.extras
        val nome = params.get("name")

        Toast.makeText(this,"${nome}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item?.itemId
        if (id == R.id.action_buscar){
            Toast.makeText(this,"buscar",Toast.LENGTH_SHORT).show()
        }

        if (id == R.id.action_atualizar){
            Toast.makeText(this,"atualizar",Toast.LENGTH_SHORT).show()
        }

        if (id == R.id.action_config){
            Toast.makeText(this,"configuração", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}
