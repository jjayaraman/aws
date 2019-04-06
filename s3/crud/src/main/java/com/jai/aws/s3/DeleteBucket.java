package com.jai.aws.s3;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;

public class DeleteBucket {


    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().region(Region.EU_WEST_1).build();
        String bucketName = "jaybucket1000";
        DeleteBucketRequest request = DeleteBucketRequest.builder().bucket(bucketName).build();
        s3Client.deleteBucket(request);

    }
}
