package org.enjekt.panda.whitevault;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.enjekt.panda.whitevault.internal.beans.TokenGenerator;

public class TokenFileGenerator {

	public static void main(String[] args) throws IOException {
		new TokenFileGenerator().run();

	}

	private void run() throws IOException {
		TokenGenerator generator = new TokenGenerator();
		BufferedReader br = new BufferedReader(new FileReader("/workspaces/pandavault/whitevault/src/test/resources/cardsandtokens.csv"));

		File fout = new File("/workspaces/pandavault/whitevault/src/test/resources/cardsandtokenscolumns.csv");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fout)));
		
		

		String line = null;
		while ((line = br.readLine()) != null) {
			//System.out.println(line);
			String pan = line.split(",")[1];
			bw.write(generator.generateToken(pan).getToken()+","+pan);
			bw.newLine();
		}
		bw.close();
		br.close();
	}

}
