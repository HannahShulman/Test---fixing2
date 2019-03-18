package com.cheetah.test.testing.api


/**
 * This class is responsible for holding static information for network calls and API.
 */

object APIConfiguration{

    /**
     * Sets default base url to the server
     */

    const val API_URL =  "http://www.mocky.io/v2/"

    /**
     * Sets the default timeout for new connections. A value of 0 means no timeout,
     * otherwise values must be between 1 and {@link Integer#MAX_VALUE} when converted to
     * milliseconds.
     */
    const val TIMEOUT_IN_SEC: Int = 10

}