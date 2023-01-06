package ananlyzer;

import assets.Program;

public interface INameAnalyzingPass<T> {
    void analyze(Program program);

    T getResult();

}