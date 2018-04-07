package com.bobsbest.pestcontrol.config;

import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRdsInstance(
        dbInstanceIdentifier = "bobs-best-pest-control",
        password = "${rdsPassword}",
        username = "bobsbest_it"
)
public class JdbcConfiguration {
}
