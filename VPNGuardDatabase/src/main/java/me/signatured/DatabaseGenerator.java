package me.signatured;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.Configuration;

class DatabaseGenerator {
	
	public static boolean SOUND = true;
	
	public static void main(String[] args) throws Throwable {
		System.setProperty("line.separator", "\n");
		Configuration config;
		try (FileInputStream in = new FileInputStream("jooq.xml")) {
			config = GenerationTool.load(in);
		}
//		if (args.length > 0) {
//			String schema = args[0];
//			config.getGenerator().getDatabase().setInputSchema(schema);
//			config.getGenerator().getTarget()
//					.setPackageName(config.getGenerator().getTarget().getPackageName() + '.' + schema);
//			config.getJdbc().setUrl("jdbc:mysql://127.0.0.1:3306");
//			config.getJdbc().setUser("root");
//			config.getJdbc().setPassword("");
//		}

		System.out.println("Generating database...");
		long start = System.currentTimeMillis();
		GenerationTool tool = new GenerationTool();
		tool.run(config);
		System.out.println("Generated database in " + ((System.currentTimeMillis() - start) / 1000) + "s!");

		if(SOUND){
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
			executor.scheduleAtFixedRate(new Runnable() {
				int runs = 0;
				@Override public void run() {
					Toolkit.getDefaultToolkit().beep();
					if (++runs >= 2) System.exit(1);
				}
			}, 0, 1, TimeUnit.SECONDS);
		}

	}

}
