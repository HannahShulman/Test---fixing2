package com.cheetah.test.testing.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 *
 */
data class AvailableDeliveryTime(

    @SerializedName("date")
    @Expose
    var date: String? = null,
    @SerializedName("start")
    @Expose
    var start: Int? = null,
    @SerializedName("end")
    @Expose
    var end: Int? = null,
    @SerializedName("reserved")
    @Expose
    var reserved: Boolean? = null,
    @SerializedName("spots_left")
    @Expose
    var spotsLeft: Int? = null,
    @SerializedName("show_last_spots_left")
    @Expose
    var showLastSpotsLeft: Boolean? = null
)

