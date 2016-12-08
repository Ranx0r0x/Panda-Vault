/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.enjekt.panda.developmentkit.internal;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.enjekt.panda.commons.models.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class WhiteVaultDatastoreImpl.
 */
@Singleton
public class WhiteVaultDatastoreImpl implements WhiteVaultDatastore {
	
	/** The data store. */
	@Inject
	private WhiteVaultDevelopmentDatastore dataStore;
	

	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.WhiteVaultDatastore#getToken(java.lang.String)
	 */
	public Token getToken(String panda) {
		Token token = dataStore.getToken(panda);
		System.out.println("Retrieved token: "+ token);
		if(token==null)
			token= new Token();
		return token;
	}


	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.WhiteVaultDatastore#storePanda(org.enjekt.panda.commons.models.Token, java.lang.String)
	 */
	@Override
	public void storePanda(Token token, String panda) {
		dataStore.storePanda(token, panda);
		
	}


	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.WhiteVaultDatastore#getPanda(java.lang.String)
	 */
	@Override
	public String getPanda(String token) {
		return dataStore.getPanda(token);
	}
	
	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.WhiteVaultDatastore#getPandasForFamilyID(java.lang.String)
	 */
	public Map<String,String> getPandasForFamilyID(String familyId){
		return dataStore.getPandasForFamilyID(familyId);
	}


	/**
	 * Gets the data store.
	 *
	 * @return the data store
	 */
	public WhiteVaultDevelopmentDatastore getDataStore() {
		return dataStore;
	}


	/**
	 * Sets the data store.
	 *
	 * @param dataStore the new data store
	 */
	public void setDataStore(WhiteVaultDevelopmentDatastore dataStore) {
		this.dataStore = dataStore;
	}
//possible to prestore data for testing.
	
/*
static{
		
		dataStore.storePanda(initToken("372842011638689"),Long.parseLong("340706599418689"));
		dataStore.storePanda(initToken("447828108404444"),Long.parseLong("347043866014444"));
		dataStore.storePanda(initToken("317144418073257"),Long.parseLong("379559818613257"));
		dataStore.storePanda(initToken("410768637807826"),Long.parseLong("376735883557826"));
		dataStore.storePanda(initToken("650162521773021"),Long.parseLong("374749552763021"));
		dataStore.storePanda(initToken("677003827047673"),Long.parseLong("341898711897673"));
		dataStore.storePanda(initToken("622844584157864"),Long.parseLong("371972843777864"));
		dataStore.storePanda(initToken("364602164616129"),Long.parseLong("342059404166129"));
		dataStore.storePanda(initToken("828064217480533"),Long.parseLong("373475237120533"));
		dataStore.storePanda(initToken("861746000551448"),Long.parseLong("341390580091448"));
		dataStore.storePanda(initToken("824067341846244"),Long.parseLong("348355599416244"));
		dataStore.storePanda(initToken("830513258568871"),Long.parseLong("371793677108871"));
		dataStore.storePanda(initToken("070643020662537"),Long.parseLong("348745808862537"));
		dataStore.storePanda(initToken("336512524162560"),Long.parseLong("340144619482560"));
		dataStore.storePanda(initToken("305485763621442"),Long.parseLong("379838506411442"));
		dataStore.storePanda(initToken("205665723804992"),Long.parseLong("347271640564992"));
		dataStore.storePanda(initToken("036500430270391"),Long.parseLong("373695911920391"));
		dataStore.storePanda(initToken("880150464270700"),Long.parseLong("346130845590700"));
		dataStore.storePanda(initToken("523337455322811"),Long.parseLong("347029562632811"));
		dataStore.storePanda(initToken("857832620131966"),Long.parseLong("376619040701966"));
		dataStore.storePanda(initToken("666016662820524"),Long.parseLong("343118267920524"));
		dataStore.storePanda(initToken("682284372305514"),Long.parseLong("349709277675514"));
		dataStore.storePanda(initToken("372864418020304"),Long.parseLong("347462042490304"));
		dataStore.storePanda(initToken("716435767286030"),Long.parseLong("347035257826030"));
		dataStore.storePanda(initToken("453048536520561"),Long.parseLong("342411245440561"));
		dataStore.storePanda(initToken("858271271336439"),Long.parseLong("345588764286439"));
		dataStore.storePanda(initToken("262681528669558"),Long.parseLong("374787294289558"));
		dataStore.storePanda(initToken("146615808088763"),Long.parseLong("379748250618763"));
		dataStore.storePanda(initToken("430387212001526"),Long.parseLong("344568513791526"));
		dataStore.storePanda(initToken("781327133235742"),Long.parseLong("349169280225742"));
		dataStore.storePanda(initToken("273318103287291"),Long.parseLong("377459093537291"));
		dataStore.storePanda(initToken("868010243755034"),Long.parseLong("370861209705034"));
		dataStore.storePanda(initToken("286758334124795"),Long.parseLong("376805378864795"));
		dataStore.storePanda(initToken("372162345375053"),Long.parseLong("341347754485053"));
		dataStore.storePanda(initToken("031313033815482"),Long.parseLong("342839545225482"));
		dataStore.storePanda(initToken("860727348239704"),Long.parseLong("376890737839704"));
		dataStore.storePanda(initToken("322860755129605"),Long.parseLong("346025913979605"));
		dataStore.storePanda(initToken("401871648256665"),Long.parseLong("349798519976665"));
		dataStore.storePanda(initToken("821622667517904"),Long.parseLong("341424416597904"));
		dataStore.storePanda(initToken("144843033265244"),Long.parseLong("343094923165244"));
		dataStore.storePanda(initToken("872221274330471"),Long.parseLong("376127460910471"));
		dataStore.storePanda(initToken("365352821516587"),Long.parseLong("373749086306587"));
		dataStore.storePanda(initToken("847201625372732"),Long.parseLong("373527615092732"));
		dataStore.storePanda(initToken("408636812473472"),Long.parseLong("347655556203472"));
		dataStore.storePanda(initToken("233486157526452"),Long.parseLong("349470641596452"));
		dataStore.storePanda(initToken("222835568023447"),Long.parseLong("348653046323447"));
		dataStore.storePanda(initToken("767205171476036"),Long.parseLong("374878081206036"));
		dataStore.storePanda(initToken("632825462317603"),Long.parseLong("347297049867603"));
		dataStore.storePanda(initToken("660004013006420"),Long.parseLong("372000065506420"));
		dataStore.storePanda(initToken("3656211853084742"),Long.parseLong("5420254207594742"));
		dataStore.storePanda(initToken("0257417438086095"),Long.parseLong("5427643783646095"));
		dataStore.storePanda(initToken("6871550466771854"),Long.parseLong("5276813150881854"));
		dataStore.storePanda(initToken("6047701063129319"),Long.parseLong("5151507995539319"));
		dataStore.storePanda(initToken("1336286716716550"),Long.parseLong("5495255546456550"));
		dataStore.storePanda(initToken("8258454118578935"),Long.parseLong("5263992206618935"));
		dataStore.storePanda(initToken("0454123741059111"),Long.parseLong("5447552004039111"));
		dataStore.storePanda(initToken("4107415781451860"),Long.parseLong("5171540375681860"));
		dataStore.storePanda(initToken("3552082438265330"),Long.parseLong("5264620989755330"));
		dataStore.storePanda(initToken("4006324518668112"),Long.parseLong("5161036753218112"));
		dataStore.storePanda(initToken("5580271808731445"),Long.parseLong("5262770164371445"));
		dataStore.storePanda(initToken("4883471356016988"),Long.parseLong("5509992582286988"));
		dataStore.storePanda(initToken("1348535022334853"),Long.parseLong("5300261251424853"));
		dataStore.storePanda(initToken("3171082583871671"),Long.parseLong("5323585197241671"));
		dataStore.storePanda(initToken("6650566688641127"),Long.parseLong("5429934246101127"));
		dataStore.storePanda(initToken("3166175568258179"),Long.parseLong("5432834250128179"));
		dataStore.storePanda(initToken("0501100427875268"),Long.parseLong("5106863867015268"));
		dataStore.storePanda(initToken("6314178712063138"),Long.parseLong("5575819543753138"));
		dataStore.storePanda(initToken("1742301544786985"),Long.parseLong("5331232403156985"));
		dataStore.storePanda(initToken("7122826626412057"),Long.parseLong("5208527250632057"));
		dataStore.storePanda(initToken("7533166122161575"),Long.parseLong("5234090063701575"));
		dataStore.storePanda(initToken("7665615677754503"),Long.parseLong("5390711181614503"));
		dataStore.storePanda(initToken("4418423177517220"),Long.parseLong("5134965117767220"));
		dataStore.storePanda(initToken("5585012576472934"),Long.parseLong("5312537643862934"));
		dataStore.storePanda(initToken("8635041400142930"),Long.parseLong("5288417085232930"));
		dataStore.storePanda(initToken("4175814702401344"),Long.parseLong("5289759244191344"));
		dataStore.storePanda(initToken("8354604142561338"),Long.parseLong("5587704481061338"));
		dataStore.storePanda(initToken("0834503653703365"),Long.parseLong("5402299504623365"));
		dataStore.storePanda(initToken("1253514717534090"),Long.parseLong("5204246537234090"));
		dataStore.storePanda(initToken("6681808237159344"),Long.parseLong("5591833468419344"));
		dataStore.storePanda(initToken("1517366056420530"),Long.parseLong("5331794425110530"));
		dataStore.storePanda(initToken("1275165674847711"),Long.parseLong("5483964241487711"));
		dataStore.storePanda(initToken("6000310807876532"),Long.parseLong("5271911448866532"));
		dataStore.storePanda(initToken("8656580885572737"),Long.parseLong("5460478730032737"));
		dataStore.storePanda(initToken("0331102534259758"),Long.parseLong("5564620921789758"));
		dataStore.storePanda(initToken("1544026701753822"),Long.parseLong("5153701241893822"));
		dataStore.storePanda(initToken("2051524074029487"),Long.parseLong("5375149884889487"));
		dataStore.storePanda(initToken("5052660242266925"),Long.parseLong("5366176666336925"));
		dataStore.storePanda(initToken("3730687361861651"),Long.parseLong("5263462725721651"));
		dataStore.storePanda(initToken("5410533842632829"),Long.parseLong("5417621470132829"));
		dataStore.storePanda(initToken("6812888412656628"),Long.parseLong("5392389109436628"));
		dataStore.storePanda(initToken("1762013375665541"),Long.parseLong("5272440256795541"));
		dataStore.storePanda(initToken("6862570676629705"),Long.parseLong("5366541265829705"));
		dataStore.storePanda(initToken("8725471370016197"),Long.parseLong("5319458948916197"));
		dataStore.storePanda(initToken("8537236422732212"),Long.parseLong("5583123274942212"));
		dataStore.storePanda(initToken("2601003828111919"),Long.parseLong("5583555948261919"));
		dataStore.storePanda(initToken("0847717410632151"),Long.parseLong("5435064674322151"));
		dataStore.storePanda(initToken("5261688013211223"),Long.parseLong("5248777723821223"));
		dataStore.storePanda(initToken("2115273134054251"),Long.parseLong("5420058829634251"));
		dataStore.storePanda(initToken("2213573027402138"),Long.parseLong("4532260349592138"));
		dataStore.storePanda(initToken("7380025050554033"),Long.parseLong("4024007141284033"));
		dataStore.storePanda(initToken("3724244714029680"),Long.parseLong("4929760419779680"));
		dataStore.storePanda(initToken("6286345011670645"),Long.parseLong("4916916367670645"));
		dataStore.storePanda(initToken("0550524281004936"),Long.parseLong("4716136501794936"));
		dataStore.storePanda(initToken("5258740580068329"),Long.parseLong("4532311399718329"));
		dataStore.storePanda(initToken("4677688022040796"),Long.parseLong("4556447886420796"));
		dataStore.storePanda(initToken("3274030413322332"),Long.parseLong("4976170335462332"));
		dataStore.storePanda(initToken("2458372885320657"),Long.parseLong("4024007120000657"));
		dataStore.storePanda(initToken("4827004636711912"),Long.parseLong("4816642037311912"));
		dataStore.storePanda(initToken("5513255542428610"),Long.parseLong("4929300944088610"));
		dataStore.storePanda(initToken("7606271527710774"),Long.parseLong("4532510069250774"));
		dataStore.storePanda(initToken("6713023435227338"),Long.parseLong("4716280012177338"));
		dataStore.storePanda(initToken("7858178847656501"),Long.parseLong("4704463009116501"));
		dataStore.storePanda(initToken("8887436124105082"),Long.parseLong("4532238226035082"));
		dataStore.storePanda(initToken("3246333433641478"),Long.parseLong("4539303837911478"));
		dataStore.storePanda(initToken("1757147562211967"),Long.parseLong("4485187238611967"));
		dataStore.storePanda(initToken("1058600223387710"),Long.parseLong("4491907729677710"));
		dataStore.storePanda(initToken("4506238358885455"),Long.parseLong("4716413838175455"));
		dataStore.storePanda(initToken("4043236628866360"),Long.parseLong("4929635862766360"));
		dataStore.storePanda(initToken("1771586515287722"),Long.parseLong("4075708118017722"));
		dataStore.storePanda(initToken("2824285471808487"),Long.parseLong("4916795856008487"));
		dataStore.storePanda(initToken("1441348776318115"),Long.parseLong("4556773914938115"));
		dataStore.storePanda(initToken("4157714637712312"),Long.parseLong("4024007194952312"));
		dataStore.storePanda(initToken("1003706505145045"),Long.parseLong("4916114914475045"));
		dataStore.storePanda(initToken("1757630677874939"),Long.parseLong("4916775183904939"));
		dataStore.storePanda(initToken("8620311812674607"),Long.parseLong("4485941318724607"));
		dataStore.storePanda(initToken("0154546632302855"),Long.parseLong("4539716596622855"));
		dataStore.storePanda(initToken("2224414176043904"),Long.parseLong("4916854216713904"));
		dataStore.storePanda(initToken("4112614388182560"),Long.parseLong("4556591594242560"));
		dataStore.storePanda(initToken("3311375870382264"),Long.parseLong("4556880254212264"));
		dataStore.storePanda(initToken("7430864163181025"),Long.parseLong("4532781849401025"));
		dataStore.storePanda(initToken("6370011800504092"),Long.parseLong("4297768030764092"));
		dataStore.storePanda(initToken("2245477563137415"),Long.parseLong("4485872807807415"));
		dataStore.storePanda(initToken("4127654328473356"),Long.parseLong("4556557323603356"));
		dataStore.storePanda(initToken("1202121744081479"),Long.parseLong("4024007142161479"));
		dataStore.storePanda(initToken("7606523615530859"),Long.parseLong("4929650335340859"));
		dataStore.storePanda(initToken("1800208707033383"),Long.parseLong("4556767985953383"));
		dataStore.storePanda(initToken("8803466043489901"),Long.parseLong("4485721517539901"));
		dataStore.storePanda(initToken("3470360616623408"),Long.parseLong("4700635280923408"));
		dataStore.storePanda(initToken("3448871135064819"),Long.parseLong("4485052844834819"));
		dataStore.storePanda(initToken("3643401312746722"),Long.parseLong("4485998119526722"));
		dataStore.storePanda(initToken("8424445847727483"),Long.parseLong("4138754188207483"));
		dataStore.storePanda(initToken("7404262841662511"),Long.parseLong("4556552625522511"));
		dataStore.storePanda(initToken("6801362581503372"),Long.parseLong("4539619648353372"));
		dataStore.storePanda(initToken("4727860411058998"),Long.parseLong("4517289653468998"));
		dataStore.storePanda(initToken("8361236108340589"),Long.parseLong("4929105479810589"));
		dataStore.storePanda(initToken("5585504728786265"),Long.parseLong("4916847550676265"));
		dataStore.storePanda(initToken("2484640540074398"),Long.parseLong("4532502180734398"));
}
//Note that this does not set the family ID! For the development data store it is not
//required.
	private static Token initToken(String token){
		Token t = new Token();
		t.setToken(token);
		return t;
	}

*/


}
