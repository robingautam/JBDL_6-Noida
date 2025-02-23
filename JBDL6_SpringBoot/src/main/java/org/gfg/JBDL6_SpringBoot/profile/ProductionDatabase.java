package org.gfg.JBDL6_SpringBoot.profile;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("production")
@Component
public class ProductionDatabase implements DatabaseConfiguration{
    @Override
    public void databaseName() {
        System.out.println("inside the production database class");
    }
}
