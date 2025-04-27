package com.example.catchat

import android.content.Context
import android.view.*
import android.widget.*

class FAQAdapter internal constructor(private val context: Context, private val questionList: List<String>, private val answerList: HashMap<String, String>): BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return questionList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getGroup(groupPosition: Int): Any {
        return questionList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return this.answerList[this.questionList[groupPosition]] as String
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        var convertView = convertView
        val questionTitle = getGroup(groupPosition) as String
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.faq_question, null)
        }

        val questionTv = convertView!!.findViewById<TextView>(R.id.faqQuestion)
        questionTv.setText(questionTitle)

        return convertView

    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        var convertView = convertView
        val answerTitle = getChild(groupPosition, childPosition) as String
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.faq_answer, null)
        }

        val answerTv = convertView!!.findViewById<TextView>(R.id.faqAnswer)
        answerTv.setText(answerTitle)

        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}
