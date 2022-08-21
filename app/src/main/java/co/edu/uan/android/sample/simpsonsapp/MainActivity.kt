package co.edu.uan.android.sample.simpsonsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import co.edu.uan.android.sample.simpsonsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val simpsonNamesArray = mutableListOf<String>("marge","bart", "lisa")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // using binding
        setContentView(binding.root)

        binding.btnBart.setOnClickListener { changeSimpson("bart") }
        binding.btnHomer.setOnClickListener { changeSimpson("homer") }
        binding.btnMarge.setOnClickListener { changeSimpson("marge") }

        binding.radioBart.setOnClickListener { changeSimpson("bart") }
        binding.radioHomer.setOnClickListener { changeSimpson("homer") }
        binding.radioMarge.setOnClickListener { changeSimpson("marge") }

        // working with lists: managing the click event
        binding.simpsonsList.setOnItemClickListener { listView, view, index, _ ->
            changeSimpson(simpsonNamesArray[index])
            simpsonNamesArray.add("othersimpson")
            println("view: $view")
            // working with lists: notify the list the data has changed
            (listView.adapter as ArrayAdapter<String>).notifyDataSetChanged()
        }

        // workig with lists: creating a new adapter and assigning it to the list
        val adapter = SimpsonsListAdapter(
            this, // activity,
            R.layout.simpsons_list, // the layout you want to use,
            simpsonNamesArray // the data you want to show
        )
        binding.simpsonsList.adapter = adapter
    }

    private fun changeSimpson(simpsonName: String) {
        val simpsonImage = findViewById<ImageView>(R.id.simpsonImage)
        val imageId = resources.getIdentifier(simpsonName, "drawable", this.packageName)
        simpsonImage.setImageResource(imageId)

        val simpsonTitle = findViewById<TextView>(R.id.simpsonTitle)
        simpsonTitle.text = "$simpsonName Simpson"
    }
}