package com.agicent.mvvmdemo.component

import com.agicent.mvvmdemo.Activity.UserProfileActivity
import com.agicent.mvvmdemo.module.UserProfileModule
import com.agicent.mvvmdemo.viewmodel.UserProfileViewModel
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Component( modules = [UserProfileModule::class])
interface UserProfileComponent {
     fun  inject(userProfileActivity: UserProfileActivity)
}