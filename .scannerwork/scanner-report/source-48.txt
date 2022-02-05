package com.example.buylap.model.users;

public class ModelSeller extends ModelUser{
    public static final String TEST_USERNAME = "tester-seller";
    private String companyName;
    public ModelSeller(String username, String email, String password) {
        super(username, email, password);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
