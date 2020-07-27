package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.helpers;

public class Pipeline<I, O> {
    private final Step<I, O> currentStep;

    public Pipeline(Step<I, O> step) {
        this.currentStep = step;
    }

    public <NewO> Pipeline<I, NewO> pipe(Step<O, NewO> nextStep) {
        return new Pipeline<I, NewO>(input -> nextStep.process(currentStep.process(input)));
    }

    public O process(I input) throws Step.StepException {
        return currentStep.process(input);
    }

}
