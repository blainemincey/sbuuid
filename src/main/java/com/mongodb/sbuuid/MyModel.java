package com.mongodb.sbuuid;

import com.github.javafaker.Faker;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "myCollection")
public class MyModel {
    @Id
    public String id;

    // Random properties
    public String name;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String ssn;
    public String email;
    public long uniqueSequence;

    public MyModel() {
    }

    public MyModel(long uniqueSequence) {
        Faker faker = new Faker();
        this.setName(faker.name().fullName());
        this.setAddress(faker.address().streetAddress());
        this.setCity(faker.address().city());
        this.setState(faker.address().state());
        this.setZip(faker.address().zipCode());
        this.setSsn(faker.idNumber().ssnValid());
        this.setEmail(faker.internet().emailAddress());
        this.setUniqueSequence(uniqueSequence);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUniqueSequence() {
        return uniqueSequence;
    }

    public void setUniqueSequence(long uniqueSequence) {
        this.uniqueSequence = uniqueSequence;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", ssn='" + ssn + '\'' +
                ", email='" + email + '\'' +
                ", uniqueSequence=" + uniqueSequence +
                '}';
    }
}
