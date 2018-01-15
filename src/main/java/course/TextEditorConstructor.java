package course;

public class TextEditorConstructor {
    private SpellChecker spellChecker;
    private String value;

    public TextEditorConstructor(SpellChecker spellChecker, String value) {
        System.out.println("Inside TextEditor constructor.");
        this.spellChecker = spellChecker;
        this.value = value;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Inside setSpellChecker");
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }

    public void getValue() {
        System.out.println("Value from bean: " + value);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
