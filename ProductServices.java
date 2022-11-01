package Bid.Service;

import Bid.Model.Bidactive;

import java.sql.Date;
import java.util.List;

public interface ProductServices {
    public void addProduct(Bidactive bidactive);
    public List<Bidactive> showProduct();
    public List<Bidactive> showProduct1();
    public void updateProduct(int ProductId, String ProductName, int ProductPrice, Date BidStartDate,Date BidEndDate,String BidBy,int BidAmount);
    //public void delete(int id);

}
