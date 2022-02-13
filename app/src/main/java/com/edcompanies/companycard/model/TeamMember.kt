package com.edcompanies.companycard.model

import androidx.annotation.DrawableRes
import com.edcompanies.companycard.R

class TeamMember(private val id:Int,val name:String,val position:String,@DrawableRes val imageId:Int= R.drawable.ic_person)