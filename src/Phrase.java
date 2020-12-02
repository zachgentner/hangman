public class Phrase {

    private String originalPhrase;
    private String updatedPhrase;

    public Phrase(String phrase) {
        originalPhrase = phrase;
        hidePhrase();
    }

    public String getOriginalPhrase() {
        return originalPhrase;
    }

    public String getUpdatedPhrase(){
        return updatedPhrase;
    }

    private void hidePhrase() {
        char[] phraseChars = originalPhrase.toCharArray();
        for (int i = 0; i < originalPhrase.length(); i++) {
            if (phraseChars[i] != ' ') {
                phraseChars[i] = '*';
            }
        }
        updatedPhrase = String.valueOf(phraseChars);
    }

    public boolean containsLetter(char letter){
        for(int i = 0; i < originalPhrase.length(); i++){
            if(originalPhrase.charAt(i) == letter){
                revealLetter(letter);
                return true;
            }
        }
        return false;
    }

    public void revealLetter(char guessedLetter){
        char[] updatedChars = updatedPhrase.toCharArray();//Turns the updated phrase into a char string.

        for(int i = 0; i < originalPhrase.length(); i++){
            if(originalPhrase.charAt(i) == guessedLetter){
                updatedChars[i] = originalPhrase.charAt(i);
            }
        }
        updatedPhrase = String.valueOf(updatedChars);
    }


}
