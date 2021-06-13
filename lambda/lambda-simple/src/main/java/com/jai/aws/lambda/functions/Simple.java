package com.jai.aws.lambda.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Simple implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
        return toString().toUpperCase() + " case changed to uppercase using hello simple lambda ";
    }
}


