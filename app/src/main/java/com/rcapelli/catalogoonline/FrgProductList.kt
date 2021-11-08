package com.rcapelli.catalogoonline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rcapelli.catalogoonline.adapters.ProductsAdapter
import com.rcapelli.catalogoonline.databinding.FragmentProductListBinding
import com.rcapelli.catalogoonline.models.ProductViewModel


class FrgProductList : Fragment() {

    private var _binding : FragmentProductListBinding? = null
    private val binding get() = _binding!!
    private val viewModel : ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentProductListBinding.inflate(layoutInflater,container,false)
        _binding = fragmentBinding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadRecycler()
    }

    private fun loadRecycler(){
        val products = viewModel.getProducts()
        binding.productlistRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.productlistRecycler.adapter = ProductsAdapter{
            viewModel.setChosenProduct(it)
            findNavController().navigate(R.id.action_frgProductList_to_frgProductDetail)
        }
        (binding.productlistRecycler.adapter as ProductsAdapter).items = products!!.results
    }
}