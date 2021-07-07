package alura.orgs.ui.recyclerview.adapter

import alura.orgs.databinding.ProdutoItemBinding
import alura.orgs.model.Produto
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListaProdutosAdapter(
    val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolderL>() {

    private val dataset = produtos.toMutableList()

    class ViewHolderL(private val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun vincula(produto: Produto) {
            val nome = binding.produtoItemNome
            nome.text = produto.nome
            val descricao = binding.produtoItemDescricao
            descricao.text = produto.descricao
            val valor = binding.produtoItemValor
            valor.text = produto.valor.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderL {
        val inflador = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflador, parent, false)
        return ViewHolderL(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderL, position: Int) {
        val produto = dataset[position]
        holder.vincula(produto)

    }

    override fun getItemCount(): Int = dataset.size

    fun atualiza(produtos: List<Produto>) {
        this.dataset.clear()
        this.dataset.addAll(produtos)
        notifyDataSetChanged()

    }
}


