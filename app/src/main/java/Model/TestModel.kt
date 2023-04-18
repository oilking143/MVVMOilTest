package Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TestModel : ViewModel() {
    val message = MutableLiveData<String>()

    // function to send message
    fun sendMessage(text: String) {
        message.value = text
    }

}