/* bcabcl
 *
 * Copyright (c) 2018 Tushar Girase All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ecabcl
 */
package com.abcl.libmgmt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Model represents the database table
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_title")
    @NotNull
    private String bookTitle;

    @Column(name = "isbin")
    @NotNull
    private String isbin;

    @Column(name = "authors")
    @NotNull
    private String authors;

    @Column(name = "publish_date")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

    @Column(name = "publisher")
    @NotNull
    private String publisher;

    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "stock")
    @NotNull
    private Integer stock;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @param bookTitle
     *            the bookTitle to set
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * @return the isbin
     */
    public String getIsbin() {
        return isbin;
    }

    /**
     * @param isbin
     *            the isbin to set
     */
    public void setIsbin(String isbin) {
        this.isbin = isbin;
    }

    /**
     * @return the authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * @param authors
     *            the authors to set
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * @return the publishDate
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * @param publishDate
     *            the publishDate to set
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher
     *            the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock
     *            the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authors == null) ? 0 : authors.hashCode());
        result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((isbin == null) ? 0 : isbin.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
        result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
        result = prime * result + ((stock == null) ? 0 : stock.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (authors == null) {
            if (other.authors != null)
                return false;
        } else if (!authors.equals(other.authors))
            return false;
        if (bookTitle == null) {
            if (other.bookTitle != null)
                return false;
        } else if (!bookTitle.equals(other.bookTitle))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (isbin == null) {
            if (other.isbin != null)
                return false;
        } else if (!isbin.equals(other.isbin))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (publishDate == null) {
            if (other.publishDate != null)
                return false;
        } else if (!publishDate.equals(other.publishDate))
            return false;
        if (publisher == null) {
            if (other.publisher != null)
                return false;
        } else if (!publisher.equals(other.publisher))
            return false;
        if (stock == null) {
            if (other.stock != null)
                return false;
        } else if (!stock.equals(other.stock))
            return false;
        return true;
    }

}
