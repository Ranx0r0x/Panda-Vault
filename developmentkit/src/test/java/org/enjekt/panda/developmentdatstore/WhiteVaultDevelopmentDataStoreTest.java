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
package org.enjekt.panda.developmentdatstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.enjekt.panda.commons.models.Token;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

// TODO: Auto-generated Javadoc
/**
 * The Class WhiteVaultDevelopmentDataStoreTest.
 */
@RunWith(CamelCdiRunner.class)
public class WhiteVaultDevelopmentDataStoreTest {

	/** The datastore. */
	@Inject
	private WhiteVaultDatastore datastore;


	/**
	 * Gets the same token for pan.
	 *
	 * @return the same token for pan
	 */
	@Test
	public void getSameTokenForPan()
	{
		// String salt = RandomStringUtils.random(20, 0, 0, true, true, null, new SecureRandom());
		String panda = "2221555555551234";
		Token tokenNew = datastore.getToken(panda);
		assertNull(tokenNew.getToken());	
		tokenNew.setToken("11111155551234");
		datastore.storePanda(tokenNew, panda);
		Token token = datastore.getToken(panda);
		System.out.println(token);
		assertNotNull(token);
		assertEquals(tokenNew.getToken(),token.getToken());
	}
	
	/**
	 * Validate same pan for token.
	 */
	@Test
	public void validateSamePanForToken()
	{
		String panda = "3333555555551234";
		Token token = new Token().setToken("5555155551234");
		String storedPan = datastore.getPanda(token.getToken());
		assertNull(storedPan);	
		datastore.storePanda(token, panda);
		storedPan = datastore.getPanda(token.getToken());
		assertNotNull(storedPan);
		assertEquals(storedPan,storedPan);
	}
	
	/**
	 * Test pre loaded data.
	 */
	@Test
	@Ignore
	public void testPreLoadedData()
	{
	/*	tokenList.forEach(storedToken -> {
			String panda=datastore.getPanda(storedToken.getToken());
			assertNotNull(panda);

		});*/
		for(Token token:tokenList)
		{
			String panda=datastore.getPanda(token.getToken());
			assertNotNull(panda);
		}
		
	}
	
	/** The token list. */
	private static List<Token> tokenList = Arrays.asList(new Token[]{
			new Token().setToken("372842011638689"),
			new Token().setToken("447828108404444"),
			new Token().setToken("317144418073257"),
			new Token().setToken("410768637807826"),
			new Token().setToken("650162521773021"),
			new Token().setToken("677003827047673"),
			new Token().setToken("622844584157864"),
			new Token().setToken("364602164616129"),
			new Token().setToken("828064217480533"),
			new Token().setToken("861746000551448"),
			new Token().setToken("824067341846244"),
			new Token().setToken("830513258568871"),
			new Token().setToken("070643020662537"),
			new Token().setToken("336512524162560"),
			new Token().setToken("305485763621442"),
			new Token().setToken("205665723804992"),
			new Token().setToken("036500430270391"),
			new Token().setToken("880150464270700"),
			new Token().setToken("523337455322811"),
			new Token().setToken("857832620131966"),
			new Token().setToken("666016662820524"),
			new Token().setToken("682284372305514"),
			new Token().setToken("372864418020304"),
			new Token().setToken("716435767286030"),
			new Token().setToken("453048536520561"),
			new Token().setToken("858271271336439"),
			new Token().setToken("262681528669558"),
			new Token().setToken("146615808088763"),
			new Token().setToken("430387212001526"),
			new Token().setToken("781327133235742"),
			new Token().setToken("273318103287291"),
			new Token().setToken("868010243755034"),
			new Token().setToken("286758334124795"),
			new Token().setToken("372162345375053"),
			new Token().setToken("031313033815482"),
			new Token().setToken("860727348239704"),
			new Token().setToken("322860755129605"),
			new Token().setToken("401871648256665"),
			new Token().setToken("821622667517904"),
			new Token().setToken("144843033265244"),
			new Token().setToken("872221274330471"),
			new Token().setToken("365352821516587"),
			new Token().setToken("847201625372732"),
			new Token().setToken("408636812473472"),
			new Token().setToken("233486157526452"),
			new Token().setToken("222835568023447"),
			new Token().setToken("767205171476036"),
			new Token().setToken("632825462317603"),
			new Token().setToken("660004013006420"),
			new Token().setToken("3656211853084742"),
			new Token().setToken("0257417438086095"),
			new Token().setToken("6871550466771854"),
			new Token().setToken("6047701063129319"),
			new Token().setToken("1336286716716550"),
			new Token().setToken("8258454118578935"),
			new Token().setToken("0454123741059111"),
			new Token().setToken("4107415781451860"),
			new Token().setToken("3552082438265330"),
			new Token().setToken("4006324518668112"),
			new Token().setToken("5580271808731445"),
			new Token().setToken("4883471356016988"),
			new Token().setToken("1348535022334853"),
			new Token().setToken("3171082583871671"),
			new Token().setToken("6650566688641127"),
			new Token().setToken("3166175568258179"),
			new Token().setToken("0501100427875268"),
			new Token().setToken("6314178712063138"),
			new Token().setToken("1742301544786985"),
			new Token().setToken("7122826626412057"),
			new Token().setToken("7533166122161575"),
			new Token().setToken("7665615677754503"),
			new Token().setToken("4418423177517220"),
			new Token().setToken("5585012576472934"),
			new Token().setToken("8635041400142930"),
			new Token().setToken("4175814702401344"),
			new Token().setToken("8354604142561338"),
			new Token().setToken("0834503653703365"),
			new Token().setToken("1253514717534090"),
			new Token().setToken("6681808237159344"),
			new Token().setToken("1517366056420530"),
			new Token().setToken("1275165674847711"),
			new Token().setToken("6000310807876532"),
			new Token().setToken("8656580885572737"),
			new Token().setToken("0331102534259758"),
			new Token().setToken("1544026701753822"),
			new Token().setToken("2051524074029487"),
			new Token().setToken("5052660242266925"),
			new Token().setToken("3730687361861651"),
			new Token().setToken("5410533842632829"),
			new Token().setToken("6812888412656628"),
			new Token().setToken("1762013375665541"),
			new Token().setToken("6862570676629705"),
			new Token().setToken("8725471370016197"),
			new Token().setToken("8537236422732212"),
			new Token().setToken("2601003828111919"),
			new Token().setToken("0847717410632151"),
			new Token().setToken("5261688013211223"),
			new Token().setToken("2115273134054251"),
			new Token().setToken("2213573027402138"),
			new Token().setToken("7380025050554033"),
			new Token().setToken("3724244714029680"),
			new Token().setToken("6286345011670645"),
			new Token().setToken("0550524281004936"),
			new Token().setToken("5258740580068329"),
			new Token().setToken("4677688022040796"),
			new Token().setToken("3274030413322332"),
			new Token().setToken("2458372885320657"),
			new Token().setToken("4827004636711912"),
			new Token().setToken("5513255542428610"),
			new Token().setToken("7606271527710774"),
			new Token().setToken("6713023435227338"),
			new Token().setToken("7858178847656501"),
			new Token().setToken("8887436124105082"),
			new Token().setToken("3246333433641478"), 
			new Token().setToken("1757147562211967"),
			new Token().setToken("1058600223387710"),
			new Token().setToken("4506238358885455"),
			new Token().setToken("4043236628866360"),
			new Token().setToken("1771586515287722"),
			new Token().setToken("2824285471808487"),
			new Token().setToken("1441348776318115"),
			new Token().setToken("4157714637712312"),
			new Token().setToken("1003706505145045"),
			new Token().setToken("1757630677874939"),
			new Token().setToken("8620311812674607"),
			new Token().setToken("0154546632302855"),
			new Token().setToken("2224414176043904"),
			new Token().setToken("4112614388182560"),
			new Token().setToken("3311375870382264"),
			new Token().setToken("7430864163181025"),
			new Token().setToken("6370011800504092"),
			new Token().setToken("2245477563137415"),
			new Token().setToken("4127654328473356"),
			new Token().setToken("1202121744081479"),
			new Token().setToken("7606523615530859"),
			new Token().setToken("1800208707033383"),
			new Token().setToken("8803466043489901"),
			new Token().setToken("3470360616623408"),
			new Token().setToken("3448871135064819"),
			new Token().setToken("3643401312746722"),
			new Token().setToken("8424445847727483"),
			new Token().setToken("7404262841662511"),
			new Token().setToken("6801362581503372"),
			new Token().setToken("4727860411058998"),
			new Token().setToken("8361236108340589"),
			new Token().setToken("5585504728786265"),
			new Token().setToken("2484640540074398")}
);
}
