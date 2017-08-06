package redis.main.java.cart;

import java.util.HashSet;
import java.util.Set;

public class a {

	public static void main(String[] args) {
		Set<String> s=new HashSet<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		String[] sessions =  s.toArray(new String[s.size()]);
		System.out.println(sessions[1]);
	}

}
