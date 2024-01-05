package com.example.apipractice



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class CourseRVAdapter(
    private var courseList: ArrayList<CourseRVModal>,
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseRVAdapter.CourseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.course_rv_item,
            parent, false
        )
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseRVAdapter.CourseViewHolder, position: Int) {
        holder.courseNameTV.text = courseList.get(position).languageName
        Picasso.get().load(courseList.get(position).languageImg).into(holder.courseIV)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseNameTV: TextView = itemView.findViewById(R.id.idTVCourse)
        val courseIV: ImageView = itemView.findViewById(R.id.idIVCourse)
    }
}