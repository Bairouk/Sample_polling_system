package metier;

import DAO.db_interaction;
import entities._person;
import entities._user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class _user_dao_impl implements _user_dao {

    private static Connection conn ;
    public  _user _login(_user _curr_user) {

        conn = db_interaction._get_connection();
        _user _new_user = null;
        String sql = "select * from user where Email= ? and Password= ? ";
        PreparedStatement pstmnt = null;
        try {
            pstmnt = conn.prepareStatement(sql);
            pstmnt.setString(1,_curr_user.get_email());
            pstmnt.setString(2,_curr_user.get_password());
            ResultSet rs = pstmnt.executeQuery();
            if(rs.next()) {
                _new_user = new _user();
                _new_user = get_user_Rs(rs);
                return _new_user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _new_user;
    }

    private _user get_user_Rs(ResultSet rs) {

        _user _new_user= null;
        try {
            _new_user = new _user();
            _new_user.set_id(rs.getLong("UserId"));
            _new_user.set_first_name(rs.getString("FirstName"));
            _new_user.set_last_name(rs.getString("LastName"));
            _new_user.set_email(rs.getString("Email"));
            _new_user.set_gender(rs.getString("Gender"));
            _new_user.set_nationality(rs.getString("Nationality"));
            _new_user.set_birth_date(rs.getString("BirthDate"));
            _new_user.set_is_active(Integer.parseInt(rs.getString("IsActive")));
            _new_user.set_profile_img(rs.getString("ProfileImage"));
            return _new_user;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _new_user;


    }

    @Override
    public _user _get_user_by_id(Long id) {
        return null;
    }

    @Override
    public _user _save_user(_user user) {
        return null;
    }

    @Override
    public List<_user> _get_all_users() {
        return null;
    }



}
