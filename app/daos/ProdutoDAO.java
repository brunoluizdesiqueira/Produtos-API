package daos;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Finder;
import models.Produto;

public class ProdutoDAO {
	
	private Finder<Long, Produto> produtos = new Finder<>(Produto.class);
	
	public Optional<Produto> comCodigo(String codigo){
		Produto produto = produtos.query()
					.where()
					.eq("codigo", codigo)
					.findUnique();
		
		return Optional.ofNullable(produto);	
	}

	public List<Produto> todos() {	
		return produtos.all();
	}

	public List<Produto> doTipo(String tipo) {
		return produtos.query().
				where().
				eq("tipo", tipo).
				findList();
	}

	public List<Produto> comFiltros(Map<String, String> parametros) {
		ExpressionList<Produto> consulta = produtos.query().where();
		parametros.entrySet().forEach(entradas -> {
			consulta.eq(entradas.getKey(), entradas.getValue());
		});
		return consulta.findList();
	}

}
