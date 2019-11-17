package com.zoey.propertydemoapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zoey.propertydemoapp.model.Property
import kotlinx.android.synthetic.main.property_item.view.*


class PropertyListAdapter(private val propertyList: ArrayList<Property>) :
    RecyclerView.Adapter<PropertyListAdapter.PropertyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(com.zoey.propertydemoapp.R.layout.property_item, parent, false)
        return PropertyViewHolder(view)
    }

    override fun getItemCount(): Int = propertyList.size

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val property = propertyList[position]

        Glide.with(holder.view)
            .load(property.imageUrls?.get(3))
            .centerCrop()
            .into(holder.view.property_image)

        Glide.with(holder.view)
            .load(property.owner?.image?.medium?.url)
            .centerCrop()
            .into(holder.view.property_owner_image)


        holder.view.property_price.text = String.format("$%s", property.displayPrice)
        holder.view.property_address1.text = property.location?.address
        holder.view.property_address2.text = property.location?.address2
        holder.view.property_owner_name.text =
            String.format("%s %s", property.owner?.name, property.owner?.lastName)
        holder.view.property_bedroom.text = "${property.bedrooms}"
        holder.view.property_parking.text = "${property.carspaces}"
        holder.view.property_bathroom.text = "${property.bathrooms}"

        holder.view.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment()
            action.propertyID = property.id.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updatePropertyList(newList: List<Property>) {
        propertyList.clear()
        propertyList.addAll(newList)
        notifyDataSetChanged()
    }

    class PropertyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}