package dx.queen.testtask.view.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dx.queen.testtask.R
import dx.queen.testtask.model.User
import kotlinx.android.synthetic.main.view_pattern.view.*

class AdapterContacts : RecyclerView.Adapter<ViewHolderContact>() {

    private var contactsList = mutableListOf<User>()
    var clickOnItem = MutableLiveData<User>()


    fun setContactsList(list: List<User>) {
        contactsList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderContact {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_pattern, parent, false)
        return ViewHolderContact(view)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ViewHolderContact, position: Int) {
        holder.itemView.setOnClickListener {
            clickOnItem.value = contactsList[position]
        }
        holder.bind(contactsList[position])
    }
}

class ViewHolderContact(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(contact: User) {
        val name = contact.name.first + " " + contact.name.last
        itemView.tv_contact_name.text = name

        Glide.with(itemView.context)
            .load(contact.picture.medium)
            .apply(RequestOptions().circleCrop())
            .into(itemView.iv_person_photo)
    }
}

