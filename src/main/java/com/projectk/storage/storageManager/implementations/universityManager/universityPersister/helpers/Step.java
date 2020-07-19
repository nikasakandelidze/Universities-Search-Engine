package com.projectk.storage.storageManager.implementations.universityManager.universityPersister.helpers;

public interface Step<I,O> {
    public static class StepException extends Exception{
        public StepException(Throwable throwable){
            super(throwable);
        }
    }

    public O process(I input) throws  StepException;
}

