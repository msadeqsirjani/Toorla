package assets.declarations.classes.members;

import visitor.Visitor;

public interface ClassMemberDeclaration {
    <T> T accept(Visitor<T> visitor);

    String toString();

}