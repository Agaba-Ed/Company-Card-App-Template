package com.edcompanies.companycard.data

import com.edcompanies.companycard.R
import com.edcompanies.companycard.model.TeamMember

class DataManager {

    public fun loadMembers():List<TeamMember>{
        return listOf(TeamMember(1,"Agaba Edwin","Android Engineer", R.drawable.ed),
        TeamMember(2,"Faith K","Chief Executive Officer"),
            TeamMember(3,"Tom D","Project Manager",R.drawable.tom),
            TeamMember(4,"Jessica","Marketing"),
            TeamMember(5,"Derrick","Data Analyst"),
            TeamMember(6,"John N","Web Developer",R.drawable.john)
        )
    }
}