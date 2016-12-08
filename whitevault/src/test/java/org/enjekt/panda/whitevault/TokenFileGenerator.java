/*  Copyright 2016 Bradlee Johnson 
 *  This file is part of Panda Vault.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
**/
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
