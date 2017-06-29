package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by draqo on 28.06.2017.
 */
@Entity
public class Books {
    private int idbooks;
    private String bookName;
    private String authorName;
    private String description;
    private Integer year;

    @Id
    @Column(name = "idbooks")
    public int getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(int idbooks) {
        this.idbooks = idbooks;
    }

    @Basic
    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "author_name")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (idbooks != books.idbooks) return false;
        if (bookName != null ? !bookName.equals(books.bookName) : books.bookName != null) return false;
        if (authorName != null ? !authorName.equals(books.authorName) : books.authorName != null) return false;
        if (description != null ? !description.equals(books.description) : books.description != null) return false;
        if (year != null ? !year.equals(books.year) : books.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idbooks;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Books{" +
                "idbooks=" + idbooks +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                '}';
    }
}
