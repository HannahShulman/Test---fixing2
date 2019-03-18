package com.cheetah.test.testing.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(

    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("parent_id")
    @Expose
    var parentId: Int? = null,
    @SerializedName("description")
    @Expose
    var description: Any? = null,
    @SerializedName("image_url")
    @Expose
    var imageUrl: Any? = null,
    @SerializedName("display_order")
    @Expose
    var displayOrder: Any? = null,
    @SerializedName("image_id")
    @Expose
    var imageId: Any? = null,
    @SerializedName("hide")
    @Expose
    var hide: Boolean? = null)
