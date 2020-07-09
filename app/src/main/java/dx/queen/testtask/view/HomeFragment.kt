package dx.queen.testtask.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dx.queen.testtask.R
import dx.queen.testtask.databinding.FragmentHomeBinding
import dx.queen.testtask.model.User
import dx.queen.testtask.view.recycler_view.AdapterContacts
import dx.queen.testtask.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ac = activity as SingleActivity

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.getListUsers()

        val adapter = AdapterContacts()
        with(binding.recyclerView) {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
        }

        val contactsObserver = Observer<List<User>> {
            adapter.setContactsList(it)
        }

        val clickOnItemObserver = Observer<User> {
            ac.openDetailFragment(it)
        }

        viewModel.userListLiveData.observe(viewLifecycleOwner, contactsObserver)
        adapter.clickOnItem.observe(viewLifecycleOwner, clickOnItemObserver)

    }

}
