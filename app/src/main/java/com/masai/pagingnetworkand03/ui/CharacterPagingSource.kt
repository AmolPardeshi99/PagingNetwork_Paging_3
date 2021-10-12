package com.masai.pagingnetworkand03.ui

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.masai.pagingnetworkand03.api.NetworkHelper
import com.masai.pagingnetworkand03.model.CharacterDTO
import com.masai.pagingnetworkand03.model.ResponseDTO

class CharacterPagingSource:PagingSource<Int,CharacterDTO>() {

    private val apiservice = NetworkHelper.getApiService()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDTO> {
        val pageNumber = params.key ?:1



        return try{

            val responseDTO:ResponseDTO = apiservice.getCharactersByPage(pageNumber)
            val characterList:List<CharacterDTO> = responseDTO.results
            LoadResult.Page(
                data = characterList,
                prevKey = null,
                nextKey = if (characterList.isEmpty()) null else pageNumber+1

            )
        }catch (exception:Exception){
            Log.d("amol", "load: ${exception.toString()}")
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDTO>): Int? {
        return state.anchorPosition
    }


}