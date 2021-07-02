package com.example.aeon.mvvm.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aeon.R
import com.example.aeon.mvvm.viewmodels.ListVM
import com.example.aeon.utils.ListAdapter
import com.example.aeon.utils.VMFactory

class ListFragment: Fragment() {
    private lateinit var listVM: ListVM

    private lateinit var listView: RecyclerView
    private lateinit var adapter: ListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listView=view.findViewById(R.id.list)
        layoutManager= LinearLayoutManager(context)
        adapter= ListAdapter(ArrayList())
        listView.adapter=adapter
        listView.layoutManager=layoutManager

        val factory = VMFactory()
        val provider = ViewModelProvider(this, factory)
        listVM=provider.get(ListVM::class.java)
        observeData()
        listVM.getList()
    }

    private fun observeData(){
        listVM.liveData.observe(viewLifecycleOwner,{
            listVM.liveData.value?.let { it1 -> adapter.payments.addAll(it1) }
            adapter.notifyDataSetChanged()
        })
    }
}