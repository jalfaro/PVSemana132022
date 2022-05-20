package gt.edu.galileo.red.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import gt.edu.galileo.red.R
import gt.edu.galileo.red.databinding.FragmentListadoBinding
import gt.edu.galileo.red.viewmodel.ListadoViewModel

class ListadoFragment : Fragment() {
    lateinit var binding: FragmentListadoBinding
    lateinit var viewModel: ListadoViewModel
    val adapter = ContactoAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ListadoViewModel::class.java)
        binding.recicler.layoutManager = LinearLayoutManager(context)
        binding.recicler.adapter = adapter
        viewModel.getContactos()
        viewModel.listado.observe(viewLifecycleOwner, { lista ->
            adapter.loadNewData(lista)
        })
        return binding.root
    }
}