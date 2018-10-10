package br.com.resource.desafiocielo.desafiocielo.repository.impl;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.resource.desafiocielo.desafiocielo.dto.LancamentoContaLegado;
import br.com.resource.desafiocielo.desafiocielo.repository.TotalControleLancamentoRepository;

@Repository
public class TotalControleLancamentoRepositoryImpl implements TotalControleLancamentoRepository {

	private static final Logger LOGGER = LogManager.getLogger(TotalControleLancamentoRepositoryImpl.class);

	@Override
	public LancamentoContaLegado getLancamentoContaLegado() {

		ObjectMapper mapper = new ObjectMapper();
		LancamentoContaLegado lancamentoContaLegado = null;
		
		try {
			LOGGER.info("Lendo arquivo: lancamento-conta-legado.json");
			lancamentoContaLegado = mapper.readValue(new File("lancamento-conta-legado.json"),
					LancamentoContaLegado.class);
		} catch (JsonParseException e) {
			LOGGER.error("Erro ao fazer o parse");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			LOGGER.error("Erro no mapeamento do JSON");
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.error("Arquivo não encontrado");
			e.printStackTrace();
		}
		
		return lancamentoContaLegado;
	}

}
