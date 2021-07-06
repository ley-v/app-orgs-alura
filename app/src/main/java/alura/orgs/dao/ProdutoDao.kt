package alura.orgs.dao

import alura.orgs.model.Produto

class ProdutoDao {

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodosOsProdutos(): List<Produto> {
        return produtos.toList()
    }
}