package com.jai.aws.s3;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ListObjectsV2Result;

public class ReadBucket {

    //static String bucket = "jjaytest";  // private
    static String bucket = "jaybucket2000";  // public

    public static void main(String[] args) {

        AmazonS3 s3 = AmazonS3Client.builder().withRegion(Regions.EU_WEST_1).build();


        if(s3.doesBucketExistV2(bucket)){

            ListObjectsV2Result result =  s3.listObjectsV2(bucket);

            System.out.println(result.getObjectSummaries());


//            System.out.println(s3.listBuckets());

            String s = s3.getObjectAsString(bucket,"1");
            System.out.println("data : " +s);

            // System.out.println(Regions.getCurrentRegion());

        }
    }

    private String readStream() {
        return null;
    }
}
