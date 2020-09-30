package com.samone.project6.views

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.samone.project6.R
import com.samone.project6.models.ChatMessage
import com.samone.project6.models.User
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.latest_messages_row.view.*


class LatestMessageRow(private val chatMessage: ChatMessage): Item<GroupieViewHolder>() {

    var chatPartnerUser: User? = null

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.message_textView_latest_message.text = chatMessage.text

        val chatPartnerId: String = if (chatMessage.fromId == FirebaseAuth.getInstance().uid){
            chatMessage.toId
        }else{
            chatMessage.fromId
        }

        val ref = FirebaseDatabase.getInstance().getReference("/users/$chatPartnerId")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                chatPartnerUser = p0.getValue(User::class.java)
                viewHolder.itemView.username_textView_latest_message.text = chatPartnerUser?.username

                val targetImageView = viewHolder.itemView.imageView_latest_message
                Picasso.get().load(chatPartnerUser?.profileImageUrl).into(targetImageView)
            }

        })
    }
    override fun getLayout(): Int {
        return  R.layout.latest_messages_row
    }
}