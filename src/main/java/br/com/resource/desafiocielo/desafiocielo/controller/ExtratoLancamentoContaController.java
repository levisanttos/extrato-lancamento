package br.com.resource.desafiocielo.desafiocielo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.resource.desafiocielo.desafiocielo.dto.ExtratoLancamentoConta;
import br.com.resource.desafiocielo.desafiocielo.service.TotalControleLancamentoService;

@RestController
@RequestMapping("/desafio-cielo/")
public class ExtratoLancamentoContaController {

	@Autowired
	private TotalControleLancamentoService totalControleLancamentoService;
	
	
	@GetMapping("extrato-lancamento")
	public ResponseEntity<List<ExtratoLancamentoConta>> getExtratoLancamento() {
		
		List<ExtratoLancamentoConta> extratos = this.totalControleLancamentoService.getExtratoLancamentoConta();
		
		return new ResponseEntity<>(extratos, HttpStatus.OK);
	}
}
