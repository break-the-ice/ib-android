package com.jozews.icebreak

/**
 * Created by jozews on 25.01.18.
 */
import com.beust.klaxon.Json
class Profile constructor(id: String, name: String, aboutme: String, email: String, birthday: String?, gender: String, topPlacesIds: Array<String>?, topLocalitiesIds: Array<String>?) {

    @Json(name = "id")
    val id: String
    @Json(name = "name")
    val name: String
    @Json(name = "aboutme")
    val aboutme: String
    @Json(name = "email")
    val email: String
    @Json(name = "birthday")
    val birthday: String?
    @Json(name = "gender")
    val gender: String

    @Json(name = "top_places_ids")
    val topPlacesIds: Array<String>?
    @Json(name = "top_localities_ids")
    val topLocalitiesIds: Array<String>?

    init {
        this.id = id
        this.name = name
        this.aboutme = aboutme
        this.email = email
        this.birthday = birthday
        this.gender = gender
        this.topPlacesIds = topPlacesIds
        this.topLocalitiesIds = topLocalitiesIds
    }
}