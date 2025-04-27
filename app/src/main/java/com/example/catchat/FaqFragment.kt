package com.example.catchat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView

class FaqFragment : Fragment() {

    private val questions = listOf("Meow?", "Meow meow?")

    private val answers = hashMapOf("Meow?" to "Meow.", "Meow meow?" to "Meow meow meow!");

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = FAQAdapter(requireContext(), this.questions, this.answers);

        // Inflate the layout for this fragment
        val fragmentFaq =  inflater.inflate(R.layout.fragment_faq, container, false)

        val faqList = fragmentFaq.findViewById<ExpandableListView>(R.id.faqList)

        faqList.setAdapter(adapter)

        return fragmentFaq
    }
}