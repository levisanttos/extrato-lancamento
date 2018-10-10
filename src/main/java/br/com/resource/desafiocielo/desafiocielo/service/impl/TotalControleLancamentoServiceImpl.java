package br.com.resource.desafiocielo.desafiocielo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.resource.desafiocielo.desafiocielo.dto.ExtratoLancamentoConta;
import br.com.resource.desafiocielo.desafiocielo.dto.LancamentoContaLegado;
import br.com.resource.desafiocielo.desafiocielo.dto.ListaControleLancamento;
import br.com.resource.desafiocielo.desafiocielo.repository.TotalControleLancamentoRepository;
import br.com.resource.desafiocielo.desafiocielo.service.TotalControleLancamentoService;
import br.com.resource.desafiocielo.desafiocielo.util.DataUtil;

@Service
public class TotalControleLancamentoServiceImpl implements TotalControleLancamentoService {

	@Autowired
	private TotalControleLancamentoRepository totalControleLancamentoRepository;

	@Override
	public List<ExtratoLancamentoConta> getExtratoLancamentoConta() {
		
		LancamentoContaLegado lancamentoContaLegado = this.totalControleLancamentoRepository.getLancamentoContaLegado();
		
		List<ExtratoLancamentoConta> extratos = geraExtraLancamento(lancamentoContaLegado);
		
		return extratos;
	}

	private List<ExtratoLancamentoConta> geraExtraLancamento(LancamentoContaLegado lancamentoContaLegado) {
		
		
		
		List<ExtratoLancamentoConta> extratos = new ArrayList<>();
		
		for (ListaControleLancamento listaControleLancamento : lancamentoContaLegado.getListaControleLancamento()) {
			StringBuilder dadosBancarios = new StringBuilder();
			ExtratoLancamentoConta extratoLancamentoConta = new ExtratoLancamentoConta();
			
			String dataLancamento = DataUtil.converteCalendarParaString(listaControleLancamento.getDateLancamentoContaCorrenteCliente());
			String dataConfirmacao = DataUtil.converteCalendarParaString(listaControleLancamento.getDateEfetivaLancamento());
			
			extratoLancamentoConta.setDataLancamento(dataLancamento);
			extratoLancamentoConta.setDataConfirmacao(dataConfirmacao);
			extratoLancamentoConta.setDescricao(listaControleLancamento.getLancamentoContaCorrenteCliente().getNomeTipoOperacao());
			
			dadosBancarios.append(listaControleLancamento.getNomeBanco().trim());
			dadosBancarios.append(" Ag ");
			dadosBancarios.append(listaControleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia());
			dadosBancarios.append(" CC ");
			dadosBancarios.append(listaControleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente());
			extratoLancamentoConta.setDadosBancarios(dadosBancarios.toString());
			
			extratoLancamentoConta.setSituacao(listaControleLancamento.getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
			
			extratoLancamentoConta.setNumero(listaControleLancamento.getNumeroRaizCNPJ() + lancamentoContaLegado.getListaControleLancamento().get(0).getNumeroSufixoCNPJ());
			
			extratoLancamentoConta.setValoFinal(listaControleLancamento.getValorLancamentoRemessa());
			
			extratos.add(extratoLancamentoConta);
		}
		
		
		return extratos;
	}
	

}
