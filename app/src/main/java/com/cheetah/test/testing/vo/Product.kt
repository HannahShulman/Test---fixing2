package com.cheetah.test.testing.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product (

    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("sku")
    @Expose
    var sku: String? = null,
    @SerializedName("unit_photo_filename")
    @Expose
    var unitPhotoFilename: String? = null,
    @SerializedName("pack_photo_file")
    @Expose
    var packPhotoFile: String? = null,
    @SerializedName("unit_photo_hq_url")
    @Expose
    var unitPhotoHqUrl: String? = null,
    @SerializedName("pack_photo_hq_url")
    @Expose
    var packPhotoHqUrl: String? = null,
    @SerializedName("unit_barcode")
    @Expose
    var unitBarcode: String? = null,
    @SerializedName("pack_barcode")
    @Expose
    var packBarcode: Any? = null,
    @SerializedName("available")
    @Expose
    var available: Boolean? = null,
    @SerializedName("updated_at_iso8601")
    @Expose
    var updatedAtIso8601: String? = null,
    @SerializedName("case_orderable")
    @Expose
    var caseOrderable: Boolean? = null,
    @SerializedName("weight_orderable")
    @Expose
    var weightOrderable: Boolean? = null,
    @SerializedName("weight_photo_filename")
    @Expose
    var weightPhotoFilename: String? = null,
    @SerializedName("weight_photo_hq_url")
    @Expose
    var weightPhotoHqUrl: String? = null,
    @SerializedName("unit_price")
    @Expose
    var unitPrice: Int? = 0,
    @SerializedName("case_price")
    @Expose
    var casePrice: Int? = 0,
    @SerializedName("weight_price")
    @Expose
    var weightPrice: Int? = 0,
    @SerializedName("items_per_unit")
    @Expose
    var itemsPerUnit: Int? = null,
    @SerializedName("units_per_case")
    @Expose
    var unitsPerCase: Int? = null,
    @SerializedName("avg_unit_weight")
    @Expose
    var avgUnitWeight: Any? = null,
    @SerializedName("avg_case_weight")
    @Expose
    var avgCaseWeight: Any? = null,
    @SerializedName("weight_discount_price")
    @Expose
    var weightDiscountPrice: Any? = null,
    @SerializedName("weight_discount_threshold")
    @Expose
    var weightDiscountThreshold: Any? = null,
    @SerializedName("grouped_by_category_name")
    @Expose
    var groupedByCategoryName: String? = null,
    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null
)