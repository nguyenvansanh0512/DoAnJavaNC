package DataBase;



import DTO.Account;
import DTO.AccountKH;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRI
 */
public class AccountKHDAO {

    private static AccountKHDAO instance;
    AccountKH account = new AccountKH();

    public AccountKHDAO() {
    }

    public static AccountKHDAO getInstance() {
        if (instance == null) {
            instance = new AccountKHDAO();
        }
        return instance;
    }

    public static void setInstance(AccountKHDAO instance) {
        AccountKHDAO.instance = instance;
    }
    public Boolean Login(String username, String password) {
        Connection con = ConnectionDB.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `accountkh` WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public AccountKH GetAccountKH() {
        return account;
    }

}