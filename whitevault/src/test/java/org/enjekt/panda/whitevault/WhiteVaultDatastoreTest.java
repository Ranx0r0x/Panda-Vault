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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.enjekt.panda.commons.models.Token;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CamelCdiRunner.class)
public class WhiteVaultDatastoreTest {

	@Inject
	private WhiteVaultDatastore datastore;

	@Test
	public void whiteVaultTest() {
/*		tokenPanPairs.forEach(tokenPanPair-> {
			datastore.storePanda(new Token().setToken(tokenPanPair[0]), tokenPanPair[1]);
		});

		tokenPanPairs.forEach(tokenPanPair-> {
			String panda=datastore.getPanda(tokenPanPair[0]);
			assertNotNull(panda);
			String expectedPan=tokenPanPair[1];
			//System.out.println(expectedPan+","+panda);
			assertEquals(expectedPan, panda);

		});*/
		for(String[] tokenPanPair:tokenPanPairs) {
			datastore.storePanda(new Token().setToken(tokenPanPair[0]), tokenPanPair[1]);
		};

		for(String[] tokenPanPair:tokenPanPairs) { 
			String panda=datastore.getPanda(tokenPanPair[0]);
			assertNotNull(panda);
			String expectedPan=tokenPanPair[1];
			//System.out.println(expectedPan+","+panda);
			assertEquals(expectedPan, panda);

		};
	}
	
	List<String[]> tokenPanPairs = Arrays.asList(
	new String[]{"372842011638689","340706599418689"},
	new String[]{"447828108404444","347043866014444"},
	new String[]{"317144418073257","379559818613257"},
	new String[]{"410768637807826","376735883557826"},
	new String[]{"650162521773021","374749552763021"},
	new String[]{"677003827047673","341898711897673"},
	new String[]{"622844584157864","371972843777864"},
	new String[]{"364602164616129","342059404166129"},
	new String[]{"828064217480533","373475237120533"},
	new String[]{"861746000551448","341390580091448"},
	new String[]{"824067341846244","348355599416244"},
	new String[]{"830513258568871","371793677108871"},
	new String[]{"070643020662537","348745808862537"},
	new String[]{"336512524162560","340144619482560"},
	new String[]{"305485763621442","379838506411442"},
	new String[]{"205665723804992","347271640564992"},
	new String[]{"036500430270391","373695911920391"},
	new String[]{"880150464270700","346130845590700"},
	new String[]{"523337455322811","347029562632811"},
	new String[]{"857832620131966","376619040701966"},
	new String[]{"666016662820524","343118267920524"},
	new String[]{"682284372305514","349709277675514"},
	new String[]{"372864418020304","347462042490304"},
	new String[]{"716435767286030","347035257826030"},
	new String[]{"453048536520561","342411245440561"},
	new String[]{"858271271336439","345588764286439"},
	new String[]{"262681528669558","374787294289558"},
	new String[]{"146615808088763","379748250618763"},
	new String[]{"430387212001526","344568513791526"},
	new String[]{"781327133235742","349169280225742"},
	new String[]{"273318103287291","377459093537291"},
	new String[]{"868010243755034","370861209705034"},
	new String[]{"286758334124795","376805378864795"},
	new String[]{"372162345375053","341347754485053"},
	new String[]{"031313033815482","342839545225482"},
	new String[]{"860727348239704","376890737839704"},
	new String[]{"322860755129605","346025913979605"},
	new String[]{"401871648256665","349798519976665"},
	new String[]{"821622667517904","341424416597904"},
	new String[]{"144843033265244","343094923165244"},
	new String[]{"872221274330471","376127460910471"},
	new String[]{"365352821516587","373749086306587"},
	new String[]{"847201625372732","373527615092732"},
	new String[]{"408636812473472","347655556203472"},
	new String[]{"233486157526452","349470641596452"},
	new String[]{"222835568023447","348653046323447"},
	new String[]{"767205171476036","374878081206036"},
	new String[]{"632825462317603","347297049867603"},
	new String[]{"660004013006420","372000065506420"},
	new String[]{"3656211853084742","5420254207594742"},
	new String[]{"0257417438086095","5427643783646095"},
	new String[]{"6871550466771854","5276813150881854"},
	new String[]{"6047701063129319","5151507995539319"},
	new String[]{"1336286716716550","5495255546456550"},
	new String[]{"8258454118578935","5263992206618935"},
	new String[]{"0454123741059111","5447552004039111"},
	new String[]{"4107415781451860","5171540375681860"},
	new String[]{"3552082438265330","5264620989755330"},
	new String[]{"4006324518668112","5161036753218112"},
	new String[]{"5580271808731445","5262770164371445"},
	new String[]{"4883471356016988","5509992582286988"},
	new String[]{"1348535022334853","5300261251424853"},
	new String[]{"3171082583871671","5323585197241671"},
	new String[]{"6650566688641127","5429934246101127"},
	new String[]{"3166175568258179","5432834250128179"},
	new String[]{"0501100427875268","5106863867015268"},
	new String[]{"6314178712063138","5575819543753138"},
	new String[]{"1742301544786985","5331232403156985"},
	new String[]{"7122826626412057","5208527250632057"},
	new String[]{"7533166122161575","5234090063701575"},
	new String[]{"7665615677754503","5390711181614503"},
	new String[]{"4418423177517220","5134965117767220"},
	new String[]{"5585012576472934","5312537643862934"},
	new String[]{"8635041400142930","5288417085232930"},
	new String[]{"4175814702401344","5289759244191344"},
	new String[]{"8354604142561338","5587704481061338"},
	new String[]{"0834503653703365","5402299504623365"},
	new String[]{"1253514717534090","5204246537234090"},
	new String[]{"6681808237159344","5591833468419344"},
	new String[]{"1517366056420530","5331794425110530"},
	new String[]{"1275165674847711","5483964241487711"},
	new String[]{"6000310807876532","5271911448866532"},
	new String[]{"8656580885572737","5460478730032737"},
	new String[]{"0331102534259758","5564620921789758"},
	new String[]{"1544026701753822","5153701241893822"},
	new String[]{"2051524074029487","5375149884889487"},
	new String[]{"5052660242266925","5366176666336925"},
	new String[]{"3730687361861651","5263462725721651"},
	new String[]{"5410533842632829","5417621470132829"},
	new String[]{"6812888412656628","5392389109436628"},
	new String[]{"1762013375665541","5272440256795541"},
	new String[]{"6862570676629705","5366541265829705"},
	new String[]{"8725471370016197","5319458948916197"},
	new String[]{"8537236422732212","5583123274942212"},
	new String[]{"2601003828111919","5583555948261919"},
	new String[]{"0847717410632151","5435064674322151"},
	new String[]{"5261688013211223","5248777723821223"},
	new String[]{"2115273134054251","5420058829634251"},
	new String[]{"2213573027402138","4532260349592138"},
	new String[]{"7380025050554033","4024007141284033"},
	new String[]{"3724244714029680","4929760419779680"},
	new String[]{"6286345011670645","4916916367670645"},
	new String[]{"0550524281004936","4716136501794936"},
	new String[]{"5258740580068329","4532311399718329"},
	new String[]{"4677688022040796","4556447886420796"},
	new String[]{"3274030413322332","4976170335462332"},
	new String[]{"2458372885320657","4024007120000657"},
	new String[]{"4827004636711912","4816642037311912"},
	new String[]{"5513255542428610","4929300944088610"},
	new String[]{"7606271527710774","4532510069250774"},
	new String[]{"6713023435227338","4716280012177338"},
	new String[]{"7858178847656501","4704463009116501"},
	new String[]{"8887436124105082","4532238226035082"},
	new String[]{"3246333433641478","4539303837911478"},
	new String[]{"1757147562211967","4485187238611967"},
	new String[]{"1058600223387710","4491907729677710"},
	new String[]{"4506238358885455","4716413838175455"},
	new String[]{"4043236628866360","4929635862766360"},
	new String[]{"1771586515287722","4075708118017722"},
	new String[]{"2824285471808487","4916795856008487"},
	new String[]{"1441348776318115","4556773914938115"},
	new String[]{"4157714637712312","4024007194952312"},
	new String[]{"1003706505145045","4916114914475045"},
	new String[]{"1757630677874939","4916775183904939"},
	new String[]{"8620311812674607","4485941318724607"},
	new String[]{"0154546632302855","4539716596622855"},
	new String[]{"2224414176043904","4916854216713904"},
	new String[]{"4112614388182560","4556591594242560"},
	new String[]{"3311375870382264","4556880254212264"},
	new String[]{"7430864163181025","4532781849401025"},
	new String[]{"6370011800504092","4297768030764092"},
	new String[]{"2245477563137415","4485872807807415"},
	new String[]{"4127654328473356","4556557323603356"},
	new String[]{"1202121744081479","4024007142161479"},
	new String[]{"7606523615530859","4929650335340859"},
	new String[]{"1800208707033383","4556767985953383"},
	new String[]{"8803466043489901","4485721517539901"},
	new String[]{"3470360616623408","4700635280923408"},
	new String[]{"3448871135064819","4485052844834819"},
	new String[]{"3643401312746722","4485998119526722"},
	new String[]{"8424445847727483","4138754188207483"},
	new String[]{"7404262841662511","4556552625522511"},
	new String[]{"6801362581503372","4539619648353372"},
	new String[]{"4727860411058998","4517289653468998"},
	new String[]{"8361236108340589","4929105479810589"},
	new String[]{"5585504728786265","4916847550676265"},
	new String[]{"2484640540074398","4532502180734398"});
			
		
	          

}