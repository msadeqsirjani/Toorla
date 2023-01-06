package assets;

import ananlyzer.errors.CompileErrorException;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class Tree {
	public int line;
	public int col;
	public List<CompileErrorException> relatedErrors = new ArrayList<>();

	public abstract <T> T accept(Visitor<T> visitor);

	public abstract String toString();
}