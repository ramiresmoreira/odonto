package br.edu.ifce.odonto.model;

public class Mensagem {

	private String msg;
	private boolean success;

	public Mensagem(String msg,boolean success ){
		this.msg = msg;
		this.success = success;
	}
	
	public String getMsg() {
		return msg;
	}

	public boolean isSuccess() {
		return success;
	}
}
