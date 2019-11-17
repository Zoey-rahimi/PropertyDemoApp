package com.zoey.propertydemoapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.zoey.propertydemoapp.R
import com.zoey.propertydemoapp.viewmodel.PropertyViewModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: PropertyViewModel
    private val propertyListAdapter = PropertyListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(PropertyViewModel::class.java)

        viewModel.refresh()

        propertyRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = propertyListAdapter
        }

        refreshLayout.setOnRefreshListener {
            propertyRecyclerView.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            listError.visibility = View.GONE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
        observeViewModel()
    }

    private fun observeViewModel() {

        viewModel.propertyList.observe(this, Observer { properties ->
            properties?.let {
                propertyRecyclerView.visibility = View.VISIBLE
                propertyListAdapter.updatePropertyList(properties)
            }
        })

        viewModel.loadingError.observe(this, Observer { isError ->
            isError?.let {
                listError.visibility = if (it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    listError.visibility = View.GONE
                    propertyRecyclerView.visibility = View.GONE
                }
            }
        })
    }
}
