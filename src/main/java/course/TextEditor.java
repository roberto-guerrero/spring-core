package course;

public class TextEditor {
    private SpellChecker spellChecker;
    private String value;

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
