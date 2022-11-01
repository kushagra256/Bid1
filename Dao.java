package Bid.DAO;

import Bid.Model.Bidactive;

import java.sql.Date;
import java.util.List;

public interface Dao {
    public List<Bidactive> getAllProduct();
    public List<Bidactive> getAllProduct1();

    public Bidactive getProduct(int id);
    public void updateProduct(int ProductId, String ProductName, int ProductPrice, Date BidStartDate, Date BidEndDate, String BidBy, int BidAmount);
    //public void delete(int id);
}
