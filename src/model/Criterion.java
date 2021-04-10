package model;

public interface Criterion<T>
{
    public boolean isSatisfiedBy(T c);
}
