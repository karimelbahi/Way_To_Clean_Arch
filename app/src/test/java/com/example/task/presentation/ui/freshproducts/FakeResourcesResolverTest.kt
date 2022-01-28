package com.example.task.presentation.ui.freshproducts

import com.example.task.presentation.utils.ResourcesResolver

class FakeResourcesResolverTest : ResourcesResolver{

    override fun getString(resId: Int): String {
        TODO("Not yet implemented")
    }


//    override fun getString(resId: Int, strString: String): String {
//        TODO("Not yet implemented")
//    }
//
//    override fun getString(resId: Int, strMessage: Int): String {
//        TODO("Not yet implemented")
//    }

    override fun getString(resId: Int, vararg formatArgs: Any?): String {
        TODO("Not yet implemented")
    }
}