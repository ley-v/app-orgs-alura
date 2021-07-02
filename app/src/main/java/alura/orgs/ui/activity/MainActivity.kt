package alura.orgs.ui.activity

import alura.orgs.R
import alura.orgs.model.Produto
import alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.adapter = ListaProdutosAdapter(
            this, listOf(
                Produto(
                    "nome0",
                    "descrição0",
                    BigDecimal("9.99")
                ),
                Produto(
                    "nome1",
                    "descrição1",
                    BigDecimal("19.99")
                ),
                Produto(
                    "nome2",
                    "descrição2",
                    BigDecimal("29.99")
                )
            )
        )
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}