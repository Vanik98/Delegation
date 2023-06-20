package com.example.delegation

interface Car {
    val maxSpeed: Int
    fun go(speed: Int)
    fun stop()
    fun comfortable(): Int
    fun safety(): Int
    fun getCarRating(): Int
}

open class Toyota : Car {

    override val maxSpeed = 300

    override fun go(speed: Int) = myPrint(speed, "car speed is")

    override fun stop() = myPrint(0, "car speed is ")

    override fun safety() = 8

    override fun comfortable() = 7

    override fun getCarRating() = safety() + comfortable()
}

/**
 *  if no use delegate
 *  getCarRating()  is return  8+7 = 15
 *  */
class Lexus : Car {
    private val toyota = Toyota()

    override val maxSpeed = 400

    override fun go(speed: Int) = toyota.go(speed)

    override fun stop() = toyota.stop()

    override fun safety() = 9

    override fun comfortable() = 10

    override fun getCarRating(): Int = toyota.getCarRating()
}

/**
 *  if  use delegate
 *  getCarRating()  is return  8+7 = 15
 *  */
//class LexusDelegation(private val toyota: Toyota = Toyota()) : Car by toyota {
class LexusDelegation : Car by Toyota() {
    override val maxSpeed = 400
    override fun safety() = 9
    override fun comfortable() = 10
}

/**
 *  if not use delegate, use inheritance
 * getCarRating() is return 9+10 = 19
 * */
class LexusParent : Toyota() {
    override val maxSpeed = 400
    override fun safety() = 9
    override fun comfortable() = 10
}

