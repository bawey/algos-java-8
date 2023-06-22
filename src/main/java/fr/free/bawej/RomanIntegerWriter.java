package fr.free.bawej;

public class RomanIntegerWriter {


    public String intToRoman(int num) {
        return digitToRoman(num / 1000, 'M', '_', '_')
                + digitToRoman((num % 1000) / 100, 'C', 'D', 'M')
                + digitToRoman((num % 100) / 10, 'X', 'L', 'C')
                + digitToRoman((num % 10), 'I', 'V', 'X');
    }

    private String digitToRoman(int number, char one, char five, char ten) {
        switch (number) {
            case 9:
                return new String(new char[]{one, ten});
            case 8:
                return new String(new char[]{five, one, one, one});
            case 7:
                return new String(new char[]{five, one, one});
            case 6:
                return new String(new char[]{five, one});
            case 5:
                return new String(new char[]{five});
            case 4:
                return new String(new char[]{one, five});
            case 3:
                return new String(new char[]{one, one, one});
            case 2:
                return new String(new char[]{one, one});
            case 1:
                return new String(new char[]{one});
            case 0:
                return new String("");
        }
        throw new IllegalArgumentException("not a 0-9 number: " + number);
    }
}
