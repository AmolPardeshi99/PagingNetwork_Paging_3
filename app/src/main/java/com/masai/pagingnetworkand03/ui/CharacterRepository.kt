package com.masai.pagingnetworkand03.ui

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class CharacterRepository {

    fun getPagesList()=
        Pager(
            config = PagingConfig(
                pageSize = 20, // how many items want from paging Source
                //maxSize = 50  used to specify how many items will be live
            ),
            pagingSourceFactory = {CharacterPagingSource()}
        ).liveData

}