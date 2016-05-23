package com.ga.common;

/**
 * The Enum ErrorCodes.
 * 
 * @author knilay
 */
public enum ClientErrorCodes {

    // Common general Response and error codes
    GA_SECURITY_POLICY_VIOLATION(5001, "Security policy violation"),
    GA_INTERNAL(5002, "Internal Error"),
    GA_MANDATORY_PARAMETER_NOT_FOUND(5003, "Mandatory parameter not found."),
    GA_SERVICE_UNAVAILABLE(5004, "Service auavailble.Please try again after sometime"),
    GA_USER_BLOCKED(5005, "Operations not authorized as user is blocked. Please contact administrator"),
    // Responce/Error code for Sequence
    GA_SEQUENCE_ACTION_UNSUPPORETD(5006, "Unable to get sequence id."),
    GA_PAGINATION_WRONG_VALUE(5007, "Wrong parameter passed for pagination"),

    // Response / error codes for Login service
    GA_AUTH_TRANSACTION_OK(0, "Login successful"),
    GA_AUTH_FAILED_WRONG_CREDENTIALS(1, "Username or Password is wrong. Please try with correct credentials"),
    GA_AUTH_EMAIL_NOT_VERIFIED(2, "Login successful but Email not yet verified"),

    // Registration use case
    GA_REG_TRANSACTION_OK(0, "Registration successful"),
    GA_REG_ROLE_REQUIRED(1, "Registration failed"),
    GA_EMAIL_ALREADY_REGISTERED(2, "Email is already in use"),
    GA_EMAIL_REGISTERED_WITH_ROLE(3, "Email is registered with other role"),
    GA_OCP_EMAIL_REGISTERED(4, "Email is Already registered with OCP"),

    // For AddUserRole
    GA_USER_UPDATE_TRANSACTION_OK(0, "Update sucessful"),
    GA_USER_UPDATE_FAILED(1, "User Updation failed"),

    // For email verification service
    GA_EMAIL_VERIFICATION_TRANSACTION_OK(0, "Email Verified sucessfully"),
    GA_EMAIL_VERIFICATION_FAILED(1, "User Updation failed"),
    GA_EMAIL_VERIFICATION_WRONG_PARAMETERS(3, "Incorrect parameter"),

    // Responce /error codes for AddBankDetail service
    GA_BANK_DETAILS_TRANSACTION_OK(0, "Bank Detais saved sucessfully"),
    GA_BANK_DETAILS_INTERNAL_ERROR(1, "Error in save Bank details"),

    // Responce /error codes for GetBankDetail service
    GA_GET_BANK_DETAILS_TRANSACTION_OK(0, "Bank Detais Retrived sucessfully"),
    GA_GET_BANK_DETAILS_DATA_NOT_FOUND(1, "No BankDetails found for current User."),
    GA_GET_BANK_DETAILS_POLICY_VIOLATION(2, "Bank details not setted by User."),

    // Response / error for AddPersonalDetails service
    GA_ADD_PERSONAL_DETAILS_TRANSACTION_OK(0, "Personal Detais saved sucessfully"),
    GA_ADD_PERSONAL_DETAILS_INTERNAL_ERROR(1, "Error in save personal detail."),

    // Responce /error codes for GetBankDetail service
    GA_GET_PERSONAL_DETAILS_TRANSACTION_OK(0, "Personal Detais Retrived sucessfully"),
    GA_GET_PERSONAL_DETAILS_DATA_NOT_FOUND(1, "No Personal details found for current User."),
    GA_GET_PERSONAL_DETAILS_POLICY_VIOLATION(2, "Personal details not setted by User."),

    // Responce /error codes for AddAddressBook service
    GA_ADD_ADDRESSBOOK_TRANSACTION_OK(0, "Address saved sucessfully"),

    // Response/error codes For Product Service
    GA_PRODUCT_TRANSACTION_OK(0, "Get ProductBY ID complete successfully"),
    GA_PRODUCT_WRONG_PARAMETERS(1, "Wrong Parameter passed"),
    GA_PRODUCT_INTERNAL(2, "Internal Error."),

    // Responce /error codes for GetAddressBook service
    GA_GET_ADDRESSBOOK_DETAILS_TRANSACTION_OK(0, "Addressbook for user Retrived sucessfully"),
    GA_GET_ADDRESSBOOK_DETAILS_DATA_NOT_FOUND(1, "No Addressbook found for current User."),
    GA_PINCODE_SAVED_SUCCESSFULLY(0, "Pincode saved successfully"),

    // response/error codes for addManufacturerDetails service

    GA_ADD_MANUFACTURER_DETAILS_TRANSACTION_OK(0, "Manufacturer Detais saved sucessfully"),
    GA_ADD_MANUFACTURER_DETAILS_PARAMETER_NOT_FOUND(1, "Required Parameter Not found"),
    GA_ADD_MANUFACTURER_DETAILS_WRONG_PARAMETER(3, "Wrong Parameters"),
    GA_ADD_MANUFACTURER_DETAILS_INTERNAL(2, "Internal Error."),

    // Responce /error codes for AddAddressBook service
    GA_ADD_MOU_TRANSACTION_OK(0, "MOU saved sucessfully"),
    GA_ADD_MOU_INTERNAL_ERROR(1, "Error in save mou."),
    GA_ADD_MOU_PARAMETER_NOT_FOUND(2, "Required Parameter Not found"),

    // Responce /error codes for Change Password service
    GA_CHANGE_PASSWORD_TRANSACTION_OK(0, "Password changed sucessfully"),

    // Responce /error codes for Attribute Master service
    GA_ATTRIBUTE_MASTER_TRANSACTION_OK(0, "Attribute Master sucessful"),
    GA_ATTRIBUTE_MASTER_WRONG_PARAMETER(1, "Wrong parameter passed"),

    // response/error code for getManufacturerdetail service
    GA_GET_MANUFACTURER_DETAILS_TRANSACTION_OK(0, "Manufacturer Detais Retrived sucessfully"),
    GA_GET_MANUFACTURER_DETAILS_PARAMETER_NOT_FOUND(1, "EmailID is required."),
    GA_GET_MANUFACTURER_DETAILS_INTERNAL(2, "Internal Error."),
    GA_GET_MANUFACTURER_DETAILS_DATA_NOT_FOUND(3, "No Manufacturer details found for current User."),
    GA_GET_MANUFACTURER_DETAILS_POLICY_VIOLATION(4, "Manufacturer details not setted by User."),

    // Responce /error codes for Product Catalogueservice
    GA_PRODUCT_CATALOGUE_WAIT_FOR_ADMIN_APPROVAL(0, "Admin apporval pending."),
    GA_PRODUCT_CATALOGUE_TRANSACTION_OK(1, "Product catalogue process success"),
    GA_PRODUCT_CATALOGUE_WRONG_PARAMETER(2, "Wrong parameter passed"),
    GA_PRODUCT_CATALOGUE_MANDATORY_PARAMETER_NOT_SET(3, "Mandatory parameter not set"),
    GA_PRODUCT_CATALOGUE_DATA_NOT_FOUND(4, "Product not found"),
    GA_PRODUCT_CATALOGUE_SET_NOT_FOUND(5, "Product set Details not found"),
    GA_PRODUCT_CATALOGUE_FAILED(6, "Operation on Product Catalogue failed"),
    GA_PRODUCT_CATALOGUE_FACETS_NOT_SET(7, "Facets not set for products"),
    GA_PRODUCT_CATALOGUE_FILTERS_NOT_FOUND(8, "No matching filters found"),

    // Responce /error codes for category service
    GA_CATEGORY_TRANSACTION_OK(0, "Category sucessful"),
    GA_CATEGORY_WORNG_PARAMETER(1, "Wrong parameter passed"),
    GA_CATEGORY_NOT_FOUND(2, "No Category found"),

    // Responce/error for forget Password
    GA_FORGET_PASSWORD_TRANSACTION_OK(0, "Forget Password service completed sucessfully"),

    // Responce /error codes for Pricing service
    GA_PRICING_TRANSACTION_OK(0, "Update Pricing process success"),
    GA_PRICING_WRONG_PARAMETER(1, "Wrong parameter passed"),
    GA_PRICING_MANDATORY_PARAMETER_NOT_SET(2, "Mandatory parameter not set"),
    GA_PRICING_FAILED(3, "Operation on update pricing failed"),

    // Responce/Error code for Insert Product
    GA_INSERT_PRODUCT_TRANSACTION_OK(0, "Insert Product Service completed successfully"),
    GA_INSERT_PRODUCT_FAILED(1, "Insert Product operation failed."),
    GA_INSERT_PRODUCT_POLICY_VIOLATION(2, "Internal Policy violated"),

    // Responce/Error code for GetProductByCategoryID Service
    GA_GET_PRODUCT_TRANSACTION_OK(0, "Get Product service completed successfully"),
    GA_GET_PRODUCT_NOT_FOUND(1, "NO Product Found"),

    // Response / Error code for AddCart
    GA_ADD_CART_TRANSACTION_OK(0, "Product added in cart successfully"),
    GA_ADD_CART_POLICY_VIOLATION(1, "Seller can not have a cart."),
    GA_ADD_CART_PRODUCT_AVAILABLE(2, "This product is already in cart."),

    // Responce/Error code for GETCart
    GA_GET_CART_TRANSACTION_OK(0, "Get Cart successful"),
    GA_GET_CART_POLICY_VIOLATION(1, "Seller doesn't have rights to perform this operation"),
    GA_GET_CART_DATA_NOT_FOUND(2, "No product found in cart"),

    // Responce/Error code for DeleteCart
    GA_DELETE_CART_TRANSACTION_OK(0, "Delete cart successfully"),
    GA_DELETE_CART_POLICY_VIOLATION(1, "Seller doesn't have rights to perform this operation"),
    GA_DELETE_CART_DATA_NOT_FOUND(2, "No product found in cart"),

    // Responce/Error code for UpdateCart
    GA_UPDATE_CART_TRANSACTION_OK(0, "Update cart successfully"),
    GA_UPDATE_CART_POLICY_VIOLATION(1, "Seller doesn't have rights to perform this operation"),
    GA_UPDATE_CART_DATA_NOT_FOUND(2, "Product not available in cart"),
    GA_UPDATE_CART_QUANTITY_NOT_AVAILABLE(3, "Maximum product available at this price is"),
    GA_UPDATE_CART_PRODUCT_NOT_FOUND(4, "No product found in Productlist"),
    GA_UPDATE_CART_NO_PRODUCT_BY_SELLER(5, "No seller available for the requested product"),

    // Response /Error code for Add Order
    GA_ADD_ORDER_TRANSACTION_OK(0, "Order saved Successfully"),
    GA_ADD_ORDER_DATA_NOT_FOUND(1, "Order not created"),
    GA_ADD_ORDER_POLICY_VIOLATION(2, "Internal policy violated."),

    // Response /Error code for Add Order
    GA_GET_BUYER_ORDER_TRANSACTION_OK(0, "Get Order Successfully."),
    GA_GET_BUYER_ORDER_DATA_NOT_FOUND(1, "Order not created."),
    GA_GET_BUYER_ORDER_POLICY_VIOLATION(2, "Order is not available for seller."),

    // Response error code for get User Details
    GA_GET_USER_DETAILS_TRANSACTION_OK(0, "Get User Details completed Successfully"),
    GA_GET_USER_DETAIL_INTERNAL(1, "Get User Detail error"),
    GA_GET_USER_DETAIL_POLICY_VIOLATION(2, "User details not setted by User."),
    GA_GET_USER_DETAIL_NOT_FOUND(3, "User Detail Not found"),

    // Response error code for getOrderListForSeller
    GA_GET_ORDER_SELLER_TRANSACTION_OK(0, "Get orders for seller service completed Successfully"),
    GA_GET_ORDER_SELLER_DATA_NOT_FOUND(1, "No order found for seller"),
    GA_GET_ORDER_SELLER_POLICY_VIOLATION(2, "seller can not generate order"),

    // Response error code for getOrderByOrderId
    GA_GET_ORDER_TRANSACTION_OK(0, "Order retrived Successfully."),
    GA_GET_ORDER_DATA_NOT_FOUND(1, "No Data found"),

    // Response error code for getOrderByOrderId
    GA_ORDER_CANCEL_TRANSACTION_OK(0, "Order cancelled successfully."),
    GA_ORDER_CANCEL_DATA_NOT_FOUND(1, "No Data found"),

    // Response error code for Get Seller Order BY Order Id
    GA_GET_SELLER_ORDER_TRANSACTION_OK(0, "Seller Order retrived Successfully."),
    GA_GET_SELLER_ORDER_DATA_NOT_FOUND(1, "Order not found or order is under approval"),
    GA_GET_SELLER_ORDER_DATA_NOT_APPROVED(2, "Order is available but under approval"),

    // Response error code for Get WhishList BY UserID
    GA_GET_WISHLIST_TRANSACTION_OK(0, "Wishlist retrived Successfully."),
    GA_GET_WISHLIST_DATA_NOT_FOUND(1, "WishList is Empty."),
    GA_GET_WISHLIST_WRONG_PARAMETERS(2, "Incorrect parameter"),
    GA_GET_WISHLIST_FAILED(3, "Operation on fetching wishlist failed."),

    // Response error code for Add to wishlist by userID
    GA_ADD_TO_WISHLIST_TRANSACTION_OK(0, "Added to Wishlist Successfully."),
    GA_ADD_TO_WISHLIST_WRONG_PARAMETER(1, "Wrong Parameter passed."),
    GA_ADD_TO_WISHLIST_FAILED(2, "Add to wishlist operation failed."),

    // Response error code for delete wishlist item by itemID
    GA_DELETE_WISHLIST_TRANSACTION_OK(0, "Deleted from wishlist Successfully."),
    GA_DELETE_WISHLIST_WRONG_PARAMETER(1, "Wrong Parameter passed."),
    GA_DELETE_WISHLIST_FAILED(2, "Delete from wishlist operation failed."),

    // Response error code for Get Seller Order BY Order Id
    GA_OTP_VERIFICATION_TRANSACTION_OK(0, "OTP Verified Successfully."),
    GA_OTP_EXPIRED(1, "OTP expired"),
    GA_OTP_VERIFICATION_WRONG_PARAMETER(2, "Wrong parameter."),
    GA_OTP_VERIFICATION_FAILED(3, "OTP Verification Failed."),

    // Response error code for Get Seller Order BY Order Id
    GA_GENERATE_OTP_TRANSACTION_OK(0, "OTP generated Successfully."),
    GA_GENERATE_OTP_WRONG_PARAMETER(1, "Wrong parameter."),
    GA_GENERATE_OTP_FAILED(2, "OTP generation failed."),

    // Response/error code for Transporter BY transporter Id
    GA_GET_TRANSPORTER_TRANSACTION_OK(0, "Operation Successfully"),
    GA_GET_TRANSPORTER_FAILED(1, "Transporter not found"),

    // Response/error code for Transporter BY pincode
    GA_GET_TRANSPORTER_BY_PINCODE_TRANSACTION_OK(0, "Operation Successfully"),
    GA_GET_TRANSPORTER_BY_PINCODE_FAILED(1, "There is no tranporter for the pincode"),
    GA_GET_TRANSPORTER_BY_PINCODE_NOT_AVAILABLE(2, "Service not available for pincode"),

    // Response/error code for Get Total Product By Seller.
    GA_NO_PRODUCT_BY_SELLER(1, "NO Product has been uploaded by seller"),
    GA_GET_PRODUCT_BY_SELLER_ID_TRANSACTION_OK(0, "Product retrived by seller Id succesfully"),
    GA_GET_PRODUCT_MANADATORY_PARAMETERS_NOT_SET(2, "Mandatory parameters not set"),

    GA_PINCODE_TRANSACTION_OK(0, "service completed successfully"),
    GA_PINCODE_WRONG_PINCODE(1, "Wrong pinocde.Please try again with correct one"),

    GA_ADDRESS_REMOVED_SUCCESSFULLY(0, "Address removed successfully"),
    GA_ADDRESS_DATA_NOT_FOUND(1, "No Address found for user"),

    GA_DEFAULT_ADDRESS_SAVED_SUCCESSFULL(0, "Default Address saved Successfully."),

    GA_WRITE_REVIEW_COMPLETED_SUCCESSFULLY(0, "Write Review service completed successfully"),
    GA_NO_REVIEW_FOUND_FOR_PRODUCT(1, "No Review Found for Product"),

    GA_NEW_SELLER_INFO_ADDED_SUCCESSFULLY(0, "Seller information saved successfully"),
    // Update Product price error/response
    GA_UPDATE_PRODUCT_PRICE_TRANSACTION_OK(0, "Update productPrice successfully"),
    GA_UPDATE_PRODUCT_PRICE_FAILED(1, "Update productPrice failed"),
    GA_UPDATE_PRICE_FAILED(2, "DealPrice should not more than SellingPrice"),

    GA_ADD_INTRESTED_CATEGORIES_TRANSACTION_OK(0, "Intrested Categories saved successfully"),

    // error/response of updateOrderstatus
    GA_ORDER_IS_NOT_APPROVED_OR_DISPATCH(2, "Orderstatus cannot be changed to delivered"),
    GA_ORDER_DISPATCHED_FAILED(3, "Orderstatus cannot be changed to dispatch"),

    GA_ADD_TRANSPORT_DETAILS_TRANSACTION_OK(0, "Transport Details added successfully"),
    GA_ORDER_STATUS_CHANGED_TRANSACTION_OK(0, "Order Status change successfully"),
    GA_ORDER_DELIVERED_FAILED(
            1,
            "Order status cant be changed to Delivered untill dispatched and approved will be true"),
    GA_ORDER_TRANSIST_FAILED(4, "Order status cannot changed to Transist untill approved and dispatch will be true"),
    GA_UPDATE_PRODUCT_QUANTITY_FAILED(1, "Error in update product Quantity"),
    GA_UPDATE_PRODUCT_QUANTITY_TRANSACTION_OK(0, "Product Quantity updated successfully"),
    GA_GET_SELLER_AVAIALBLE_AMT_TRANSACTION_OK(0, "Seller total Availabale amt service complete"),
    GA_GET_SELLER_AVAILABLE_AMT_DATA_NOT_FOUND(1, "Seller Available Amt Data not found"),
    GA_GET_ORDER_SELLER_PENDING_TRANSACTION_OK(0, "Seller Pending Amount service complete"),
    GA_ORSER_SELLER_LEDGER_FAILED(7, "Error in save sellerLedger"),

    GA_GET_SELLER_LEDGER_TRANSACTION_OK(0, "SellerLedgerList retrived"),

    GA_NO_LEDGER_FOR_SELLERID(1, "No ledger found for requested sellerID"),
    GA_GET_PAYOUT_DATA_NOT_FOUND(1, "No payout Detail found"),
    GA_GET_ALL_PAYOUT_DETAIL_TRANSACTION_OK(0, "Get all payment list by seller complete"),
    GA_ERROR_IN_GET_PAYMENT_DETAIL(1, "Error in getpayement List"),
    GA_GET_PAYOUT_DETAIL_TRANSACTION_OK(0, "GEtr Payment etail by seller and payout complete"),
    GA_ERROR_IN_GET_PAYMENT_FOR_SELLER(1, "Error in get payment detail"),

    GA_PRODUCT_OUT_OF_STOCK(5, "Product is out of stock");

    int errorCode;
    String description;

    /**
     * Instantiates a new error codes.
     * 
     * @param errorCode the error code
     * @param description the description
     */
    private ClientErrorCodes(int errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    /**
     * Gets the error code.
     * 
     * @return the error code
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     * 
     * @param errorCode the new error code
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}