import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcatalogue.R

class HorizontalImageAdapter(private val items: List<CatalogueItem>) :
    RecyclerView.Adapter<HorizontalImageAdapter.HorizontalImageViewHolder>() {

    class HorizontalImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.itemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal_image, parent, false)
        return HorizontalImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalImageViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageResId)
    }

    override fun getItemCount() = items.size
}
