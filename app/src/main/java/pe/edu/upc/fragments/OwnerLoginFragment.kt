package pe.edu.upc.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_owner_login.*

import pe.edu.upc.R
import pe.edu.upc.activities.MainActivity
import pe.edu.upc.services.AuthenticationService
import pe.edu.upc.services.DataServiceO

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class OwnerLoginFragment : Fragment() {

    val authServ = AuthenticationService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owner_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logineEmployeeBtn.setOnClickListener {
            ret->logOwner(view)
        }

    }

    fun logOwner(view: View){
        authServ.logOwner(view.context, ownerUserTxt?.editText?.text.toString(), ownerPassTxt?.editText?.text.toString())
        if(DataServiceO.isLogged) {
            startActivity(Intent(view.context, MainActivity::class.java))
        }
    }

}
