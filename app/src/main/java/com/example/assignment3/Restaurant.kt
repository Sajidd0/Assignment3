package com.example.assignment3

class Restaurant {
    var name: String=""
    var Description: String=""
    var Location: String=""
    var phone: String=""
    var rating: Int=0
    constructor(name: String,Description: String,Location: String,phone: String,rating: Int)
    {
        this.name=name
        this.Description=Description
        this.phone=phone
        this.Location=Location
        this.rating=rating
    }
    constructor()
    {

    }
}