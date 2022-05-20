package gt.edu.galileo.red.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import gt.edu.galileo.red.R
import gt.edu.galileo.red.databinding.FragmentIngresoBinding
import gt.edu.galileo.red.viewmodel.IngresoViewModel


class IngresoFragment : Fragment() {
    lateinit var binding: FragmentIngresoBinding
    lateinit var viewModel : IngresoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIngresoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(IngresoViewModel::class.java)
        binding.btnGrabar.setOnClickListener {
            viewModel.grabaUsuario(binding.txtNombre.text.toString(), binding.txtTelefono.text.toString())
        }
        viewModel.mostrarMensaje.observe(viewLifecycleOwner, {
            if (!it.equals("")) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                binding.txtNombre.text.clear()
                binding.txtTelefono.text.clear()
                viewModel.mostrarMensaje.value = ""
            }
        });
        return binding.root
    }
}