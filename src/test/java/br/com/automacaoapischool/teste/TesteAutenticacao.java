package br.com.automacaoapischool.teste;

import org.junit.Test;
import com.google.gson.Gson;
import br.com.automacaoapischool.pojos.Login;
import br.com.automacaoapischool.pojos.Students;
import br.com.automacaoapischool.servicos.Resposta;
import br.com.automacaoapischool.servicos.ServicosImpl;

public class TesteAutenticacao {

	Login login = new Login();
	Students students = new Students();
	String token;
	Gson gson = new Gson();
	ServicosImpl verbos = new ServicosImpl();
	Resposta resposta;
	Resposta resposta2;

	@Test
	public void testeStudents() {
		login.setUsername("oda");
		login.setPassword("devdojo");
		String json = gson.toJson(login);
		resposta = verbos.postEndPoint("http://localhost:9090/login", json);
		token = resposta.getBody();
		students.setEmail("brunocarvalhodesa6@gmail.com");
		students.setName("Bruno Carvalho");
		String json2 = gson.toJson(students);
		resposta2 = verbos.postEndpointWithAuthorization("http://localhost:9090/v1/students", token, json2);
	}

}
