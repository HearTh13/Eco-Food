package com.prod.ecofood.objects

import com.prod.ecofood.R

class Items {

    var category: String = "All"

    var arrays: List<MutableList<Any>> = listOf(
        mutableListOf("Chicken beef- Beef Restaurant", 25000, R.drawable.beef, "Grilled"),
        mutableListOf("Chocolate - Starbucks", 27000, R.drawable.chocolate, "Drinks"),
        mutableListOf("Mixed Snacks - Outback", 120000, R.drawable.mixedsnack, "Fast Food"),
        mutableListOf("Fried Chicken - KFC", 35000, R.drawable.it_kfc_fried_chicken, "Fast Food"),
        mutableListOf("Noodles - Panda Express", 25000, R.drawable.it_panda_express_noodle, "Fast Food"),
        mutableListOf("Steak - Outback", 120000, R.drawable.it_outback_steak, "Grilled"),
        mutableListOf("J.CO Donuts - Dunkin'", 12000, R.drawable.it_dunkin_donuts, "Pastry or Dessert"),
        mutableListOf("Smoked Beef - Starbuck", 27000, R.drawable.it_starbuck_smoked_beef, "Grilled"),
        mutableListOf("Cinnamon Cake - Bakery", 26000, R.drawable.it_bakery_cinnamon, "Pastry or Dessert")
    )

    var show: MutableList<MutableList<Any>> = mutableListOf(

    )

    fun showCategory(category: String){

        show.clear()
        if (category.equals("All")){
            show = arrays.toMutableList()
        } else{
            for (array in arrays){
                if (array[3].equals(category)){
                    show.add(array)
                }
            }
        }
    }
}