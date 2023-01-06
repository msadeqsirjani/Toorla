package name.analyser;

import assets.Program;

public interface INameAnalysingPass<T> {
    void analyse(Program program);
    T getResult();
}
