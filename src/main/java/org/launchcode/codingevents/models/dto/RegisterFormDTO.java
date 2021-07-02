package org.launchcode.codingevents.models.dto;

import org.launchcode.codingevents.models.dto.LoginFormDTO;

public class RegisterFormDTO extends LoginFormDTO {

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}
