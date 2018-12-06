package comvanderleitelesjr.github.triptogo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCalcular.setOnClickListener {
            calcular(btCalcular)
        }

        swIdaEVolta.setOnCheckedChangeListener { swIdaEVolta, isChecked ->
            calcular(swIdaEVolta)
        }
    }

    fun  calcular(sender:View){
        var distancia = tbDistancia.text.toString()
        var preco = tbPreco.text.toString()
        var autonomia = tbAutonomia.text.toString()

        if (distancia == "" || preco == "" || autonomia == ""){
            if (sender == btCalcular){
                Toast.makeText(this,"Preencha todos os campos!",Toast.LENGTH_SHORT).show()
            }
        }else{
            var valor = (distancia.toDouble()/autonomia.toDouble())*preco.toDouble()

            if (swIdaEVolta.isChecked) valor = valor*2

            lbValor.text = ("%.2f".format(valor))
        }

    }
}
