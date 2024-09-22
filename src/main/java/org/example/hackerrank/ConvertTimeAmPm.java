package org.example.hackerrank;

public class ConvertTimeAmPm {
    public static void main(String[] args) {
        String time = "07:05:45PM";
        System.out.println(convertTo24(time));
    }

    static String convertTo24(String s) {

        String hourStr = s.substring(0, 2);

        //am or pm
        String formatType = s.substring(8, 10);

        //minutes and seconds
        String constant = s.substring(2, 8);

        int hourInt = Integer.valueOf(hourStr);

        int convertedHour = formatType.equals("PM") ? hourInt + 12 : hourInt;
        convertedHour = convertedHour > 23 ? convertedHour - 24 : convertedHour;

        String finalHourStr = convertedHour > 9 ? convertedHour + "" : "0" + convertedHour;

        return finalHourStr + constant;
    }


}
