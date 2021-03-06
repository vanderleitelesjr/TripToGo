package comvanderleitelesjr.github.triptogo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMaps.setOnClickListener {
            val intent = Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }

        btCalcular.setOnClickListener {
            calcular(btCalcular)
        }

        swIdaEVolta.setOnCheckedChangeListener { swIdaEVolta, isChecked ->
            calcular(swIdaEVolta)
        }
    }

    fun  calcular(sender:View){
        val distancia = tbDistancia.text.toString()
        val preco = tbPreco.text.toString()
        val autonomia = tbAutonomia.text.toString()

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
