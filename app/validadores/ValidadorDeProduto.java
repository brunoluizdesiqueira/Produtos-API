package validadores;

import javax.inject.Inject;

import daos.ProdutoDAO;
import models.Produto;
import play.data.Form;
import play.data.validation.ValidationError;

public class ValidadorDeProduto {

	@Inject
	private ProdutoDAO produtoDAO;
	
	public Boolean temErros(Form<Produto> formulario) {
		Produto produto = formulario.get();
		
		if (produto.getPreco() < 0.00) {
			formulario.reject(new ValidationError("preco", "O preço do produto tem que ser maior ou igual a zero"));
		}
		
		if (produtoDAO.comCodigo(produto.getCodigo()).isPresent()) {
			formulario.reject(new ValidationError("codigo", "já existe um produto com esse código"));
		}
		
		return formulario.hasErrors();	
	}
}
