package com.neoris.account.management;

import com.neoris.account.config.AccountConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import({AccountConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.neoris.account"})
public class accountApplicationTest {

}
