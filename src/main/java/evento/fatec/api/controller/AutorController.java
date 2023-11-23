package evento.fatec.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import evento.fatec.api.autor.Autor;
import evento.fatec.api.autor.AutorRepository;
import evento.fatec.api.autor.DadosAtualizacaoAutor;
import evento.fatec.api.autor.DadosCadastroAutor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@GetMapping ("/formulario")                  
	public String carregaPaginaFormulario (Long id, Model model){ 
		if(id != null) {
	        var autor = repository.getReferenceById(id);
	        model.addAttribute("autor", autor);
	    }
	    return "autor/formulario";              
	}     
	@GetMapping                                           
	public String carregaPaginaListagem (Model model){    
	    model.addAttribute("lista", repository.findAll());
	    return "autor/listagem";                         
	} 

	@PostMapping
	@Transactional
	public String cadastrar ( @Valid DadosCadastroAutor dados) {
		repository.save(new Autor(dados));
		return "redirect:autor";      
	}
	
	@DeleteMapping
	@Transactional
	public String removeOrganizador (Long id) {
		repository.deleteById (id);
		return "redirect:autor";  
	}
	
	@PutMapping
	@Transactional
	public String atualizar (DadosAtualizacaoAutor dados) {
		var autor = repository.getReferenceById(dados.id());
		autor.atualizarInformacoes(dados);
		return   "redirect:autor";  
	}
	

}

