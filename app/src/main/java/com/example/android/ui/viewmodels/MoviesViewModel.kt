package com.example.android.ui.viewmodels
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.models.MoviesResponse
import com.example.android.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val postRepository: PostRepository):ViewModel() {
    private val _postLiveData:MutableLiveData<MoviesResponse> = MutableLiveData()
    val postLiveData get() = _postLiveData

    fun getPost(){
        viewModelScope.launch {
            postRepository.getPosts().catch { e->
                Log.d("main", "getMovie: ${e.message}")
            }.collect{response->
                _postLiveData.value = response
            }
        }
    }
}