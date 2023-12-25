package skbx.example.struct.book;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "DATE NOT NULL")
    private Date pub_date;

    @Column(columnDefinition = "SMALLINT NOT NULL")
    private short is_bestseller;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;
    @Column(columnDefinition = "VARCHAR(255)")
    private String image;
    @Column(columnDefinition = "TEXT")
    private String description ;
    @Column(columnDefinition = "INT NOT NULL")
    private Integer price;
    @Column(columnDefinition = "SMALLINT NOT NULL DEFAULT 0")
    private short discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public short getIs_bestseller() {
        return is_bestseller;
    }

    public void setIs_bestseller(short is_bestseller) {
        this.is_bestseller = is_bestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }
}
