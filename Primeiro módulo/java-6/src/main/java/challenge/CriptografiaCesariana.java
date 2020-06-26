package challenge;

public class CriptografiaCesariana implements Criptografia {
    public final int SHIFT = 3;

    @Override
    public String criptografar(final String texto) {
        validateInputText(texto);

        return rotateStringCharacters(texto, SHIFT);
    }

    @Override
    public String descriptografar(final String texto) {
        validateInputText(texto);

        return rotateStringCharacters(texto, -SHIFT);
    }

    private String rotateStringCharacters(final String text, final int displacementFactor){
        char[] characters = text.toLowerCase().toCharArray();
        int asciiDisplacement = 97 - displacementFactor;
        String result = "";

        for (char character : characters) {
            if (character < 97 | character > 122)
                result += character;
            else{
                char newLetter = (char) ((character - asciiDisplacement) % 26 + 97);
                result += newLetter;
            }
        }
        return result;
    }

    private void validateInputText(final String text){
        if(text == null)
            throw new NullPointerException("O texto não pode ser nulo.");
        else if(text == "")
            throw new IllegalArgumentException("O texto não pode ser vázio.");
    }
}
