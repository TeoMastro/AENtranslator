package com.example.djkaandictionary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
    @Entity (tableName = "dictionary")
    public class Dictionary {
        @PrimaryKey(autoGenerate = true)
        private int wordID;

        @ColumnInfo (name = "word")
        private String word;

        @ColumnInfo (name = "meaning")
        private String meaning;

        public Dictionary(String word,String meaning){
            this.meaning=meaning;
            this.word=word;
        }

        public String getWord(){return word;}
        public String getMeaning(){return meaning;}
        public int getWordID(){return wordID;}

        public void setWordID(int wordID){this.wordID=wordID;}
        public void setWord(String word){this.word=word;}
        public void setMeaning(String meaning){this.meaning=meaning;}

}
