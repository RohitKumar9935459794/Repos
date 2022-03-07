package com.dgdgjfm.l.reposproject.model;

public class Users {

    String email,password,confirmPassword,fullName,mobile,companyName,officialEmailAddress,industryType;

    public Users(String confirmPassword,String email, String fullName, String password, String mobile,
                 String companyName, String officialEmailAddress,String industryType) {
        this.email = email;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        this.password = password;
        this.mobile = mobile;
        this.companyName = companyName;
        this.officialEmailAddress = officialEmailAddress;
        this.industryType = industryType;
    }



    public Users(){}

    //company registration
    public Users(String companyName,String officialEmailAddress,String industryType){
        this.industryType=industryType;
        this.officialEmailAddress=officialEmailAddress;
        this.companyName=companyName;
    }

    //basic details
    public Users( String email,String password,String fullName,
                 String mobile){
        this.fullName=fullName;
        this.mobile=mobile;
    }

    //signup constructor
    public Users(String email,String password) {
        this.email = email;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOfficialEmailAddress() {
        return officialEmailAddress;
    }

    public void setOfficialEmailAddress(String officialEmailAddress) {
        this.officialEmailAddress = officialEmailAddress;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }
}
