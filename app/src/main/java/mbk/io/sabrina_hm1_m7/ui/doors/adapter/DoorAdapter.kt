package mbk.io.sabrina_hm1_m7.ui.doors.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import mbk.io.sabrina_hm1_m7.databinding.ItemCameraBinding
import mbk.io.sabrina_hm1_m7.model.DoorEntity
import mbk.io.sabrina_hm1_m7.model.DoorModel

class DoorAdapter(private val isDoor: Boolean) :
    ListAdapter<DoorEntity, DoorViewHolder>(DoorDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        return DoorViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), isDoor
        )

    }

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class DoorViewHolder(private var binding: ItemCameraBinding, private val isDoor: Boolean) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(camera: DoorEntity) = with(binding) {
        ivLock.visibility = if (isDoor) View.VISIBLE else View.GONE
        iv.load(camera.snapshot)
        tv.text = camera.name
        tv.setOnClickListener {
            if (binding.iv.visibility == View.GONE) {
                slideOutViews(binding.iv)
            } else {
                slideInViews(binding.iv)
            }
        }
    }

    private fun slideOutViews(view: View) {
        val duration = 500L

        view.apply {
            visibility = View.VISIBLE
            translationY = -height.toFloat()

            animate()
                .translationY(0f)
                .setDuration(duration)
                .start()
        }
    }


    private fun slideInViews(view: View) {
        val duration = 500L

        view.apply {
            animate()
                .translationY(-height.toFloat())
                .setDuration(duration)
                .withEndAction {
                    visibility = View.GONE
                    translationY = 0f
                }
                .start()
        }
    }
}

class DoorDiffUtil : DiffUtil.ItemCallback<DoorEntity>() {
    override fun areItemsTheSame(oldItem: DoorEntity, newItem: DoorEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DoorEntity, newItem: DoorEntity): Boolean {
        return oldItem == newItem
    }

}
