package assets.declaration.description.member;

import visitor.Visitor;

public interface ClassMemberDeclaration {
    <T> T accept(Visitor<T> visitor);
    String toString();
}
