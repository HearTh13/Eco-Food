package com.prod.ecofood.objects

import android.util.Log
import androidx.annotation.RequiresApi
import com.prod.ecofood.R

class Cart {
    var arrays: MutableList<MutableList<Any>> = mutableListOf(
        mutableListOf("Fried Chicken - KFC", 35000, R.drawable.it_kfc_fried_chicken, 1),
        mutableListOf("Noodles - Panda Express", 25000, R.drawable.it_panda_express_noodle, 1),
        mutableListOf("Steak - Outback", 120000, R.drawable.it_outback_steak, 1),
        mutableListOf("Donut - Dunkin'", 12000, R.drawable.it_dunkin_donuts, 1),
        mutableListOf("Smoked Beef - Starbuck", 27000, R.drawable.it_starbuck_smoked_beef, 1),
        mutableListOf("Cinnamon Cake - Bakery", 26000, R.drawable.it_bakery_cinnamon, 1)
    )
    var totalPrice: Int = 0
        get() {
            var price: Int = 0
            for (cartItem in arrays) {
                price += cartItem[1] as Int * cartItem[3] as Int
            }
            return price
        }

    fun addItem(item: MutableList<Any>) {
        for (cartItem in arrays){
            if (cartItem[0].equals(item[0])){
                addItemByOne(item)
                return
            }
        }
        val temp: MutableList<Any> = mutableListOf(item[0], item[1], item[2], 1)
        arrays.add(temp)
        Log.d("arr", arrays.toString())
    }

    fun addItemByOne(item: MutableList<Any>) {
        for (cartItem in arrays) {
            if (cartItem[0].equals(item[0])) {
                cartItem[3] = (cartItem[3] as Int) + 1
            }
        }
    }

    fun subtractItem(item: MutableList<Any>) {
        for (cartItem in arrays) {
            if (cartItem[0].equals(item[0])) {
                cartItem[3] = (cartItem[3] as Int) - 1
                if (cartItem[3] as Int <= 0){
                    cartItem[3] = 1
                }
            }
        }
    }

    fun removeItem(item: MutableList<Any>){
        for (cartItem in arrays) {
            if (cartItem[0].equals(item[0])) {
                arrays.remove(cartItem)
            }
        }
    }

    // Function to clear the cart
    fun clearCart() {
        arrays.clear()
    }
}