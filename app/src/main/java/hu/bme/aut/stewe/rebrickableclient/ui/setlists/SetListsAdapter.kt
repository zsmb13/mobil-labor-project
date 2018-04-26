package hu.bme.aut.stewe.rebrickableclient.ui.setlists

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.network.swagger.model.SetList
import hu.bme.aut.stewe.rebrickableclient.ui.inflate
import kotlinx.android.synthetic.main.item_setlist.view.*


class SetListsAdapter(
        var context: Context,
        var clickListener: (SetList) -> Unit
) : RecyclerView.Adapter<SetListsAdapter.SetListViewHolder>() {

    var content = mutableListOf<SetList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetListViewHolder {
        val view = parent.inflate(context, R.layout.item_setlist)
        return SetListViewHolder(view)
    }

    override fun getItemCount(): Int = content.size

    override fun onBindViewHolder(holder: SetListViewHolder, position: Int) {
        val setList = content[position]
        holder.onBind(setList, clickListener)
    }

    fun refreshSetLists(setLists: List<SetList>) {
        content.clear()
        content.addAll(0, setLists)
        notifyDataSetChanged()
    }

    class SetListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(setList: SetList, clickListener: (SetList) -> Unit) = with(itemView) {
            setListItemName.text = setList.name
            setListItemSetNumber.text = setList.numSets.toString()
            setOnClickListener { clickListener(setList) }
        }
    }
}