import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.dailytodo.Note
import com.example.dailytodo.R
import com.example.dailytodo.databinding.RowItemBinding

class Adapter(context: Context, resource: Int, notes: List<Note>) :
    ArrayAdapter<Note>(context, resource, notes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val note = getItem(position)
        val binding = convertView?.let { RowItemBinding.bind(it) }
            ?: RowItemBinding.inflate(LayoutInflater.from(context), parent, false)

        binding.itemTitle.text = note?.noteTitle
        binding.itemDetails.text = note?.noteDetail
        binding.dateTextView.text = note?.dueDate

        // Calculate the background color based on position
        val colorResId = when (position % 5) {
            0 -> R.color.color1
            1 -> R.color.color2
            2 -> R.color.color3
            3 -> R.color.color4
            else -> R.color.color5
        }
        binding.root.setBackgroundResource(colorResId)

        return binding.root
    }
}