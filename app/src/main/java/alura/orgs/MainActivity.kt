package alura.orgs

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "testando o Toast", Toast.LENGTH_SHORT).show()

        val view = TextView(this)
        view.setText("criando o primeiro layout dentro da activity")

        setContentView(view)

    }
}