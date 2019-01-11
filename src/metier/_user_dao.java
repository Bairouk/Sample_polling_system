package metier;

import entities._user;

import java.util.List;

public interface  _user_dao {

    public  _user _login(_user user);

    public _user _get_user_by_id(Long id);
    public _user _save_user(_user user);
    public List<_user> _get_all_users();




}
