package minh.training.springhibernate.utils;

public class MyValidationUtils {
	public static boolean checkFieldNotNullWithValue(Object field, Object value){
		if (null == field)
			return false;
		if (field instanceof String)
			return !field.toString().trim().equals(value.toString().trim());
		if (field instanceof Boolean)
			return field != value;
		if (field instanceof java.util.Date)
			return !field.equals(value);
		return false;
	}
}
