package com.rcapelli.catalogoonline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.rcapelli.catalogoonline.databinding.FragmentProductDetailBinding
import com.rcapelli.catalogoonline.models.ProductViewModel
import com.squareup.picasso.Picasso


class FrgProductDetail : Fragment() {

    private var _binding : FragmentProductDetailBinding? = null
    val binding get() = _binding!!
    private val viewModel : ProductViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentProductDetailBinding.inflate(layoutInflater,container,false)
        _binding = fragmentBinding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadLayout()
    }

    private fun loadLayout(){
        val prod = viewModel.getChosenProduct()!!
        Picasso.get()
            .load(prod.thumbnail)
            .error(R.mipmap.ic_launcher_round)
            .into(binding.imgDetail)
        binding.tvProdTitle.text = prod.title
        binding.tvProdPrice.text = getString(R.string.currency_pesos,prod.price.toString())
        if(prod.accepts_mercadopago){
            binding.swProdMp.isChecked = true
        }
        if(prod.condition == "new"){
            binding.swProdCondition.isChecked = true
        }
        binding.tvProdCurrency.text = prod.currency_id
        binding.tvProdCity.text = getString(R.string.coma,prod.address.city_name, prod.address.state_name)
    }
}