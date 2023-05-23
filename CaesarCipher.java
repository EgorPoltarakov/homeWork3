import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {
    public static void main(String[] args) {
        String encryptedText = "Gur synt vf gur pnpur bs gur pbyyrtr";
        Map<Character, Integer> frequencyMap = getFrequencyMap();

        Map<Character, Integer> encryptedFrequencyMap = new HashMap<>();
        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                encryptedFrequencyMap.put(c, encryptedFrequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        char mostFrequentEncryptedChar = getMostFrequentChar(encryptedFrequencyMap);
        char mostFrequentChar = getMostFrequentChar(frequencyMap);

        int shift = mostFrequentEncryptedChar - mostFrequentChar;
        if (shift < 0) {
            shift += 26;
        }

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println(decryptedText);
    }

    private static Map<Character, Integer> getFrequencyMap() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi. Proin porttitor, orci nec nonummy molestie, enim est eleifend mi, non fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa, scelerisque vitae, consequat in, pretium a, enim. Pellentesque congue. Ut in risus volutpat libero pharetra tempor. Cras vestibulum bibendum augue. Praesent egestas leo in pede. Praesent blandit odio eu enim. Pellentesque sed dui ut augue blandit sodales. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam nibh. Mauris ac mauris sed pede pellentesque fermentum. Maecenas adipiscing ante non diam sodales hendrerit.";
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }
        return frequencyMap;
    }

    private static char getMostFrequentChar(Map<Character, Integer> frequencyMap) {
        char mostFrequentChar = 'a';
        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentChar = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return mostFrequentChar;
    }

    private static String decrypt(String encryptedText, int shift) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (c - shift);
                if (shiftedChar < 'a') {
                    shiftedChar += 26;
                }
                decryptedText.append(shiftedChar);
            } else {
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }
}