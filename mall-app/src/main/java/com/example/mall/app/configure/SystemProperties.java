package com.example.mall.app.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@ConfigurationProperties(prefix = "btdata.system")
@Component
public class SystemProperties {

    @Getter
    @Setter
    private String version;

    @Getter
    @Setter
    private int build;

}
