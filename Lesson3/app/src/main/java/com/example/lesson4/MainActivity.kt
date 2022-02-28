package com.example.lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var foods = ArrayList<String>(arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnDecideClick(view: View){
        txt_food_name.text = getRandomFood(foods);
    }

    private fun getRandomFood(fastFoods: ArrayList<String>): String {
        var randomFoodIndex = Random.nextInt(0, fastFoods.size);
        return fastFoods[randomFoodIndex];
    }

    fun btnAddFoodClick(view: View){
        var fastFoodName = text_add_new_food.text.toString();
        foods.add(fastFoodName);
        text_add_new_food.setText("");
    }
}