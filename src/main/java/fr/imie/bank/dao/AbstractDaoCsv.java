package fr.imie.bank.dao;

public abstract class AbstractDaoCsv<T> {

	protected abstract T toObject(String text);

	protected abstract String toString(T entity);

}
