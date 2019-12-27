package br.com.graaccjus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.graaccjus.entity.GraaccJusEntity;
import br.com.graaccjus.enums.HtmlProperties;

/**
 * Classe responsavel pela regra de negocio, que consulta as API do tribunal de justiça
 * @author bdecco
 *
 */
public class GraaccJusController {

	private HashSet<String> links;

	public GraaccJusController() {
		links = new HashSet<>();
	}

	/**
	 * Metodo que consulta a API que responde a lista de  processo
	 * @param URL
	 * @return
	 */
	public List<GraaccJusEntity> getPageLinks(String URL) {

		List<GraaccJusEntity> listGraacc = new ArrayList<>();
		if (!links.contains(URL)) {
			try {
		
				if (links.add(URL)) {
					System.out.println(URL);
				}

				Document document = Jsoup.connect(URL).get();
				Elements div = document.select(HtmlProperties.DIV.getDescription());
				Elements fonte =  div.select(HtmlProperties.TR.getDescription());
				Elements tr =  fonte.select(HtmlProperties.TD.getDescription());
				GraaccJusEntity graaccJusEntity = new GraaccJusEntity();

				for (Element page : tr) {

					graaccJusEntity = selectTypeAttr(page,graaccJusEntity,listGraacc);
				}
			} catch (IOException e) {
				System.err.println("For '" + URL + "': " + e.getMessage());
			}
		}
		return listGraacc;
	}

	/**
	 * Metodo que valida as posições de cada campo enivado pela API
	 * @param page
	 * @param graaccJusEntity
	 * @param listGraacc
	 * @return
	 */
	private GraaccJusEntity selectTypeAttr(Element page, GraaccJusEntity graaccJusEntity,List<GraaccJusEntity> listGraacc) {

		String type = page.text();
		String array[] = new String[1];
		array = type.split(":");

		switch (array[0]) {
		case "Classe":
			graaccJusEntity.setTypeClass(page.text());
			break;
		case "Assunto":
			graaccJusEntity.setSubject(page.text());
			break;
		case "Magistrado":
			graaccJusEntity.setJudge(page.text());
			break;
		case "Comarca":
			graaccJusEntity.setDistrict(page.text());
			break;
		case "Foro":
			graaccJusEntity.setForum(page.text());
			break;
		case "Vara":
			graaccJusEntity.setCourt(page.text());
			break;
		case "Data de Disponibilização":
			graaccJusEntity.setDateAvailability(page.text());
			break;
		default:
			if(array.length == 1) {
				graaccJusEntity.setIdprocess(page.text());
			}else {
				graaccJusEntity.setDescription(page.text());
				listGraacc.add(graaccJusEntity);
				graaccJusEntity = new GraaccJusEntity();
			}
			break;
		}
		return graaccJusEntity;
	}

}
