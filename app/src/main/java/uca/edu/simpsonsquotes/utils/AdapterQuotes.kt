package uca.edu.simpsonsquotes.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_quote.view.*
import uca.edu.simpsonsquotes.R
import uca.edu.simpsonsquotes.model.Quote

class AdapterQuotes () : RecyclerView.Adapter<AdapterQuotes.ViewHolder>() {
    lateinit var items: ArrayList<Quote>

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }

    }
    fun setQuotes(items: List<Quote>) {
        this.items = items as ArrayList<Quote>
        notifyDataSetChanged()
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false))

    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.quote.text = model.quote
        holder.character.text = model.character
        Picasso.get()
            .load(model.image)
            .into(holder.image)
    }
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val image: ImageView = view.iv_image
        val quote: TextView = view.tv_quote
        val character: TextView = view.tv_character
    }
}