package com.agicent.mvvmdemo.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.agicent.mvvmdemo.R
import com.agicent.mvvmdemo.databinding.RecyclerAddressBinding
import com.agicent.mvvmdemo.model.UserResponseAddress
import com.agicent.mvvmdemo.viewmodel.RecyclerAddressViewModel
import java.util.ArrayList

class AddressAdapter() : RecyclerView.Adapter<AddressAdapter.MyViewHolder>() {
    private var addresslist: ArrayList<UserResponseAddress> ? = null
    private  var layoutInflater: LayoutInflater?=null

    init {
        addresslist= ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressAdapter.MyViewHolder {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.context)
        val binding : RecyclerAddressBinding = layoutInflater.let { DataBindingUtil.inflate(layoutInflater!!, R.layout.recycler_address, parent, false) }
        return AddressAdapter.MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return addresslist!!.size
    }

    override fun onBindViewHolder(holder: AddressAdapter.MyViewHolder, position: Int) {
        val addressResponse : UserResponseAddress =addresslist!!.get(position)
        val address_two=if(addressResponse.address2.equals(""))  "" else  addressResponse.address2+", "
        val completeAddress : String =addressResponse?.address1+", "+address_two+addressResponse?.city+", "+addressResponse?.pincode+", "+addressResponse?.state+", "+addressResponse?.land_mark
        holder.binding.addressViewModel= RecyclerAddressViewModel(completeAddress)
    }

    fun update(allAddresses: ArrayList<UserResponseAddress>) {
        if ( allAddresses?.isEmpty())
            this.addresslist?.clear()
        else
            this.addresslist?.addAll(allAddresses)
        notifyDataSetChanged()

    }

    class MyViewHolder(var binding: RecyclerAddressBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}