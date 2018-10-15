package minh.training.springhibernate.utils;

public class MyCommonUtils {
	public static final Integer PAGE_SIZE = 5;
	public static boolean isUpperExist(String s){
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (Character.isUpperCase(c))
				return true;
		}
		return false;
	}
}
