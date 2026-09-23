package com.pemmob.nafisah.data.model

data class Product(
    val id: Int,
    val category_id: Int,
    val category: Category?,
    val name: String,
    val description: String? = null,
    val price: Double,
    val stock: Int = 0,
    val img: String = "dummy_product"
)
