package Bid.DAO;

import Bid.Model.Bidactive;
import Bid.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Dao1 implements Dao{
    @Override
    public List<Bidactive> getAllProduct() {
        SessionFactory factory= Utility.getSessionFactory();
        Session session=factory.openSession();
        String queryString="from Bidactive where (BidStartDate=:date and BidEndDate=:date)or(BidStartDate<:date and BidEndDate=:date)or(BidStartDate=:date and BidEndDate>:date) or (BidStartDate<:date and BidEndDate>:date) order by ProductId";
        Query query=session.createQuery(queryString);
        query.setString("date", createDate());
        List <Bidactive> bidactives = query.getResultList();
        session.close();
        return bidactives;
    }

//    @Override
//    public void delete(int id) {
//        SessionFactory factory = Utility.getSessionFactory();
//        Session session = factory.openSession();
//        String query = "delete from Bidactive where ProuctId"
//    }

    public String  createDate()
    {

        LocalDate today = LocalDate.now();

        return today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
    }
    @Override
    public List<Bidactive> getAllProduct1() {
        SessionFactory factory= Utility.getSessionFactory();
        Session session=factory.openSession();
        String queryString="from Bidactive where (BidStartDate>:date and BidEndDate>:date) or (BidStartDate<:date and BidEndDate<:date)  order by ProductId ";
        Query query=session.createQuery(queryString);
        query.setString("date", createDate());
        List<Bidactive> bidactives = query.getResultList();
        session.close();
        return bidactives;
    }

    @Override
    public Bidactive getProduct(int id) {
        SessionFactory factory= Utility.getSessionFactory();
        Session session=factory.openSession();
        session.beginTransaction();
        Bidactive cust= session.get(Bidactive.class,id);
        return cust;

    }

    @Override
    public void updateProduct(int ProductId, String ProductName, int ProductPrice, Date BidStartDate, Date BidEndDate, String BidBy, int BidAmount)
    {
        SessionFactory factory= Utility.getSessionFactory();
        Session session=factory.openSession();
        session.beginTransaction();
        String queryString1="select BidAmount from Bidactive where ProductId=:ProductId";
        Query query1 = session.createQuery(queryString1);
        query1.setInteger("ProductId", ProductId);
        int amount = (int) query1.getSingleResult();
        if((ProductPrice<=BidAmount)&&(BidAmount>=amount))
        {
            String queryString = "update Bidactive set ProductName=:ProductName,ProductPrice=:ProductPrice,BidStartDate=:BidStartDate,BidEndDate=:BidEndDate,BidBy=:BidBy,BidAmount=:BidAmount where ProductId=:ProductId";
            Query query = session.createQuery(queryString);
            query.setString("ProductName", ProductName);
            query.setInteger("ProductPrice", ProductPrice);
            query.setDate("BidStartDate", BidStartDate);
            query.setDate("BidEndDate", BidEndDate);
            query.setString("BidBy", BidBy);
            query.setInteger("BidAmount", BidAmount);

            query.setInteger("ProductId", ProductId);

            int result = query.executeUpdate();
            System.out.println(result + "rows updated");
        }
        session.getTransaction().commit();
        session.close();

    }
}
