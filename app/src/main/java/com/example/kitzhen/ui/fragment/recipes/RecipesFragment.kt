package com.example.kitzhen.ui.fragment.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kitzhen.R
import com.example.kitzhen.adapters.RecipesAdapter
import com.example.kitzhen.util.Constants.Companion.API_KEY
import com.example.kitzhen.util.Constants.Companion.DEFAULT_DIET_TYPE
import com.example.kitzhen.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.example.kitzhen.util.Constants.Companion.DEFAULT_RECIPES_NUMBER
import com.example.kitzhen.util.Constants.Companion.QUERY_ADD_RECIPE_INFORMATION
import com.example.kitzhen.util.Constants.Companion.QUERY_API_KEY
import com.example.kitzhen.util.Constants.Companion.QUERY_DIET
import com.example.kitzhen.util.Constants.Companion.QUERY_FILL_INGREDIENTS
import com.example.kitzhen.util.Constants.Companion.QUERY_NUMBER
import com.example.kitzhen.util.Constants.Companion.QUERY_TYPE
import com.example.kitzhen.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_recipes.view.*


class RecipesFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private val mAdapter by lazy { RecipesAdapter() }
    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_recipes, container, false)

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        setupRecyclerView()

        return mView
    }

    private fun requestApiData() {
        mainViewModel.getRecipes(applyQueries())
    }

    private fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        queries[QUERY_NUMBER] = DEFAULT_RECIPES_NUMBER
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = DEFAULT_MEAL_TYPE
        queries[QUERY_DIET] = DEFAULT_DIET_TYPE
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }

    private fun setupRecyclerView() {
        mView.recyclerview.adapter = mAdapter
        mView.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    private fun showShimmerEffect() {
        mView.recyclerview.showShimmer()
    }

    private fun hideShimmerEffect() {
        mView.recyclerview.hideShimmer()
    }

}