package com.govt.panjabsecurity;

public class Guidelines_card {




        private int mImageResource;
        private String text;

        public Guidelines_card(int mImageResource, String text){
            this.mImageResource=mImageResource;
            this.text=text;
        }

        public int getmImageResource() {
            return mImageResource;
        }

        public String getText() {
            return text;
        }

        public void changeText(String text){
            this.text=text;
        }
    }



