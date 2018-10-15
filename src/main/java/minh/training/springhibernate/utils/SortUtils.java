package minh.training.springhibernate.utils;

import org.hibernate.criterion.Order;

import minh.training.springhibernate.screenmodels.CustomerSearchData;

public class SortUtils {
	public static Order transtate(String name, String command){
		if (command.equals("&#9650;"))
			return Order.asc(name);
		return Order.desc(name);
	}
	public static String getReverseSort(String orSort){
		if (null == orSort)
			return "&#9660;";
		if (orSort.equals("&#9660;")){
			return "&#9650";
		}
		return "&#9660;";
	}
	public static Order getSort(CustomerSearchData orSort){
		/*if (null == orSort)
			return "&#9660";
		if (orSort.equals("&#9660")){
			return "&#9650";
		}
		return "&#9660";*/
		if (null != orSort.getSortName() && !orSort.getSortName().isEmpty())
			return transtate("name", orSort.getSortName());
		if (null != orSort.getSortDob() && !orSort.getSortDob().isEmpty())
			return transtate("dateOfBirth", orSort.getSortDob());
		if (null != orSort.getSortPhone() && !orSort.getSortPhone().isEmpty())
			return transtate("phone", orSort.getSortPhone());
		if (null != orSort.getSortEmail() && !orSort.getSortEmail().isEmpty())
			return transtate("email", orSort.getSortEmail());
		return null;
	}
}
