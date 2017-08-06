package redis.main.java.cart;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Chapter02 {
	public static final void main(String[] args) throws InterruptedException {
		new Chapter02().run();
	}

	public void run() throws InterruptedException {
		Jedis conn = new Jedis("localhost");
		conn.select(15);

	}

	public String checkToken(Jedis conn, String token) {

		return conn.hget("login:", token);
	}

	public void updateToken(Jedis conn, String token, String user, String item) {
		long timestamp = System.currentTimeMillis() / 1000;
		conn.hset("login:", token, user);
		conn.zadd("recent:", timestamp, token);
		if (item != null) {
			conn.zadd("viewed:" + token, timestamp, item);
			conn.zremrangeByRank("viewed:" + token, 0, -26);
		}
	}

	public class CleanSessionsThread extends Thread {
		private Jedis conn;
		private Boolean quit;
		private int limit;

		public CleanSessionsThread(int limit) {
			this.conn = new Jedis("localhost");
			this.conn.select(15);
			this.limit = limit;
		}

		public void quit() {
			quit = true;
		}

		public void run() {
			while (!quit) {
				long size = conn.zcard("recent:");
				if (size <= limit) {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
				long endindex = Math.min(size - limit, 100);
				Set<String> tokenSet = conn.zrange("recent:", 0, endindex - 1);
				String[] tokens = tokenSet.toArray(new String[tokenSet.size()]);
				ArrayList<String> sessionKeys = new ArrayList<String>();
				for (String token : tokenSet) {
					sessionKeys.add(token);
				}
				conn.del(sessionKeys.toArray(new String[sessionKeys.size()]));
				conn.hdel("login:", tokens);
				conn.zrem("recent:", tokens);
			}
		}
	}
	
	public void addToCart(Jedis conn,String session,String item,int count){
		if(count<=0){
			conn.hdel("cart:"+session, item);
		}else {
			conn.hset("cart:"+session, item, String.valueOf(count));
		}
	}
	
	public class CleanFullSessionsThread extends Thread{
		private Jedis conn;
        private int limit;
        private boolean quit;

        public CleanFullSessionsThread(int limit) {
            this.conn = new Jedis("localhost");
            this.conn.select(15);
            this.limit = limit;
        }

        public void quit() {
            quit = true;
        }
        
        public void run(){
        	while(!quit){
        	 long size = conn.zcard("recent:");
        	 if(size <= limit){
        		 try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        		continue; 
        	 }
        	 long endIndex = Math.min(size - limit,100);
        	 Set<String> sessionSet = conn.zrange("recent:", 0, endIndex-1);
             String[] sessions = sessionSet.toArray(new String[sessionSet.size()]);

        	 ArrayList<String> sessionKeys = new ArrayList<String>();
        	 for(String sess :sessions){
        		 sessionKeys.add("viewed:"+sess);
        		 sessionKeys.add("cart:"+sess);
        	 }
        	 conn.del(sessionKeys.toArray(new String[sessionKeys.size()]));
        	 conn.hdel("login:", sessions);
        	 conn.zrem("recent", sessions);
        	}
        	
        }
	}
}
