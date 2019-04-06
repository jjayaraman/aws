package com.jai.aws.s3;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Paths;

public class UploadFile {

    static final String bucketName = "jaybucket2000";
    static final String key = "1";

    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().region(Region.EU_WEST_1).build();
        PutObjectRequest request = PutObjectRequest.builder().bucket(bucketName).key(key).build();
        s3Client.putObject(request, Paths.get("src/main/resources/1.txt"));

        s3Client.close();
    }
}
