package cn.zcbigdata.mybits_demo.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CheckLoginUtil {
	
	public static boolean check(HttpServletRequest request) {
		HttpSession session = request.getSession(); 
		if (session.getAttribute("userid") != null) {
			return true;
		}else {
			return false;
		}
	}
}
