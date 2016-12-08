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
package org.enjekt.panda.commons.utils;

import org.enjekt.panda.commons.utils.Utils;
import org.junit.Test;

public class RandomGeneratorTest {

	@Test
	public void generateRandom()
	{
		for (int i=0;i<100;i++){
		Utils.generatePad();
		}
	}
}
