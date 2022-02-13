package com.edcompanies.companycard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edcompanies.companycard.R
import com.edcompanies.companycard.model.TeamMember

class TeamAdapter(private val data:List<TeamMember>):
    RecyclerView.Adapter<TeamAdapter.TeamMemberViewHolder>() {

    class TeamMemberViewHolder(view: View):RecyclerView.ViewHolder(view){

        val memberName=view.findViewById<TextView>(R.id.text_name)
        val memberPosition=view.findViewById<TextView>(R.id.text_position)
        val memberImage=view.findViewById<ImageView>(R.id.member_avatar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.team_member_layout,parent,false)
        return TeamMemberViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        val teamMember=data[position]
        holder.memberImage.setImageResource(teamMember.imageId)
        holder.memberName.text=teamMember.name
        holder.memberPosition.text=teamMember.position
    }

    override fun getItemCount()=data.size
}