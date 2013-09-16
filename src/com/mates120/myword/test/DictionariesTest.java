package com.mates120.myword.test;

import android.test.AndroidTestCase;

public class DictionariesTest extends AndroidTestCase {
	
	private TestBase tb;

	protected static void setUpBeforeClass() throws Exception {
	}

	protected void setUp(){
		tb = new TestBase(getContext());
	}
	
	public void testDictionary1Add(){
		System.out.println("TEST: ADD DICTIONARY (Dict1)");
		tb.addDictionary(1, 3, 1);
		assertTrue(tb.dictionaryExist(1));
		tb.deleteDictionary("Dict1");
		assertFalse(tb.dictionaryExist(1));
	}
	
	public void testDictionary10Add(){
		System.out.println("TEST: ADD 10 DICTIONARIES (Dict1, Dict2, ..., Dict10)");
		for (int i = 1; i <= 10; i++)
			tb.addDictionary(i, 3, 1);
		for (int i = 1; i <= 10; i++)
			assertTrue(tb.dictionaryExist(i));
		for (int i = 1; i <= 10; i++)
			tb.deleteDictionary("Dict" + i);
		for (int i = 1; i <= 10; i++)
			assertFalse(tb.dictionaryExist(i));
	}
}
