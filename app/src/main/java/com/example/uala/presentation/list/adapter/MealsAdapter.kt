package com.example.uala.presentation.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.uala.R
import com.example.uala.commons.BaseAdapter
import com.example.uala.commons.BindingViewHolder
import com.example.uala.databinding.SnippetMealBinding
import com.example.uala.domain.MealResponse
import com.squareup.picasso.Picasso

class MealsAdapter  (rv: RecyclerView, val clickListener: ThumbnailListener) : BaseAdapter<MealResponse, SnippetMealBinding>(rv, R.layout.snippet_meal) {

    class ThumbnailListener(val clickListener: (item: MealResponse) -> Unit) {
        fun onClick(item: MealResponse) = clickListener(item)
    }

    override fun populateBindViewHolder(
        holder: BindingViewHolder<SnippetMealBinding>?,
        item: MealResponse?,
        position: Int
    ) {
        if (holder != null && holder.binding != null && item != null) {
            Picasso.get()
                .load(item.strMealThumb)
                .error(R.drawable.ic_baseline_not_interested_24)
                .placeholder(R.drawable.ic_baseline_not_interested_24)
                .into(holder.binding.imageView)
            holder.binding.nombre.text = item.strMeal
            holder.binding.categoria.text = item.strCategory
            holder.binding.imageView.setOnClickListener {
                clickListener.clickListener(item)
            }
        }
    }

    override fun compareItems(itemA: MealResponse?, itemB: MealResponse?): Boolean {
        if (itemA != null && itemB != null) {
            return itemA.idMeal == itemB.idMeal
        }
        return false
    }

    override fun compareItemsContent(itemA: MealResponse?, itemB: MealResponse?): Boolean {
        if (itemA != null && itemB != null) {
            return itemA.strMeal.equals(itemB.strMeal)
        }
        return false
    }


}