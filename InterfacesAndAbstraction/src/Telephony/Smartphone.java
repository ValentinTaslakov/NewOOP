package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sr = new StringBuilder();

        for (String url : urls) {

            boolean isValid = true;

            for (char s : url.toCharArray()) {

                if (Character.isDigit(s)) {

                    isValid = false;
                    break;
                }
            }
            if (isValid) {

                sr.append("Browsing: " + url + "!").append(System.lineSeparator());
            } else {

                sr.append("Invalid URL!").append(System.lineSeparator());
            }
        }

        return sr.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sr = new StringBuilder();

        for (String number : numbers) {

            boolean isValid = true;

            for (char s : number.toCharArray()) {

                if (!Character.isDigit(s)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {

                sr.append("Calling... " + number).append(System.lineSeparator());
            } else {

                sr.append("Invalid number!").append(System.lineSeparator());
            }
        }

        return sr.toString().trim();
    }
}
