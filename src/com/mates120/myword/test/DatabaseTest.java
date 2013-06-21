package com.mates120.myword.test;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.test.AndroidTestCase;

import com.mates120.myword.Dictionary;
import com.mates120.myword.DictionaryManager;
import com.mates120.myword.Word;


public class DatabaseTest extends AndroidTestCase {
	private DictionaryManager dictionaryManager;

	protected static void setUpBeforeClass() throws Exception {
	}

	protected void setUp(){
		dictionaryManager = new DictionaryManager(getContext());
	}
	
	public void test1DictionaryAdd(){
		System.out.println("TEST: ADD DICTIONARY1 (test1Dict)");
		Dictionary testDictionary = new Dictionary("test1Dict");
		List <String> testWord1Values = new ArrayList<String>();
		testWord1Values.add("d1w1value1");
		testWord1Values.add("d1w1value2");
		testWord1Values.add("d1w1value3");
		testDictionary.addWord("d1source1unique", testWord1Values);
		List <String> testWord2Values = new ArrayList<String>();
		testWord2Values.add("d1w2value1");
		testWord2Values.add("d1w2value2");
		testWord2Values.add("d1w2value3");
		testDictionary.addWord("source2everywhere", testWord2Values);
		List <String> testWord3Values = new ArrayList<String>();
		testWord3Values.add("d1w3value1");
		testWord3Values.add("d1w3value2");
		testWord3Values.add("d1w3value3");
		testDictionary.addWord("d1source3unique", testWord3Values);
		dictionaryManager.addDictionary(testDictionary);
	}
	
	public void test2DictionaryAdd(){
		System.out.println("TEST: ADD DICTIONARY2 (test2Dict)");
		Dictionary testDictionary = new Dictionary("test2Dict");
		List <String> testWord1Values = new ArrayList<String>();
		testWord1Values.add("d2w1value1");
		testWord1Values.add("d2w1value2");
		testWord1Values.add("d2w1value3");
		testDictionary.addWord("d2source1unique", testWord1Values);
		List <String> testWord2Values = new ArrayList<String>();
		testWord2Values.add("d2w2value1");
		testWord2Values.add("d2w2value2");
		testWord2Values.add("d2w2value3");
		testDictionary.addWord("source2everywhere", testWord2Values);
		List <String> testWord3Values = new ArrayList<String>();
		testWord3Values.add("d2w3value1");
		testWord3Values.add("d2w3value2");
		testWord3Values.add("d2w3value3");
		testDictionary.addWord("d2source3unique", testWord3Values);
		dictionaryManager.addDictionary(testDictionary);
	}
	
	public void test1DictionaryDelete(){
		System.out.println("TEST: DELETE DICTIONARY1 (test1Dict)");
		dictionaryManager.deleteDictionary("test1Dict");
	}
	
	public void test1FindWord(){
		System.out.println("TEST: FIND EXISTING WORD");
		Word wordToFind = dictionaryManager.getWord("source2everywhere");
		System.out.println(wordToFind.getSource());
		for(int i = 0; i < wordToFind.getValues().size(); i++){
			System.out.println(wordToFind.getValue(i).getValue());
		}
	}

}
