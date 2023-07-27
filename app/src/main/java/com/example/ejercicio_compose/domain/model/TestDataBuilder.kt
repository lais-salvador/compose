package com.example.ejercicio_compose.domain.model

class TestDataBuilder() {
    private var name = ""
    private var id = "Ejemplo"
    private var description = ""
    private var photoUrl = ""
    private var numElements: Int = 1

    fun withName(name: String): TestDataBuilder {
        this.name = name

        return this
    }

    fun withDescription(description: String): TestDataBuilder {
        this.description = description

        return this
    }

    fun withPhotoUrl(photoUrl: String): TestDataBuilder {
        this.photoUrl = photoUrl

        return this
    }

    fun withId(id: String): TestDataBuilder {
        this.id = id

        return this
    }

    fun withNumElements(numElements: Int): TestDataBuilder {
        this.numElements = numElements

        return this
    }

    fun build(): List<HeroModel>{
        val list = mutableListOf<HeroModel>()

        for(i in 0 .. numElements){
        list.add(HeroModel( id, name, photoUrl, description))
        }

        return list.toList()
    }

    fun buildSingle(): HeroModel = HeroModel(id, name, photoUrl, description )
}