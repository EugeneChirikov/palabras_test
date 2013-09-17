package com.mates120.myword.test;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.mates120.myword.Dictionary;
import com.mates120.myword.DictionaryManager;
import com.mates120.myword.Value;
import com.mates120.myword.Word;

public class DataBaseTestUtils {
	private DictionaryManager dictionaryManager;
	
	public DataBaseTestUtils(Context context){
		dictionaryManager = new DictionaryManager(context);
	}
	
	public boolean dictionaryExist(int index){
		boolean exist = false;
		String dictName = "Dict" + index;
		List<Dictionary> allDicts = dictionaryManager.getDictionaries();
		for(Dictionary dict: allDicts){
			if(dict.getName().equals(dictName))
				exist = true;
		}
		return exist;
	}
	
	public void addDictionary(int index, int wordsCount, int commonWordIndex){
		System.out.println("ADD DICTIONARY: Dict" + index);
		String dictName = "Dict" + index;
		Dictionary testDictionary = new Dictionary(dictName);
		String wordToAdd;
		for (int i = 1; i <= wordsCount; i++){
			List <String> testWordValues = new ArrayList<String>();
			for(int x = 1; x < 4; x++)
				testWordValues.add("d" + index + "w" + i + "value" + x);
			if(i != commonWordIndex)
				wordToAdd = "d" + index +"source" + i;
			else
				wordToAdd = "source" + i;
			testDictionary.addWord(wordToAdd, testWordValues);
		}
		dictionaryManager.addDictionary(testDictionary);
	}
	
	public void deleteDictionary(String dictName){
		dictionaryManager.deleteDictionary(dictName);
	}
	
	public Word generateWord(String source, int[] dictsIndexes){
		Word genWord = new Word(source);
		int wordIndex = Integer.valueOf(source.split("source")[1]);
		List<Value> values = new ArrayList<Value>();
		for (int i = 0; i < dictsIndexes.length; i++)
			for (int j = 1; j <= 3; j ++)
				values.add(new Value("d" + dictsIndexes[i] + "w" + wordIndex + "value" + j,
						"Dict" + dictsIndexes[i]));
		genWord.setValues(values);
		return genWord;
	}
	
	public Word getWordFromDB(String source){
		return dictionaryManager.getWord(source);
	}
}
