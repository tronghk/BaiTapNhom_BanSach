package BUS;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import DAO.user;
import DAO.usersDAO;

public class userBUS {
	static ArrayList<user> arrUser;
	private usersDAO userDAO;
	
	
	
	public usersDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(usersDAO userDAO) {
		this.userDAO = userDAO;
	}
	//thêm tài khoản
	public String AddUser(user us) {
		if(!checkDuplicate(us))
			return "Error Duplicate";          //thông báo lỗi trùng lặp tên tài khoản
		else if (!checkGmail(us))				//thông báo mail không hợp lệ 
			return "Error Gmail";
		else if(checkEmptyPassword(us))
			return "Error Empty password";		// thông báo lỗi không nhập password
		else if(!checkPassswordInvalid(us))
			return "Error password invilid";	// thông báo lỗi password không hợp lệ
		else {
			userBUS.arrUser.add(us);
			this.getUserDAO().addObject(us);
			return "Success";
		}
	}
	
	//kiểm tra tài khoản gmail hợp lệ
	public boolean checkGmail(user us) {
		Pattern s = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z](.[a-zA-z]+){1,3}$");
		if(s.matcher(us.getUsers()).find())
			return true;
		return false;
	}
	
	//kiểm tra trùng lặp tài khoản
	public boolean checkDuplicate(user us) {
		for(user value: userBUS.arrUser) {
			if(value.getUsers().equals(us.getUsers()))
				return true;
		}
		return false;
	}
	
	//kiểm tra tài khoản có độ dài trên 3
	public boolean checkSize(user us) {
		return us.getUsers().length() >= 3;
	}
	
	//kiểm tra mật khẩu rỗng
	public boolean checkEmptyPassword(user us) {
		return us.getPassword().length() == 0;
	}
	
	//kiểm tra in hoa in thường kí tự chuỗi mật khẩu
	public boolean checkPassswordInvalid(user us) {
		if(myString.checkUpChar(us.getPassword()) && myString.checkLowChar(us.getPassword())
				&& myString.checkSpecialChar(us.getPassword()))
			return true;
		return false;
	}
	
	//kiểm tra mật khẩu mới hợp lệ
	public String modifyPassword(user us) {
		if(!checkDuplicate(us))
			return "Error Duplicate";
		else if(!checkSize(us))
			return "Error Size";
		else if(checkEmptyPassword(us))
			return "Error Empty password";
		else if(!checkPassswordInvalid(us))
			return "Error password invilid";
		else {
			changeNewPassword(us);
			this.getUserDAO().modifyUser(us);
			return "Success";
		}
	}
	
	
	//lưu mật khẩu mới vào arraylist
	public void changeNewPassword(user us) {
		for(user value: userBUS.arrUser) {
			if(value.getUsers().equals(us.getUsers()))
				value.setPassword(us.getPassword());
		}
	}
	
	
	//xử lý đổi mật khẩu
	public String changePassword(user us, String oldPassword, String newPassword, String repeatPaswword) {
		if(!checkOldPasswordDuplicate(us.getPassword(), oldPassword))
			return "Error oldPassword";
		else if(!checkNewPasswordDuplicate(newPassword, repeatPaswword))
			return "Error new password not duplicate";
		else	{
			us.setPassword(newPassword);
			return modifyPassword(us);
			}
	}
	
	
	//kiểm tra 2 mật khẩu vừa nhập giống nhau 
	public boolean checkNewPasswordDuplicate(String newPassword, String repeatPassword) {
		return newPassword.equals(repeatPassword);
	}
	
	
	// kiểm tra mật khẩu cũ có trùng mk vừa nhập
	public boolean checkOldPasswordDuplicate(String oldPassword, String InputOldPassword) {
		return oldPassword.equals(InputOldPassword);
	}
	
	//tạo tài khoản trả về hệ thống view
	public user createUser(String us, String password) {
		user user = new user(us, password,"Đang hoạt động");
		return user;
	}
	
	//kiểm tra thông tin người dùng hợp lệ
	public boolean checkUserInvalid(String btn_user, String btn_pass) {
		for(user value: userBUS.arrUser)
			if(value.getUsers().equals(btn_user) && value.getPassword().equals(btn_pass))
				return true;
		return false;
	}
	
	
	
		
		
}
