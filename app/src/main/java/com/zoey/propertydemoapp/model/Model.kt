package com.zoey.propertydemoapp.model

import com.google.gson.annotations.SerializedName


data class Properties(

    @SerializedName("ad_id")
    val adId: Int?,

    @SerializedName("data")
    val data: Data?,

    @SerializedName("title")
    val title: String?
)

data class Data(

    @SerializedName("listings")
    val propertyList: List<Property>?
)

data class Property(

    @SerializedName("Id")
    val id: String?,

    @SerializedName("AgencyLogoUrl")
    val agencyLogoUrl: String?,

    @SerializedName("Area")
    val area: String?,

    @SerializedName("AuctionDate")
    val auctionDate: String?,

    @SerializedName("AvailableFrom")
    val availableFrom: Any?,

    @SerializedName("Bathrooms")
    val bathrooms: Int?,

    @SerializedName("Bedrooms")
    val bedrooms: Int?,

    @SerializedName("Carspaces")
    val carspaces: Int?,

    @SerializedName("DateFirstListed")
    val dateFirstListed: String?,

    @SerializedName("DateUpdated")
    val dateUpdated: String?,

    @SerializedName("Description")
    val description: String?,

    @SerializedName("DisplayPrice")
    val displayPrice: String?,

    @SerializedName("Currency")
    val currency: String?,

    @SerializedName("Location")
    val location: Location?,

    @SerializedName("owner")
    val owner: Owner?,

    @SerializedName("ImageUrls")
    val imageUrls: List<String>?,

    @SerializedName("is_premium")
    val isPremium: Int?,

    @SerializedName("IsPriority")
    val isPriority: Int?,

    @SerializedName("Latitude")
    val latitude: Float?,

    @SerializedName("ListingPrice")
    val listingPrice: Any?,

    @SerializedName("ListingStatistics")
    val listingStatistics: Any?,

    @SerializedName("ListingType")
    val listingType: String?,

    @SerializedName("ListingTypeString")
    val listingTypeString: String?,

    @SerializedName("Longitude")
    val longitude: Float? = null
)

data class Owner(
    @SerializedName("name")
    val name: String?,

    @SerializedName("lastName")
    val lastName: String?,

    @SerializedName("dob")
    val dob: String?,

    @SerializedName("image")
    val image: Image?
)

data class Location(
    @SerializedName("Address")
    val address: String?,

    @SerializedName("Address2")
    val address2: String?,

    @SerializedName("State")
    val state: String?,

    @SerializedName("Suburb")
    val suburb: String?
)

data class Image(

    @SerializedName("medium")
    val medium: Medium
)

data class Medium(
    @SerializedName("url")
    val url: String?
)