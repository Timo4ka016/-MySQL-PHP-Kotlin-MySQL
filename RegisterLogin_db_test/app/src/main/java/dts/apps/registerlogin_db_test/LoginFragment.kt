package dts.apps.registerlogin_db_test

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import dts.apps.registerlogin_db_test.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var binding_1 : FragmentLoginBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentLoginBinding.inflate(inflater , container , false)

        binding_2.btnLogin.setOnClickListener {
            onLogin()
        }

        return binding_2.root


    }



    private fun onLogin() {
        val URL = "http://192.168.1.13/LoginRegister/login_user.php"
        val email = binding_2.edtEmail.text.toString()
        val password = binding_2.edtPassword.text.toString()
        val stringRequest =object : StringRequest(Request.Method.POST , URL , Response.Listener { responseListener ->
            if (responseListener.trim().equals("Success")) {
                Toast.makeText(context , "Welcome" , Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context , "Incorrect email or password" , Toast.LENGTH_SHORT).show()
            }
        } , Response.ErrorListener { responseErrorListener ->
            Log.i("ErrorListener" , responseErrorListener.toString())
        }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String , String>()
                params.put("email" , email)
                params.put("password" , password)
                return params
            }
        }
        val queue = Volley.newRequestQueue(context)
        queue.add(stringRequest)
    }


}