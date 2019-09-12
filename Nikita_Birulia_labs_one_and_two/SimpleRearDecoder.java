package com.company;

public class SimpleRearDecoder {
    private String text;
    private int length;
    private char[] box;

    SimpleRearDecoder(String t) {
        text = t;
        length = makeLength();
        box = new char[length];
        fillEncodeBox();
    }

    private int makeLength() {
        return (int)Math.pow(Math.ceil(Math.sqrt((double)text.length())), 2);
    }

    private void fillEncodeBox() {
        int l = (int)Math.ceil(Math.sqrt((double)text.length()));
        for(int i = 0, temp = 0; i != l; i++) {
            for(int j = i; j < length; j  += l) {
                if(temp < text.length()) {
                    box[j] = text.charAt(temp++);
                } else {
                    box[j] = ' ';
                }
            }
        }
    }

    public String get() {
        String res = new String(box);
        return res;
    }
}
