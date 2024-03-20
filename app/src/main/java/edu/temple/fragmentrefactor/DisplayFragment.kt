package edu.temple.fragmentrefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val NAME_KEY = "name"

class DisplayFragment : Fragment() {
    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false).apply{
            val nameEditText = findViewById<EditText>(R.id.nameEditText)
            val nameTextView = findViewById<TextView>(R.id.displayTextView)
            findViewById<Button>(R.id.changeButton).setOnClickListener{
                if (nameEditText.text.toString() != "") {
                    name = nameEditText.text.toString()
                    nameTextView.text = "Hello, "+ name
                }
            }
        }
    }

    companion object {
        fun newInstance(name: String) =
            DisplayFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME_KEY, name)
                }
            }
    }
}