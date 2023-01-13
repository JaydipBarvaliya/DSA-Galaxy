package com.stackoverflow;

/* package whatever; // don't place package name! */

class StringCountAndChange {

    public static void main(String[] args) {
        String s = "sagar";

        String h = "jaydip";
        System.out.println(s.length() + h.length());

        StringBuffer sagarBuffer = new StringBuffer(s);
        if (sagarBuffer.charAt(0) >= 97 && sagarBuffer.charAt(0) <= 122) {
            sagarBuffer.setCharAt(0, (char) (sagarBuffer.charAt(0) - 32));
        }
        System.out.println(sagarBuffer.toString());

        StringBuffer jaydipBuffer = new StringBuffer(h);
        if (jaydipBuffer.charAt(0) >= 97 && jaydipBuffer.charAt(0) <= 122) {
            jaydipBuffer.setCharAt(0, (char) (jaydipBuffer.charAt(0) - 32));
        }
        System.out.println(jaydipBuffer.toString());
    }


}