package Bid.Service;

import Bid.DAO.Dao1;
import Bid.Model.Bidactive;
import Bid.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class ProductServicesImp implements ProductServices {

    Dao1 d = new Dao1();
    @Override
    public void addProduct(Bidactive bidactive) {
        SessionFactory factory= Utility.getSessionFactory();
        Session session= factory.openSession();
        session.beginTransaction();
        session.save(bidactive);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Bidactive> showProduct() {
        List<Bidactive> bidactives= d.getAllProduct();
        return bidactives;
    }

//    @Override
//    public void delete(int id) {
//        d.delete(id);
//    }

    @Override
    public void updateProduct(int ProductId, String ProductName, int ProductPrice, Date BidStartDate, Date BidEndDate, String BidBy, int BidAmount) {
        d.updateProduct( ProductId,  ProductName, ProductPrice,BidStartDate, BidEndDate,  BidBy, BidAmount);
    }

    @Override
    public List<Bidactive> showProduct1() {
        List<Bidactive> bidactives= d.getAllProduct1();
        return bidactives;
    }
}
