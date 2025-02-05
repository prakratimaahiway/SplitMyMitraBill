package com.maahiway.splitmymitrabill.util

fun calculateTotalTip(totalBillAmt: Double, tipPercentage: Int): Double {
    return if(totalBillAmt > 1 && totalBillAmt.toString().isNotEmpty())
        (totalBillAmt * tipPercentage)/100 else 0.0
}

fun calculateTotalPerPerson(totalBillAmt: Double,splitBy:Int,tipPercentage: Int):Double{
    val bill = calculateTotalTip(totalBillAmt,tipPercentage) +totalBillAmt
    return (bill /splitBy)
}