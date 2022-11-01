package Bid.Model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table(name="Bidactive3")
public class Bidactive {
    @Id

    private int ProductId;

    private String ProductName;
     private int ProductPrice;


    private Date BidStartDate;

    private Date BidEndDate;
    private int BidAmount;
    private String BidBy;

    public Bidactive() {
    }

    public Bidactive(int productId, String productName, int productPrice, Date bidStartDate, Date bidEndDate, int bidAmount, String bidBy) {
        ProductId = productId;
        ProductName = productName;
        ProductPrice = productPrice;
        BidStartDate = bidStartDate;
        BidEndDate = bidEndDate;
        BidAmount = bidAmount;
        BidBy = bidBy;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(int productPrice) {
        ProductPrice = productPrice;
    }

    public Date getBidStartDate() {
        return BidStartDate;
    }

    public void setBidStartDate(Date bidStartDate) {
        BidStartDate = bidStartDate;
    }

    public Date getBidEndDate() {
        return BidEndDate;
    }

    public void setBidEndDate(Date bidEndDate) {
        BidEndDate = bidEndDate;
    }

    public int getBidAmount() {
        return BidAmount;
    }

    public void setBidAmount(int bidAmount) {
        BidAmount = bidAmount;
    }

    public String getBidBy() {
        return BidBy;
    }

    public void setBidBy(String bidBy) {
        BidBy = bidBy;
    }
}
