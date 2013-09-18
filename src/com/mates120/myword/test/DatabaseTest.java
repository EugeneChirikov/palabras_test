package com.mates120.myword.test;

import com.mates120.myword.Word;

import android.test.AndroidTestCase;

public class DatabaseTest extends AndroidTestCase {
	private DataBaseTestUtils tb;
	
	protected static void setUpBeforeClass() throws Exception {
	}
	
	protected void setUp(){
		tb = new DataBaseTestUtils(getContext());
	}
	
	public void testDictionary1Add(){
		System.out.println("TEST: ADD/DEL DICTIONARY (Dict1)");
		tb.addDictionary(1, 3, 1);
		assertTrue(tb.dictionaryExist(1));
		tb.deleteDictionary("Dict1");
		assertFalse(tb.dictionaryExist(1));
	}
	
	public void testDictionary10Add(){
		System.out.println("TEST: ADD/DEL 10 DICTIONARIES (Dict1, Dict2, ..., Dict10)");
		for (int i = 1; i <= 10; i++)
			tb.addDictionary(i, 3, 1);
		for (int i = 1; i <= 10; i++)
			assertTrue(tb.dictionaryExist(i));
		for (int i = 1; i <= 10; i++)
			tb.deleteDictionary("Dict" + i);
		for (int i = 1; i <= 10; i++)
			assertFalse(tb.dictionaryExist(i));
	}
	
	public void testWordFind(){
		System.out.println("TEST: FIND COMMON WORD IN DICTIONARIES.");
		Word assertWord = tb.generateWord("source12", new int[]{1 ,2 ,3});
		for (int i = 1; i <= 3; i++)
			tb.addDictionary(i, 200, 12);
		Word foundWord = tb.getWordFromDB("source12");
		assertTrue(foundWord.equals(assertWord));
		assertEquals(tb.getWordFromDB("NoExist"), null);
		for (int i = 1; i <= 3; i++)
			tb.deleteDictionary("Dict" + i);
	}
	
	public void testStressDictionaries(){
		System.out.println("TEST: ADD 3 DICTS WITH 20k WORDS IN EACH DICT.");
		for (int i = 10; i <= 12; i++)
			tb.addDictionary(i, 20000, 42);
	}

}
