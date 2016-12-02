package bookzilla;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Bookzilla {
	private static long public_key, private_key, for_modulo;	
	static long powmod(long nr, long k, long m){
		if (k == 0)
			return 1;
		return ( ((k % 2 == 1)?nr:1) * powmod((nr * nr )%m, k / 2, m)) % m;
	}
	static long pow(long n, long k){
		if (k == 0)
			return 1;
		return ((k%2==1)?1:n) * pow(n * n, k / 2);
	}
	static boolean is_prime_larger5000(long nr){
		if (nr < 5000 || nr % 2 == 0 )
			return false;
		for (int i = 3; i * i <= nr; i++)
			if (nr % i == 0)
				return false;
		return true;
	}
	static long generate_prime(){
		final Random rand = new Random();
		long ret;
		do{
			ret = rand.nextLong()%9000;
		}while (is_prime_larger5000(ret) == false);
		return ret;		
	}
	static long cmmdc(long a, long b){
		if (b == 0)
			return a;
		return cmmdc(b, a %b);
	}
	static long modular_multiplicative_inverse(long a, long n){
//		taken from wikipedia RSA_(cryptosystem)#Operation
		long t = 0, nt = 1, r = n, nr = a % n, q, tmp;
		while (nr != 0){
			q = r / nr;
			tmp = nt;
			nt = t - q * nt;
			t = tmp;
			tmp = nr;
			nr = r - q * nr;
			r = tmp;
		}
		if (r > 1)
			return -1;
		if (t < 0)
			t += n;
		return t;
	}
	static void initialize_keys(){
		long a, b, phi;
		a = generate_prime();
		b = generate_prime();
		for_modulo = a * b;
		phi = (a - 1) * (b - 1);
		do{
			public_key = generate_prime();
		} while (cmmdc(public_key,phi) != 1);
		private_key = modular_multiplicative_inverse(public_key, phi);
	}
	static long get_public_key(){
		if (public_key == 0)
			initialize_keys();
		return public_key;
	}
	static long get_for_modulo(){
		if (for_modulo == 0)
			initialize_keys();
		return for_modulo;
	}
	static long code(long message){
		return powmod(message, public_key, for_modulo);
	}
	static long decode(long message){
		return powmod(message, private_key, for_modulo);
	}
	static JSONObject create_username(String username, long password){
		JSONObject ret = new JSONObject();
		try{
			File file = new File("utilizatori//" + username);
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			if (file.exists()){
				ret.put("status","Username already taken");
				return ret;
			}
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.println(decode(password));
			writer.close();
			ret.put("status",  "OK");
		} catch (IOException e){
			e.printStackTrace();
			ret.put("status",  "Unknown error");
		}
		return ret;
	}
	static JSONObject login(String username, long password){
		Scanner scanner;
		JSONObject ret = new JSONObject();
		try {
			scanner = new Scanner(new File ("utilizatori//" + username));
			long parola;
			parola = scanner.nextLong();
			if (parola == decode(password))
				ret.put("status", "OK");
			else
				ret.put("status", "Wrong Password");
			scanner.close();
			return ret;
		} catch (FileNotFoundException e) {
			ret.put("status", "Username not found");
			return ret;
		}
	}
	static JSONObject get_ratings(String username){
		JSONObject ret = new JSONObject();
		JSONObject current;
		JSONArray list_users = new JSONArray();
		int sum = 0, nr = 0, feedback = 0;
		String user;
		try {
			Scanner scanner = new Scanner(new File("utilizatori//" + username));
			scanner.nextLong();
			while(scanner.hasNext()){
				user = scanner.next();
				if (!scanner.hasNextInt())
					break;
				feedback = scanner.nextInt();
				sum += feedback;
				nr++;
				current = new JSONObject();
				current.put("user", user);
				current.put("feedback",  feedback);
				list_users.add(current);
			}
			ret.put("lista", list_users);
			ret.put("average", ((float)sum ) / nr);
			ret.put("status",  "OK");
		}catch (FileNotFoundException e){
			ret.put("status",  "no such user");
		}
		return ret;
	}
	static JSONObject add_feedback(String user_leaving_feedback, long password, String user_receiving_feedback, int feedback){
		JSONObject ret = new JSONObject();
		ret = login(user_leaving_feedback, password);
		if (!ret.get("status").equals("OK"))
			return ret;
		try {
			long parola;
			String user;
			Integer user_feedback;
			HashMap<String,Integer> feedbackuri = new HashMap();
			Scanner scanner = new Scanner(new File("utilizatori//" + user_receiving_feedback));
			parola = scanner.nextLong();
			while (scanner.hasNext()){
				user = scanner.next();
				if (!scanner.hasNextInt())
					break;
				user_feedback = scanner.nextInt();
				feedbackuri.put(user, user_feedback);
			}
			feedbackuri.put(user_leaving_feedback, feedback);
			scanner.close();
			File file = new File("utilizatori//" + user_receiving_feedback);
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.println(parola);
			Iterator it = feedbackuri.entrySet().iterator();
			Map.Entry f;
			while (it.hasNext()){
				f = (Map.Entry)it.next();
				writer.println(f.getKey() + " " + f.getValue());
			}
			writer.close();
		} catch (FileNotFoundException e){
			ret.put("status", "user " + user_receiving_feedback + " not found");
		} catch (Exception e){
			ret.put("status", "Unknown error");
		}
		return ret;
		
	}
	static JSONObject introduce_book(String username, long password, String category, String city, String author, String title, String content){
		JSONObject ret;
		ret = login(username, password);
		if (!ret.get("status").equals("OK"))
			return ret;
		File file = new File("carti//" + category + "//" + city + "//" + author + "//" + username + "//" + title);
		if (!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		try{
			FileWriter writer = new FileWriter(file);
			writer.write(content);
			writer.close();
		} catch(IOException e){
			e.printStackTrace();
			ret.put("status", "error introducing book");
		}
		return ret;
	}
	static class Books{
		String category;
		String city;
		String author;
		String username;
		String title;
		public Books(String category, String city, String author, String username, String title) {
			this.category = category;
			this.city = city;
			this.author = author;
			this.username = username;
			this.title = title;
		}
	}
	static void seek_path(ArrayList<String> till_now, ArrayList<String> to_seek, ArrayList<Books> ret, File dir){
		 if (to_seek.size() == 0){
			 ret.add(new Books(till_now.get(0), till_now.get(1), till_now.get(2),till_now.get(3), till_now.get(4)));
			 return;
		 }
		 String criteriu;
		 if (to_seek.get(0) != null){
			 criteriu = new String(to_seek.get(0).toLowerCase());
		 }
		 else{
			 criteriu = null;
		 }
		 to_seek.remove(0);
		 for (File dir_nou : dir.listFiles() ){
			 if (criteriu == null || dir_nou.getName().toLowerCase().contains(criteriu)){
				 till_now.add(dir_nou.getName());
				 seek_path(till_now, to_seek, ret, dir_nou);
				 till_now.remove(till_now.size() - 1);
				 }
		 }
		 to_seek.add(0, criteriu);
	}
	static JSONObject get_books(final String username, final String category, final String city, final String author, final String title){
		JSONObject ret = new JSONObject();
		JSONArray ret_list = new JSONArray();
		try{
			File dir_mare = new File("carti");
			ArrayList<String> till_now = new ArrayList<String>();
			ArrayList<String> to_seek = new ArrayList<String>();
			to_seek.add(category);
			to_seek.add(city);
			to_seek.add(author);
			to_seek.add(username);
			to_seek.add(title);
			ArrayList<Books> booklist = new ArrayList<Books>();
			seek_path(till_now, to_seek, booklist, dir_mare);
			for (Books carte: booklist){
				JSONObject c = new JSONObject();
				c.put("category", carte.category);
				c.put("city", carte.city);
				c.put("author", carte.author);
				c.put("username",  carte.username);
				c.put("title", carte.title);				
				ret_list.add(c);
			}
			ret.put("lista", ret_list);
			return ret;
		} catch (Exception e){
			ret.put("lista", ret_list);
			return ret;
		}
	}
	static JSONObject obtain_book_description(String category, String city, String author, String user, String title){
		JSONObject ret = new JSONObject();
		try {
			File file = new File("carti//" + category + "//" + city + "//" + author + "//" + user + "//" + title);
			String content = new Scanner(file).useDelimiter("\\Z").next();
			ret.put("content", content);
			ret.put("status", "OK");
		} catch(Exception e){
			ret.put("status", "File not Found");
			ret.put("content", "");
		}
		return ret;
	}
	public static void main(String Args[]){
		long tralala = get_public_key();
		create_username("Utilizatorul1", code(12345));
		create_username("Utilizatorul2", code(1111));
		create_username("Utilizatorul3", code(1));
		create_username("Utilizatorul4", code(0));
		System.out.println(create_username("Utilizatorul1", 1532));
		System.out.println(login("Utilizatorul1", 12345));
		System.out.println(login("Utilizatorul1", code(12345)));
		System.out.println(login("Inexistent", 153));
		introduce_book("Utilizatorul1", code(12345), "beletristica", "Arad", "autor colectiv", "arici pogonici", "In stare buna.");
		introduce_book("Utilizatorul1", code(12345), "pt copii", "Alba", "Walt Disney", "Mickey Mouse", "lipsesc pagini");
		introduce_book("Utilizatorul2", code(1111), "beletristica", "Arad", "Autor Colectiv", "arici pogonici", "toate cele 10 volume.");
		System.out.println(get_books(null, null, null, "colectiv", null));
		System.out.println(get_books("Utilizatorul1", "pt copii", "alba", "walt disney", "Mickey mOUSE"));
		System.out.println(obtain_book_description("1","2","3", "", ""));
		System.out.println(obtain_book_description("beletristica", "Arad", "Autor Colectiv", "Utilizatorul2", "arici pogonici"));
		System.out.println(add_feedback("Utilizatorul1", code(12345), "Utilizatorul4", 5));
		System.out.println(add_feedback("Utilizatorul2", code(1111), "Utilizatorul1", 1));
		System.out.println(add_feedback("Utilizatorul3", code(1), "Utilizatorul1", 5));
		System.out.println(add_feedback("Utilizatorul4", code(0), "Utilizatorul1", 2));
		System.out.println(get_ratings("Utilizatorul4"));
		System.out.println(get_ratings("Utilizatorul1"));
	}
}
