package com.jai.aws.s3;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;

public class CreateBucket {

    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().region(Region.EU_WEST_1).build();
        CreateBucketRequest request = CreateBucketRequest.builder().bucket("jaybucket2000").build();
        CreateBucketResponse response =  s3Client.createBucket(request);
        System.out.println("response :: " +response);

        s3Client.close();
    }
}
