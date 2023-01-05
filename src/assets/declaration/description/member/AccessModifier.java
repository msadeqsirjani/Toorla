package assets.declaration.description.member;

public enum AccessModifier {
    PUBLIC, PRIVATE;

    @Override
    public String toString() {
        return "(" + super.toString() + ")";
    }
}
