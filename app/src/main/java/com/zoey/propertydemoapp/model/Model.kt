package com.zoey.propertydemoapp.model

import com.google.gson.annotations.SerializedName


data class Properties(

    @SerializedName("ad_id")
    var adId: Int?,

    @SerializedName("data")
    var data: Data?,

    @SerializedName("title")
    var title: String?
)

data class Data(

    @SerializedName("listings")
    var propertyList: List<Property>?
)

data class Property(

    @SerializedName("Id")
    var id: String?,

    @SerializedName("AgencyLogoUrl")
    var agencyLogoUrl: String?,

    @SerializedName("Area")
    var area: String?,

    @SerializedName("AuctionDate")
    var auctionDate: String?,

    @SerializedName("AvailableFrom")
    var availableFrom: Any?,

    @SerializedName("Bathrooms")
    var bathrooms: Int?,

    @SerializedName("Bedrooms")
    var bedrooms: Int?,

    @SerializedName("Carspaces")
    var carspaces: Int?,

    @SerializedName("DateFirstListed")
    var dateFirstListed: String?,

    @SerializedName("DateUpdated")
    var dateUpdated: String?,

    @SerializedName("Description")
    var description: String?,

    @SerializedName("DisplayPrice")
    var displayPrice: String?,

    @SerializedName("Currency")
    var currency: String?,

    @SerializedName("Location")
    var location: Location?,

    @SerializedName("owner")
    var owner: Owner?,

    @SerializedName("ImageUrls")
    var imageUrls: List<String>?,

    @SerializedName("is_premium")
    var isPremium: Int?,

    @SerializedName("IsPriority")
    var isPriority: Int?,

    @SerializedName("Latitude")
    var latitude: Float?,

    @SerializedName("ListingPrice")
    var listingPrice: Any?,

    @SerializedName("ListingStatistics")
    var listingStatistics: Any?,

    @SerializedName("ListingType")
    var listingType: String?,

    @SerializedName("ListingTypeString")
    var listingTypeString: String?,

    @SerializedName("Longitude")
    var longitude: Float? = null
)

data class Owner(
    @SerializedName("name")
    var name: String?,

    @SerializedName("lastName")
    var lastName: String?,

    @SerializedName("dob")
    var dob: String?,

    @SerializedName("image")
    var image: Image?
)

data class Location(
    @SerializedName("Address")
    var address: String?,

    @SerializedName("Address2")
    var address2: String?,

    @SerializedName("State")
    var state: String?,

    @SerializedName("Suburb")
    var suburb: String?
)

data class Image(

    @SerializedName("medium")
    var medium: Medium
)

data class Medium(
    @SerializedName("url")
    var url: String?
)