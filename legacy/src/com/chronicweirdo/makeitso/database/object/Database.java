package com.chronicweirdo.makeitso.database.object;

import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

public class Database {
	
	private String source;
	
	private ObjectContainer container;
	
	public Database(String source) {
		// open database
		this.source = source;
		
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		//config.common().objectClass(Data.class).cascadeOnDelete(true);// .objectField("pilot").cascadeOnDelete(true);
	
		this.container = Db4oEmbedded.openFile(config, this.source);
		
		// shutdown hook is added automatically
		/*Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("closing database");
				container.close();
			}
		});*/
	}
	
	public <T> void save(T o) {
		System.out.println("saving object " + o.toString());
		try {
			container.store(o);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public <T> void delete(T o) {
		try {
			container.delete(o);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public long count() {
		return container.queryByExample(null).size();
	}
	
	public <T> List<T> query(T t) {
		try {
			ObjectSet<T> result = container.queryByExample(t);
			List<T> r = new ArrayList<T>();
			for (T o: result) {
				System.out.println(o.toString());
				r.add(o);
			}
			return r;
		} finally {
			//db.close();
		}
	}
	
}
