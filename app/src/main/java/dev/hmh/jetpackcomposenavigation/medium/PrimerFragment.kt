package dev.hmh.jetpackcomposenavigation.medium

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import dev.hmh.jetpackcomposenavigation.R


class PrimerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*   return inflater.inflate(R.layout.fragment_primer, container, false).apply {
               findViewById<ComposeView>(R.id.composeview).setContent {

               }
           }*/

        return ComposeView(requireContext()).apply {
            setContent {
                FragmentText()
            }
        }
    }

    @Composable
    fun FragmentText() {
        Text(text = "Fragment Text")
        Image(painter = painterResource(id = R.drawable.bg), contentDescription = "bg")
    }
}