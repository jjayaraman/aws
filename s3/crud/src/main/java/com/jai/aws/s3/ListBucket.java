package com.jai.aws.s3;


import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.util.List;

public class ListBucket {

    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().region(Region.EU_WEST_1).build();
        ListBucketsResponse response = s3Client.listBuckets();

        List<Bucket> buckets = response.buckets();

        for (Bucket bucket : buckets) {
            System.out.println(bucket.name());
        }
    }
}
