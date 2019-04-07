package com.br.herbalistapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class TelaPerfilActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil)
        var params = intent.extras
        val nome = params.get("name")

        Toast.makeText(this,"${nome}", Toast.LENGTH_SHORT).show()
    }
}
