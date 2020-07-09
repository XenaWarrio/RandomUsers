package dx.queen.testtask.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dx.queen.testtask.R
import dx.queen.testtask.databinding.FragmentDetailBinding
import dx.queen.testtask.model.User

class DetailFragment() : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail, container, false
        )
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = requireArguments().getParcelable<User>("user")

        if (user != null) {

            with(user) {
                val name = name.first + " " + name.last
                val age = registered.age.toString() + " years old"
                binding.tvName.text = name
                binding.tvAge.text = age
                binding.tvCellPhone.text = phone
                binding.tvEmail.text = email
                binding.tvSkype.text = location.city
            }

            Glide.with(requireContext())
                .load(user.picture.medium)
                .apply(RequestOptions().circleCrop())
                .into(binding.ivPersonImage)

        }
    }

    private fun doCall() {
        Toast.makeText(
            requireContext(),
            "This application is so cool that it rings spiritually. " +
                    "You may think that nothing is happening, but you are mistaken. This is technology, baby.",
            Toast.LENGTH_LONG
        )
            .show()
    }

}