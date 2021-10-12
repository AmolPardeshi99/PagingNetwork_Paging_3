package com.masai.pagingnetworkand03.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.masai.pagingnetworkand03.model.CharacterDTO

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    fun searchCharacters() =
        repository.getPagesList()

}