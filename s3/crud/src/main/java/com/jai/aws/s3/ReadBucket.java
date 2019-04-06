package com.jai.aws.s3;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.nio.file.Paths;

public class ReadBucket {

    static final String bucket = "jaybucket2000";
    static final String key = "1";

    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().region(Region.EU_WEST_1).build();

        GetObjectRequest request = GetObjectRequest.builder().bucket(bucket).key(key).build();
        GetObjectResponse response = s3Client.getObject(request, Paths.get("src/main/resources/out/read.txt"));
        System.out.println(response);
        s3Client.close();

    }
}
