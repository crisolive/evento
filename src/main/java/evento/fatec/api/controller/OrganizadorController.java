package evento.fatec.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import evento.fatec.api.organizador.Organizador;
import evento.fatec.api.organizador.OrganizadorRepository;
import evento.fatec.api.organizador.DadosAtualizacaoOrganizador;
import evento.fatec.api.organizador.DadosCadastroOrganizador;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/organizador")
public class OrganizadorController {
	
	@Autowired
	private OrganizadorRepository repository;
	
	@GetMapping ("/formulario")                  
	public String carregaPaginaFormulario (Long id, Model model){ 
		if(id != null) {
	        var organizador = repository.getReferenceById(id);
	        model.addAttribute("organizador", organizador);
	    }
	    return "organizador/formulario";              
	}     
	@GetMapping                                           
	public String carregaPaginaListagem (Model model){    
	    model.addAttribute("lista", repository.findAll());
	    return "organizador/listagem";                         
	} 

	@PostMapping
	@Transactional
	public String cadastrar ( @Valid DadosCadastroOrganizador dados) {
		repository.save(new Organizador(dados));
		return "redirect:organizador";      
	}
	
	@DeleteMapping
	@Transactional
	public String removeOrganizador (Long id) {
		repository.deleteById (id);
		return "redirect:organizador";  
	}
	
	@PutMapping
	@Transactional
	public String atualizar (DadosAtualizacaoOrganizador dados) {
		var organizador = repository.getReferenceById(dados.id());
		organizador.atualizarInformacoes(dados);
		return "redirect:organizador";  
	}

// Para teste com Insomnia	
//	public void cadastrar (@RequestBody @Valid DadosCadastroOrganizador dados) {
//		//System.out.println(dados);
//		repository.save(new Organizador(dados));
//	}
	
//	utilizado para pegar todos os dados
//	@GetMapping
//	public List<DadosListagemOrganizador> listar(){
//		return repository.findAll().stream().map(DadosListagemOrganizador:: new).toList();
//	}
	
//	@GetMapping
	//criar o record da listagem do organizador
	//	podemos devolver tudo, inclusive se tiver milhoes de linhas
//	public List<DadosListagemOrganizador> listar (){
//		return repository.findAll().stream().map(DadosListagemOrganizador:: new).toList();
//	}
//	@GetMapping
//	public Page<DadosListagemOrganizador> listar (@PageableDefault(size=5, sort= {"nome"}) Pageable paginacao){
//		return repository.findAll(paginacao).map(DadosListagemOrganizador:: new);
//	}
//	
	
//	@PutMapping
//	@Transactional
//	public void atualizar (@RequestBody @Valid DadosAtualizacaoOrganizador dados) {
//		var organizador = repository.getReferenceById(dados.id());
//		organizador.atualizarInformacoes(dados);
//	}
	
	
//	@DeleteMapping ("/{id}")
//	@Transactional
//	public void excluir (@PathVariable Long id) {
//		var organizador = repository.getReferenceById(id);
//		organizador.excluir();
//	}
}
