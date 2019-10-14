package com.ss.lms.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "tbl_publisher", schema = "Library")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer publisherId;

    @NotBlank(message = "Publisher Name Cannot Be Blank")
    private String publisherName;

    private String publisherAddress;
    private String publisherPhone;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherPhone() {
        return publisherPhone;
    }

    public void setPublisherPhone(String publisherPhone) {
        this.publisherPhone = publisherPhone;
    }
}
