public class Main {

    public static void main(String[] args) {

//        String[] input = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}; // result: 1,4,13
        String[] input = {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}; // result: 1,9,10
        //////////////////////
//        String[] input = {"1, a, 9, 10, 17, 18", "1, b, 9, 10"}; // e

        try {
            System.out.println(findIntersection(input));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String findIntersection(String[] strArr) throws NullPointerException, IllegalArgumentException {
        if (strArr == null) {
            throw new NullPointerException("Illegal input: null");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("Illegal input: no strings");
        }
        if (strArr.length > 2) {
            throw new IllegalArgumentException("Illegal argument: more than two strings");
        }

        String intersection =  "";

        if ((strArr[0] != "") && (strArr[1] != "")) {
            // convert strArr to numeric array
            String[][] elements = new String[2][];
            for (int i = 0; i < strArr.length; i++) {
                String[] element = strArr[i].split(", ");
                elements[i] = new String[element.length];
                for (int j = 0; j < element.length; j++) {
//                    try {
//                        int number = Integer.valueOf(element[j]);
//                    } catch (NumberFormatException e) {
//                        throw new NumberFormatException("Illegal input: not a number");
//                    }
                    elements[i][j] = element[j];
                }
            }

            for (int i = 0; i < elements[0].length; i++) {
                for (int j = 0; j < elements[1].length; j++) {
                    if (elements[0][i].equals(elements[1][j])) {
                        intersection = intersection + elements[0][i] + ",";
                    }
                }
            }

            // remove the last character from intersection (",")
            intersection = intersection.substring(0, intersection.length() - 1);
        }

        return intersection;
    }
}
