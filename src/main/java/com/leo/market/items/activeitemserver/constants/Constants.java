package com.leo.market.items.activeitemserver.constants;

public class Constants {

    // presentation layer stuff
    public static String GENERIC_RESPONSE_JSON(String responseMessage){
        return "{\"Response\": \"" + responseMessage + "\"}";
    }
    public static final String MISSING_PARAMS_JSON = "{\"Response\": \"Request is missing required parameters\"}";
    public static final String INVALID_ID_JSON = "{\"Response\": \"Invalid item id in request\"}";
    public static final String ID_NOT_FOUND_JSON = "{\"Response\": \"ID not found\"}";
    public static final String ITEM_DELETED_JSON = "{\"Response\": \"Item deactivation successful\"}";

    // Service layer things


}
