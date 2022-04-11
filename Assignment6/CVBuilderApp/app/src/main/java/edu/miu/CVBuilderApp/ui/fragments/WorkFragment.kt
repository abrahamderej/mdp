package edu.miu.CVBuilderApp.ui.fragments

import CVBuilderApp.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.miu.CVBuilderApp.data.Work
import edu.miu.CVBuilderApp.ui.dialog.WorkDialog
import edu.miu.walmartlogin.adapter.WorkAdapter

class WorkFragment : Fragment(R.layout.fragment_work) {

    private var workList = mutableListOf<Work>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(

                Work(
                    getString(R.string.creo),
                    getString(R.string.full_stack_engineer),
                    getString(R.string._2021_current),
                    R.drawable.creospan
                ),
                Work(
                    getString(R.string.google),
                    getString(R.string.application_developer_for_google),
                    getString(R.string._2019_2020),
                    R.drawable.google
                ),
                Work(
                    getString(R.string.amazon),
                    getString(R.string.sde_ii),
                    getString(R.string._2017_2019),
                    R.drawable.amazon
                )
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
        val dialog = WorkDialog()
        dialog.show(parentFragmentManager, WorkDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onAddWOrk(work: Work) {
        workList.add(work)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }

}