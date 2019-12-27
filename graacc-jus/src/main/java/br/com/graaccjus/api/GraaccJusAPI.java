package br.com.graaccjus.api;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.graaccjus.controller.GraaccJusController;
import br.com.graaccjus.entity.GraaccJusEntity;
import br.com.graaccjus.util.ErrorDetail;

/**
 * Classe responsavel por receber todas as solicitações rest 
 * disponibiliza as APIs rest
 */
@RestController
public class GraaccJusAPI {

	/**
	 * Realiza chamada para a pagina do paypal na doação de 15 reais
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/pay15")
	public String pay15() throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		String pay15="https://www.paypal.com/donate/?token=GmHOJDdRcFI0LDGL-lH-_Y1iLkbz_bVW65MBNtinzGQAlhBP5HOqeMnlhBRTKGelpXGSyW&country.x=BR&locale.x=BR";
		ResponseEntity<String> response = restTemplate.getForEntity(pay15 , String.class);
		return response.getBody();

	}
	
	/**
	 * Realiza chamada para a pagina do paypal na doação de 35 reais
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/pay35")
	public ResponseEntity<?> pay35() throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.paypal.com/donate/?token=fk2Q_5b66XXCC8WLJ1q5Eu3YM23Qj5zo5-jvdHmGfILCX_m9cDADxqj-VIrkansrsTuXom&country.x=BR&locale.x=BR" , String.class);
		return response;

	}

	/**
	 * Realiza chamada para a pagina do paypal na doação de 50 reais
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/pay50")
	public ResponseEntity<?> pay50() throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.paypal.com/donate/?token=UODrRKtJgxomCPC97b4Hqpl3Gg-T5JzGL6XtfKJ8ue7tynPGMYQ7in7liiy52n1kUqz4xm&country.x=BR&locale.x=BR" , String.class);
		return response;

	}
	
	/**
	 * Efetua busca por processo, passando os seguintes paramtros
	 * Filter, StartDate e FinishDate
	 * @return
	 * @throws IOException
	 */
	@CrossOrigin
	@RequestMapping("/findprocess")
	public ResponseEntity<?> findProcess(@RequestParam String filter,@RequestParam String startDate, @RequestParam String finishDate) throws IOException {

		GraaccJusController graaccControler = new GraaccJusController();
		List<GraaccJusEntity> entity = graaccControler.getPageLinks("https://esaj.tjsp.jus.br/cjpg/pesquisar.do?conversationId=&dadosConsulta.pesquisaLivre="+filter+"&tipoNumero=SAJ&numeroDigitoAnoUnificado=&foroNumeroUnificado=&dadosConsulta.nuProcesso=&dadosConsulta.nuProcessoAntigo=&classeTreeSelection.values=&classeTreeSelection.text=&assuntoTreeSelection.values=&assuntoTreeSelection.text=&agenteSelectedEntitiesList=&contadoragente=0&contadorMaioragente=0&cdAgente=&nmAgente=&dadosConsulta.dtInicio="+startDate+"&dadosConsulta.dtFim="+finishDate+"&varasTreeSelection.values=&varasTreeSelection.text=&dadosConsulta.ordenacao=DESC");
		return ResponseEntity.ok(entity);

	}
	
	/**
	 * trata todos os erros da API, que seja referente a API REST
	 * Filter, StartDate e FinishDate
	 * @return
	 * @throws IOException
	 */
	  @ExceptionHandler(MissingServletRequestParameterException.class)
	    public ResponseEntity<?> handleResourceNotFoundException(MissingServletRequestParameterException rnfe,
	            HttpServletRequest request) {

	        ErrorDetail errorDetail = new ErrorDetail();
	        errorDetail.setTimeStamp(new Date().getTime());
	        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
	        errorDetail.setTitle("Recurso não encontrado.");
	        errorDetail.setDetail(rnfe.getMessage());
	        errorDetail.setDeveloperMessage(rnfe.getClass().getName());

	        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
	    }

}