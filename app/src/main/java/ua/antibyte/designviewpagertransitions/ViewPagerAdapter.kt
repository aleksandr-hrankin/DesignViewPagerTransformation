package ua.antibyte.designviewpagertransitions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    private val listener: ClickListener
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {
    private val data: ArrayList<Int> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnDoubleClickListener {
            listener.onClick()
        }
    }

    override fun getItemCount() = data.size

    fun setData(data: List<Int>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView as ImageView

        fun bind(resId: Int) {
            imageView.setImageResource(resId)
        }
    }

    interface ClickListener {
        fun onClick()
    }
}