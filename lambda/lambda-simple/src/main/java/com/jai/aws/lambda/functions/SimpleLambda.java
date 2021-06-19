package com.jai.aws.lambda.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleLambda implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        return input.toString().toUpperCase() + " case changed to uppercase using hello simple lambda ";
    }
}


