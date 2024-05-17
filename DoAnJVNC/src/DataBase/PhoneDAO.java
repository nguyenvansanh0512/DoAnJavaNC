package DataBase;

import DTO.Phone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneDAO {
private static PhoneDAO instance;
    
    public PhoneDAO() {
    }
    
    public static PhoneDAO getInstance() {
        if (instance == null) {
            instance = new PhoneDAO();
        }
        return instance;
    }
	public List<Phone> GetListDrink() {
        List<Phone> list = new ArrayList<Phone>();
        Connection con = ConnectionDB.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `phone`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Phone drinks = new Phone(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getInt(5));
                list.add(drinks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
