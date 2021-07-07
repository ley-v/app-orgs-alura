package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.dao.ProdutoDao
import alura.orgs.databinding.ActivityFormularioProdutoBinding
import alura.orgs.model.Produto
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val dao = ProdutoDao()
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvar

        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = binding.activityFormularioProdutoNome
        val campoDescricao = binding.activityFormularioProdutoDescricao
        val campoValor = binding.activityFormularioProdutoValor
        val nome = campoNome.text.toString()
        val descricao = campoDescricao.text.toString()
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) BigDecimal.ZERO
        else BigDecimal(valorEmTexto)

        return Produto(nome, descricao, valor)
    }
}
