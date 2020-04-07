package com.jai.aws.s3;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.apache.http.client.utils.DateUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class UploadFile {

    //static String bucket = "jaybucket2000";  // public
    static String bucket = "jjaytest";  // private

    public static void main(String[] args) {

        AmazonS3 s3 = AmazonS3Client.builder().withRegion(Regions.EU_WEST_2).build();

        try {
            Instant start = Instant.now();
            //String file = "aws_sdk_1_11/src/main/resources/ONSPD_FEB_2018_UK_B.csv";
            System.out.println(System.getProperty("user.home"));
            String file = "/Users/jay/hello.txt";
            Path path = Paths.get(file);

            System.out.println("uploading....");
            String key = DateUtils.formatDate(new Date(), "YYYYMMddhhmmss");

            s3.putObject(bucket, "first/" +key, Files.newInputStream(path), null);
            Instant end = Instant.now();

            System.out.println("done in " + Duration.between(start, end));

        } catch (IOException e) {
            e.printStackTrace();
        }
//

    }
}
