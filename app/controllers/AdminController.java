package controllers;

import java.util.List;

import javax.inject.Inject;

import autenticadores.AdminAutenticado;
import daos.ProdutoDAO;
import daos.UsuarioDAO;
import models.Produto;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.Security.Authenticated;
import play.mvc.*;
import views.html.*;

@Authenticated(AdminAutenticado.class)
public class AdminController extends Controller {
	 @Inject
	    private UsuarioDAO usuarioDAO;
	    @Inject
	    private ProdutoDAO produtoDAO;
	    public Result usuarios() {
	    	List<Usuario> listaDeUsuarios = usuarioDAO.todos();
	    	return ok(usuarios.render(listaDeUsuarios));
	    }
	    public Result produtos() {
	    	List<Produto>listaDeProdutos = produtoDAO.todos();
	        return ok(produtos.render(listaDeProdutos));
	    }
}
