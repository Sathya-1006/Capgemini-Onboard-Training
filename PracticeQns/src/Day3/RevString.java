package Day3;


public class RevString {
	public static void main(String[] args) {
        String str = "Capgemini is awesome";

        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse())
                  .append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
