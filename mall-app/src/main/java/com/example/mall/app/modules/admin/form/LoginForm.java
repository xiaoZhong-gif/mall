package com.example.mall.app.modules.admin.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class LoginForm implements Serializable {
    @Size(min = 6)
    @NotEmpty
    @NotNull
    private String userName;

    @Size(min = 6, max = 16)
    @Pattern(regexp = "^[\\w_-]{6,16}$")
    private String password;

    @NotEmpty
    @NotNull
    private String captcha;

    @Size(min = 36, max = 36)
    @NotEmpty
    @NotNull
    private String uuid;
}
