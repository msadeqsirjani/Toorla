package assets.declarations.classes.members;

public enum AccessModifier {
    PUBLIC, PRIVATE;

    @Override
    public String toString() {
        return "(" + super.toString() + ")";
    }
}
