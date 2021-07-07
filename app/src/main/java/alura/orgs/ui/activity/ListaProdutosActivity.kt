package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.dao.ProdutoDao
import alura.orgs.databinding.ActivityListaProdutosBinding
import alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity() {

    private val dao = ProdutoDao()
    private val adapter = ListaProdutosAdapter(this, dao.buscaTodosOsProdutos())

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodosOsProdutos())
    }

    private fun configuraFab() {
        val fab = binding.activityListaProdutosFab
        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                vaiParaFormularioProduto()
            }
        })
    }

    private fun vaiParaFormularioProduto() {
        val intent =
            Intent(this@ListaProdutosActivity, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerview = binding.activityListaProdutosRecyclerview
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}