package com.zoey.propertydemoapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zoey.propertydemoapp.databinding.PropertyItemBinding
import com.zoey.propertydemoapp.model.Property


class PropertyListAdapter(
    private val propertyList: ArrayList<Property>
    , private val onPropertyClickListener: PropertyClickListener
) :
    RecyclerView.Adapter<PropertyListAdapter.PropertyViewHolder>(), PropertyClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: PropertyItemBinding = DataBindingUtil.inflate(
            inflater,
            com.zoey.propertydemoapp.R.layout.property_item,
            parent,
            false
        )
        return PropertyViewHolder(view)
    }

    override fun getItemCount(): Int = propertyList.size

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        holder.view.property = propertyList[position]
        holder.view.listener = this
    }

    override fun onPropertyClicked(view: View) {
        onPropertyClickListener.onPropertyClicked(view)
    }

    fun updatePropertyList(newList: List<Property>) {
        propertyList.clear()
        propertyList.addAll(newList)
        notifyDataSetChanged()
    }

    class PropertyViewHolder(val view: PropertyItemBinding) : RecyclerView.ViewHolder(view.root)
}