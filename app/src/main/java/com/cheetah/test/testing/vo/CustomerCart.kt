package com.cheetah.test.testing.vo

import androidx.paging.PagedList
import androidx.room.*
import com.cheetah.test.testing.roomdb.DatabaseTypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity
@TypeConverters(DatabaseTypeConverters::class)
class CustomerCart (

    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("cart_total")
    @Expose
    var cartTotal: Int? = null,
    @SerializedName("total")
    @Expose
    var total: Int? = null,
    @SerializedName("delivery_fee")
    @Expose
    var deliveryFee: Int? = null,
    @SerializedName("same_day_charge")
    @Expose
    var sameDayCharge: Int? = null,
    @SerializedName("created_at_iso8601")
    @Expose
    var createdAtIso8601: String? = null,
    @SerializedName("last_time_modified_int")
    @Expose
    var lastTimeModifiedInt: Long? = null,
    @SerializedName("delivery_date_iso8601")
    @Expose
    var deliveryDateIso8601: String? = null,
    @SerializedName("status")
    @Expose
    var status: String? = null,
    @SerializedName("delivery_address")
    @Expose
    var deliveryAddress: String? = null,
    @SerializedName("promo_code")
    @Expose
    @Ignore
    var promoCode: Any? = null,
    @SerializedName("promo_code_discount")
    @Expose
    var promoCodeDiscount: Int? = null,
    @SerializedName("promo_code_discount_cash")
    @Expose
    var promoCodeDiscountCash: Int? = null,
    @SerializedName("promo_code_validation")
    @Expose
    var promoCodeValidation: Boolean? = null,
    @SerializedName("order_items_information")
    @Expose
    var orderItemsInformation: List<OrderItemsInformation>? = null,
    @SerializedName("restaurant_id")
    @Expose
    var restaurantId: Int? = null,
    @SerializedName("note")
    @Expose
    var note: String? = null,
    @SerializedName("same_day_charge_amount")
    @Expose
    var sameDayChargeAmount: Int? = null,
    @SerializedName("sub_total")
    @Expose
    var subTotal: Int? = null,
    @SerializedName("error_code")
    @Expose
    @Ignore
    var errorCode: Any? = null,
    @SerializedName("error_description")
    @Expose
    var errorDescription: String? = null,
    @SerializedName("delivery_date")
    @Expose
    var deliveryDate: String? = null,
    @SerializedName("delivery_time_start")
    @Expose
    var deliveryTimeStart: Int? = null,
    @SerializedName("delivery_time_end")
    @Expose
    var deliveryTimeEnd: Int? = null,
    @SerializedName("local_time_iso8601")
    @Expose
    var localTimeIso8601: String? = null,
    @SerializedName("credit_card_charge")
    @Expose
    var creditCardCharge: Int? = null,
    @SerializedName("first_delivery_discount")
    @Expose
    var firstDeliveryDiscount: Int? = null,
    @SerializedName("free_delivery_discount")
    @Expose
    var freeDeliveryDiscount: Int? = null,
    @SerializedName("payment_method")
    @Expose
    var paymentMethod: String? = null,
    @SerializedName("fill_in")
    @Expose
    var fillIn: Boolean? = null,
    @SerializedName("possible_fill_in")
    @Expose
    var possibleFillIn: Boolean? = null,
    @SerializedName("subscription_fee")
    @Expose
    var subscriptionFee: Int? = null,
    @SerializedName("under_subscription")
    @Expose
    var underSubscription: Boolean? = null,
    @SerializedName("available_delivery_times")
    @Expose
    @Ignore
    var availableDeliveryTimes: List<AvailableDeliveryTime>? = null)
