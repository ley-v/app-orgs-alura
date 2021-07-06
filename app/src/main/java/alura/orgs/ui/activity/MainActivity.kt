package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.dao.ProdutoDao
import alura.orgs.model.Produto
import alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        setContentView(R.layout.activity_main)

        val dao = ProdutoDao()

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.adapter = ListaProdutosAdapter(this, dao.buscaTodosOsProdutos())
        recyclerview.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, FormularioProdutoActivity::class.java)
                startActivity(intent)
            }
        })
    }
}