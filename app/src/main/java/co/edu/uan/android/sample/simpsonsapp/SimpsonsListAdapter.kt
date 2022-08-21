package co.edu.uan.android.sample.simpsonsapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import co.edu.uan.android.sample.simpsonsapp.databinding.SimpsonsListBinding

/**
 * Your new adapter for the simpsons ListView.
 * It extends ArrayAdapter and overwrites the getView method
 * also receives three parameters in the constructor: activity, layout, and data
 */
class SimpsonsListAdapter(val activity: Activity, val layout: Int, val data: List<String>)
    : ArrayAdapter<String>(activity, layout, data) {
    /**
     * The getView method is called once per element in the data array,
     * creating a new view by using the layout you have provided.
     * @param position is the index of the element in the data array to be shown
     * @param covertView is the currentView for that element (usually null)
     * @param parent is the parant view for the view to be created
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 1. inflate/create your new view from the layout using the activity's layout inflater
        val binding = SimpsonsListBinding.inflate(activity.layoutInflater)
        // 2. populate your view with the data
        binding.simpsonName.text = data[position]
        val imageId = activity.resources.getIdentifier(data[position], "drawable", activity.packageName)
        binding.simpsonIcon.setImageResource(imageId)
        return binding.root
    }
}