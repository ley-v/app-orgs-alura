package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.dao.ProdutoDao
import alura.orgs.model.Produto
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = ProdutoDao()
        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        val campoNome = findViewById<EditText>(R.id.nome)
        val campoDescricao = findViewById<EditText>(R.id.descricao)
        val campoValor = findViewById<EditText>(R.id.valor)
        botaoSalvar.setOnClickListener {
            val nome = campoNome.text.toString()
            val descricao = campoDescricao.text.toString()
            val valorEmTexto = campoValor.text.toString()
            val valor = if (valorEmTexto.isBlank()) BigDecimal.ZERO
            else BigDecimal(valorEmTexto)

            val produtoNovo = Produto(nome, descricao, valor)

            dao.adiciona(produtoNovo)
            Log.i("FormularioProdutoAdd", "onCreate: $produtoNovo")
            Log.i("FormularioProdutoArray", "onCreate: ${dao.buscaTodosOsProdutos()}")

            finish()
        }
    }
}
