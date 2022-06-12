package org.example.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import org.example.service.reader.CsvCreditLimitConverter;
import org.example.service.reader.CsvDateConverter;

public class Model {
    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "Address")
    private String address;
    @CsvBindByName(column = "Postcode")
    private String postcode;
    @CsvBindByName(column = "Phone")
    private String phone;
    @CsvCustomBindByName(column = "Credit Limit", converter = CsvCreditLimitConverter.class)
    private String creditLimit;
    @CsvCustomBindByName(column = "Birthday", converter = CsvDateConverter.class)
    private String birthday;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public enum Field {
        NAME("Name"),
        ADDRESS("Address"),
        POSTCODE("Postcode"),
        PHONE("Phone"),
        CREDIT_LIMIT("Credit Limit"),
        BIRTHDAY("Birthday");

        public final String value;

        Field(String value) {
            this.value = value;
        }
    }
}
