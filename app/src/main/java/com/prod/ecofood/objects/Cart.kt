package com.prod.ecofood.objects

import android.util.Log
import androidx.annotation.RequiresApi
import com.prod.ecofood.R

class Cart {
    var arrays: MutableList<MutableList<Any>> = mutableListOf(

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