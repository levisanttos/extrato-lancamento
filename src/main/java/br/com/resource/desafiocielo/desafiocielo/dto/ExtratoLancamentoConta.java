package br.com.resource.desafiocielo.desafiocielo.dto;

import java.math.BigDecimal;

public class ExtratoLancamentoConta {
	
	private String dataLancamento;
	
	private String descricao;
	
	private String numero;
	
	private String situacao;
	
	private String dataConfirmacao;
	
	private String dadosBancarios;
	
	private BigDecimal valoFinal;

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(String dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public String getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(String dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public BigDecimal getValoFinal() {
		return valoFinal;
	}

	public void setValoFinal(BigDecimal valoFinal) {
		this.valoFinal = valoFinal;
	}

}
