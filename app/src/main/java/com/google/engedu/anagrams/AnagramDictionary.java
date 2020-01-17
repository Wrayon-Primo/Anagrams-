/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    ArrayList<String> wordList = new ArrayList<String>();
    HashSet<String> wordSet = new HashSet<String>();
    HashMap<String, ArrayList <String>> lettersToWord = new HashMap<String, ArrayList <String>>(); // this is the constructor of the anagram dictionary

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);
            wordSet.add(word);

            String sortedWord = sortLetters(word);
            // Method to sort a string alphabetically


            if (lettersToWord.containsKey(sortedWord)) {
                lettersToWord.get(sortedWord).add(word);
            }
            else
            {
                ArrayList<String>anagrams = new ArrayList<String>();
                anagrams.add(word);
                lettersToWord.put(sortedWord, anagrams);
            }


        }
        Log.d("Wrayon", String.format("Hi there %d", wordList.size ()));
        Log.d("Wrayon", String.format("Hello World %d", wordSet.size ()));
        Log.d("Wrayon", String.format("Hey %d", lettersToWord.size ()));
    }

    public boolean isGoodWord(String word, String base) {
       Log.d("Wrayon", "Wrayon");
        return true;
    }

    public static String sortLetters(String word)
    {
        // convert input string to char array
        char tempArray[] = word.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    public List<String> getAnagrams (String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public List<String> getAnagramsWithOneMoreLetter(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        Log.d("Wrayon", String.format("I Am Looking For Anagrams: %s", targetWord));
        for (String currentWord: wordList)              //finds the anagram
        {

             currentWord = currentWord.toLowerCase();   // converts the currentword to lovercase
             targetWord = targetWord.toLowerCase();     // converts the targetword to lovercase

             String sortedVersionOfCurrentWord = sortLetters(currentWord); //sorts current word and returns a new variable that will be added to values.
             String sortedVersionOfTargetWord = sortLetters(targetWord); //sorts target word and returns a new variable that will be added to values.

             if (sortedVersionOfCurrentWord.equals(sortedVersionOfTargetWord)) {            //checks if the currentword matches the targetword. That means that current m

                 Log.d("Wrayon", String.format("We Are Adding To The List: %s", currentWord));
                 result.add(currentWord);
             }                 //adds the new anagram which is currentword to the list that we are going to return from this function
        }



        return result;
    }


    public String pickGoodStarterWord() {
        return "stop";
    }
}
