package dts.apps.registerlogin_db_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import dts.apps.registerlogin_db_test.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {
    private var binding_1 : FragmentSignupBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentSignupBinding.inflate(inflater , container , false)
        binding_2.btnSignup.setOnClickListener {

            onSignUp()
        }
        return binding_2.root
    }

    private fun onSignUp() {
        val email = binding_2.edtEmail.text.toString()
        val fname = binding_2.edtFname.text.toString()
        val lname = binding_2.edtLname.text.toString()
        val password = binding_2.edtPassword.text.toString()
        val URL = "http://192.168.1.13/LoginRegister/signup_user.php"
        val stringRequest = object : StringRequest(Request.Method.POST , URL , Response.Listener { responseListener ->
            Toast.makeText(context , "SUCCESS" , Toast.LENGTH_SHORT).show()
        } , Response.ErrorListener { responseErrorListener ->
            Toast.makeText(context , responseErrorListener.toString() , Toast.LENGTH_SHORT).show()
        }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String , String>()
                params.put("email" , email)
                params.put("first_name" , fname)
                params.put("last_name" , lname)
                params.put("password" , password)
                return params
            }
        }
        val queue = Volley.newRequestQueue(context)
        queue.add(stringRequest)
    }
}