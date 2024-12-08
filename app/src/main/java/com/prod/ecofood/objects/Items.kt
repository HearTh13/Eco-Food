package com.prod.ecofood.objects

import com.prod.ecofood.R

class Items {
    var arrays: List<MutableList<Any>> = listOf(
        mutableListOf("Fried Chicken - KFC", 35000, R.drawable.it_kfc_fried_chicken),
        mutableListOf("Noodles - Panda Express", 25000, R.drawable.it_panda_express_noodle),
        mutableListOf("Steak - Outback", 120000, R.drawable.it_outback_steak),
        mutableListOf("Donut - Dunkin'", 12000, R.drawable.it_dunkin_donuts),
        mutableListOf("Smoked Beef - Starbuck", 27000, R.drawable.it_starbuck_smoked_beef),
        mutableListOf("Cinnamon Cake - Bakery", 26000, R.drawable.it_bakery_cinnamon)
    )
}