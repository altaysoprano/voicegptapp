import android.app.Activity
import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.chatgptapp.ApiService
import com.example.chatgptapp.RetrofitService
import com.example.chatgptapp.models.ChatMessage
import com.example.chatgptapp.models.ChatRequest
import com.example.chatgptapp.models.ChatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale

class MainViewModel : ViewModel() {

    private val RQ_SPEECH_REC = 102
    private val apiService: ApiService = RetrofitService.apiService

    fun askSpeechInput(context: Context) {
        if (!SpeechRecognizer.isRecognitionAvailable(context)) {
            Toast.makeText(context, "Speech Recognition not available", Toast.LENGTH_SHORT).show()
        } else {
            val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Ask AI")
            (context as Activity).startActivityForResult(i, RQ_SPEECH_REC)
        }
    }

    fun handleSpeechResult(context: Context, requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RQ_SPEECH_REC && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            val message = result?.get(0).toString()
            Log.d("Mesaj: ", message)
            sendChatMessage(context, message)
        }
    }

    fun sendChatMessage(context: Context, message: String) {
        val chatRequest = ChatRequest(
            listOf(
                ChatMessage("system", "Hello"),
                ChatMessage("user", message)
            )
        )

        val call = apiService.getChatCompletion(chatRequest)
        call.enqueue(object : Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                if (response.isSuccessful) {
                    val chatResponse = response.body()
                    Log.d("Mesaj: ", chatResponse.toString())
                } else {
                    val errorBody = response.errorBody()?.string()
                    val errorMessage = errorBody ?: "Unknown Error"
                    Log.d("Mesaj: ", errorMessage)
                    Toast.makeText(context, "API Request Failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                Toast.makeText(context, "API Request Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
