package com.rcapelli.catalogoonline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.rcapelli.catalogoonline.databinding.FragmentSearchProductBinding
import com.rcapelli.catalogoonline.models.ProductViewModel


class FrgSearchProduct : Fragment() {
    private var _binding: FragmentSearchProductBinding? = null
    private val binding get() = _binding!!
    private val viewModel : ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentSearchProductBinding.inflate(inflater,container,false)
        _binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beginSearch()
    }

    private fun beginSearch(){
        val button = binding.btnSearch
        button.setOnClickListener {
            val productToSearch = binding.etSearch.text.toString()
            if(productToSearch.isNotEmpty()){
                viewModel.setSearch(productToSearch){
                    if(it != null){
                        findNavController().navigate(R.id.action_frgSearchProduct_to_frgProductList)
                    }else{
                        binding.etSearch.text!!.clear()
                        Toast.makeText(requireContext(), getString(R.string.no_products_founded), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}