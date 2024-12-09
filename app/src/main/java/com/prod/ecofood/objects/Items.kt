package com.prod.ecofood.objects

import com.prod.ecofood.R

class Items {
    var arrays: List<MutableList<Any>> = listOf(
        mutableListOf("Fried Chicken - KFC", 35000, R.drawable.it_kfc_fried_chicken, "Fast Food"),
        mutableListOf("Noodles - Panda Express", 25000, R.drawable.it_panda_express_noodle, "Fast Food"),
        mutableListOf("Steak - Outback", 120000, R.drawable.it_outback_steak, "Grilled"),
        mutableListOf("Donut - Dunkin'", 12000, R.drawable.it_dunkin_donuts, "Pastry or Dessert"),
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