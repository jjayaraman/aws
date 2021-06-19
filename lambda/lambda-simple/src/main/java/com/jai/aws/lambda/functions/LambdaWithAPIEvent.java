package com.jai.aws.lambda.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * A lambda which hands API Gateway event
 *
 */
public class LambdaWithAPIEvent implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {

        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(222);
        String body = "{\"age\", \"10\"}";
        responseEvent.setBody(body);

        Map<String, String> headers = new HashMap<>();
        headers.put("X_MY_OWN_HEADER", "My own header");
        responseEvent.setHeaders(headers);
        return responseEvent;
    }
}
