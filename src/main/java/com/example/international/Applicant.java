package com.example.international;

public class Applicant {
    String FirstName;
    String LastName;
    String Email;
    String Address;
    String Gender;
    String Religon;
    int Age;
    int ApplicantId;
    String Mobile;
    String PassportNum;
    String PassportISsue;
    String Passportexp;
    //Blob profileImg;
    //File MedicalReport;
    String Experience;
    String Field;
    String Place;
    String Nic;
    String Nationality;

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public Applicant(String firstName, String lastName, String email, String address, String gender, String religon, int age, int applicantId, String mobile, String passportNum, String passportISsue, String passportexp, String experience, String field, String place,String nic,String nationality) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Address = address;
        Gender = gender;
        Religon = religon;
        Age = age;
        ApplicantId = applicantId;
        Mobile = mobile;
        PassportNum = passportNum;
        PassportISsue = passportISsue;
        Passportexp = passportexp;
//        this.profileImg = profileImg;
//        MedicalReport = medicalReport;
        Experience = experience;
        Field = field;
        Place=place;
        Nationality=nationality;
        Nic=nic;
    }

    public  String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }



    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getReligon() {
        return Religon;
    }

    public void setReligon(String religon) {
        Religon = religon;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getApplicantId() {
        return ApplicantId;
    }

    public void setApplicantId(int applicantId) {
        ApplicantId = applicantId;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPassportNum() {
        return PassportNum;
    }

    public void setPassportNum(String passportNum) {
        PassportNum = passportNum;
    }

    public String getPassportISsue() {
        return PassportISsue;
    }

    public void setPassportISsue(String passportISsue) {
        PassportISsue = passportISsue;
    }

    public String getPassportexp() {
        return Passportexp;
    }

    public void setPassportexp(String passportexp) {
        Passportexp = passportexp;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }
//    public File getProfileImg() {
//        return profileImg;
//    }
//
//    public void setProfileImg(File profileImg) {
//        this.profileImg = profileImg;
//    }
//
//    public File getMedicalReport() {
//        return MedicalReport;
//    }
//
//    public void setMedicalReport(File medicalReport) {
//        MedicalReport = medicalReport;
//    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }
}
