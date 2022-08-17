package co.edu.uan.android.sample.simpsonsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import co.edu.uan.android.sample.simpsonsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBart.setOnClickListener { changeSimpson("bart") }
        binding.btnHomer.setOnClickListener { changeSimpson("homer") }
        binding.btnMarge.setOnClickListener { changeSimpson("marge") }

        binding.radioBart.setOnClickListener { changeSimpson("bart") }
        binding.radioHomer.setOnClickListener { changeSimpson("homer") }
        binding.radioMarge.setOnClickListener { changeSimpson("marge") }

        binding.simpsonsList.setOnItemClickListener { listView, view, index, viewId ->
            when(index) {
                0 -> changeSimpson("bart")
                else -> changeSimpson("lisa")
            }
        }
    }

    private fun changeSimpson(simpsonName: String) {
        val simpsonImage = findViewById<ImageView>(R.id.simpsonImage)
        val imageId = resources.getIdentifier(simpsonName, "drawable", this.packageName)
        simpsonImage.setImageResource(imageId)

        val simpsonTitle = findViewById<TextView>(R.id.simpsonTitle)
        simpsonTitle.text = "$simpsonName Simpson"


    }
}