package br.edu.ifce.odonto.model;

public class Mensagem {

	private String msg;
	private boolean success;

	public Mensagem(String msg,boolean success ){
		this.msg = msg;
		this.success = success;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}	
}
