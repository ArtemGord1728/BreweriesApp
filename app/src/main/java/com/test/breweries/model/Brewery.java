package com.test.breweries.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.test.breweries.common.AppConstants;

import java.util.Date;
import java.util.List;


@Entity(tableName = AppConstants.TABLE_NAME)
public class Brewery
{
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "brewery_type")
    @SerializedName("brewery_type")
    private String brewery_type;

    @ColumnInfo(name = "street")
    @SerializedName("street")
    private String street;

    @ColumnInfo(name = "city")
    @SerializedName("city")
    private String city;

    @ColumnInfo(name = "state")
    @SerializedName("state")
    private String state;

    @ColumnInfo(name = "postal_code")
    @SerializedName("postal_code")
    private String postal_code;

    @ColumnInfo(name = "country")
    @SerializedName("country")
    private String country;

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    private String longitude;

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    private String latitude;

    @ColumnInfo(name = "phone")
    @SerializedName("phone")
    private String phone;

    @ColumnInfo(name = "website_url")
    @SerializedName("website_url")
    private String website_url;


    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    @SerializedName("updated_at")
    @Ignore
    private Date updated_at;

    @Ignore
    private List<Tag> tag_list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery_type() {
        return brewery_type;
    }

    public void setBrewery_type(String brewery_type) {
        this.brewery_type = brewery_type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



//    public Date getUpdated_at() {
//        return updated_at;
//    }
//
//    public void setUpdated_at(Date updated_at) {
//        this.updated_at = updated_at;
//    }

//    public List<Tag> getTag_list() {
//        return tag_list;
//    }
//
//    public void setTag_list(List<Tag> tag_list) {
//        this.tag_list = tag_list;
//    }
}
