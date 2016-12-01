package bookzilla;

import java.io.*;
import java.util.ArrayList;
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
	static int create_username(String username, long password){
		try{
			File file = new File("utilizatori//" + username);
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			if (file.exists())
				return 1;
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.println(decode(password));
			writer.close();
			return 0;
		} catch (IOException e){
			e.printStackTrace();
			return 2;
		}
	}
	static int login(String username, long password){
		Scanner scanner;
		try {
			scanner = new Scanner(new File ("utilizatori//" + username));
			long parola;
			parola = scanner.nextLong();
			int ret;
			ret = (parola == decode(password))?0:1;
			scanner.close();
			return ret;
		} catch (FileNotFoundException e) {
			return 2;
		}
	}
	static int introduce_book(String username, long password, String category, String city, String author, String title, String content){
		int ret;
		if ((ret = login(username, password)) != 0)
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
			return 3;
		}
		return 0;
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
	public static void main(String Args[]){
		long tralala = get_public_key();
		create_username("Utilizatorul1", code(12345));
		create_username("Utilizatorul2", code(1111));
		System.out.println(create_username("Utilizatorul1", 1532) + " inseamna ca utilizatorul exista deja");
		System.out.println(login("Utilizatorul1", 12345) + " inseamna ca parola este gresita");
		System.out.println(login("Utilizatorul1", code(12345)) + " s-a autentificat cu succes");
		System.out.println(login("Inexistent", 153) + " inseamna utilizator inexistent");
		introduce_book("Utilizatorul1", code(12345), "beletristica", "Arad", "autor colectiv", "arici pogonici", "In stare buna.");
		introduce_book("Utilizatorul1", code(12345), "pt copii", "Alba", "Walt Disney", "Mickey Mouse", "lipsesc pagini");
		introduce_book("Utilizatorul2", code(1111), "beletristica", "Arad", "Autor Colectiv", "arici pogonici", "toate cele 10 volume.");
		System.out.println(get_books(null, null, null, "colectiv", null));
		System.out.println(get_books("Utilizatorul1", "pt copii", "alba", "walt disney", "Mickey mOUSE"));
		
	}
}
