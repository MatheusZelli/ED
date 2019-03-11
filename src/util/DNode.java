package util;

public class DNode {
	private String element;
	private DNode previous;
	private DNode next;
	
	public DNode (String s, DNode p, DNode n) {
		element = s;
		previous = p;
		next = n;
	}
	
	public DNode (String element) {
		this (element, null, null);
	}
	
	//Retorna o elemento deste node
	public String getElement() {
	return element;
	}
	//Retorna a refer�ncia para o node anterior
	public DNode getPrevious() {
	return previous;
	}
	//Retorna a refer�ncia para o pr�ximo node
	public DNode getNext() {
	return next;
	}
	//Define o elemento deste node
	public void setElement(String newElem) {
	element = newElem;
	}
	//Define a refer�ncia para o node anterior
	public void setPrevious(DNode newPrevious) {
	previous = newPrevious;
	}
	//Define a refer�ncia para o pr�ximo node
	public void setNext(DNode newNext) {
	next = newNext;
	}
	
}
