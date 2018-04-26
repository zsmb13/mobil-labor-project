package hu.bme.aut.stewe.rebrickableclient.ui.sets

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.LegoSet
import hu.bme.aut.stewe.rebrickableclient.ui.inflate
import hu.bme.aut.stewe.rebrickableclient.ui.loadFromUrl
import kotlinx.android.synthetic.main.item_set.view.*


class SetsAdapter(
        private var context: Context,
        private var clickListener: (LegoSet) -> Unit
) : RecyclerView.Adapter<SetsAdapter.SetsViewHolder>() {

    var content = mutableListOf<LegoSet>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetsViewHolder {
        val view = parent.inflate(context, R.layout.item_set)
        return SetsViewHolder(view)
    }

    override fun getItemCount(): Int = content.size

    override fun onBindViewHolder(holder: SetsViewHolder, position: Int) {
        val setList = content[position]
        holder.onBind(setList, clickListener)
    }

    fun refreshSets(setLists: List<LegoSet>) {
        content.clear()
        content.addAll(0, setLists)
        notifyDataSetChanged()
    }

    class SetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(legoSet: LegoSet, clickListener: (LegoSet) -> Unit) = with(itemView) {
            setItemName.text = legoSet.name
            setItemSetNumber.text = legoSet.setNum
            setItemImageIcon.loadFromUrl(legoSet.setImgUrl)
            setOnClickListener { clickListener(legoSet) }
        }
    }
}