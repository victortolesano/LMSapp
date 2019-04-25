package com.br.herbalistapp

import android.content.Intent
import android.os.Bundle
//import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_drawer_layout.*
import kotlinx.android.synthetic.main.app_bar_drawer_layout.*

class DrawerLayoutActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_layout)
        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // faz as ações dos click
        when (item.itemId) {
            R.id.nav_camera -> {
                // fazer as ações da camera aqui
                var intent = Intent(this, TelaImportarFotoActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Importar Foto",Toast.LENGTH_SHORT).show()
            }

            R.id.nav_config -> {
                var intent = Intent(this, TelaConfigActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"configurações",Toast.LENGTH_SHORT).show()

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}