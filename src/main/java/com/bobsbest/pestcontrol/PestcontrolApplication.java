package com.bobsbest.pestcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({
        "spring/aws.xml"
})
public class PestcontrolApplication {

    public static void main(String[] args) {
        SpringApplication.run(PestcontrolApplication.class, args);
    }
}
