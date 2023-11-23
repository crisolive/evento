package evento.fatec.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import evento.fatec.api.area.AreaService;
import evento.fatec.api.artigo.Artigo;
import evento.fatec.api.artigo.ArtigoRepository;
import evento.fatec.api.artigo.DadosAtualizacaoArtigo;
import evento.fatec.api.artigo.DadosCadastroArtigo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/artigo")
public class ArtigoController {
	
	@Autowired
	private ArtigoRepository repository;
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping ("/formulario")                  
	public String carregaPaginaFormulario (Long id, Model model){ 
		model.addAttribute("areas", areaService.getAllArea());
		if(id != null) {
	        var artigo = repository.getReferenceById(id);
	        model.addAttribute("artigo", artigo);
	    }
	    return "artigo/formulario";              
	}     
	@GetMapping                                           
	public String carregaPaginaListagem (Model model){    
	    model.addAttribute("lista", repository.findAll());
	    return "artigo/listagem";                         
	} 

	@PostMapping
	@Transactional
	public String cadastrar ( @Valid DadosCadastroArtigo dados) {
		System.out.println("Passando POST " + dados.toString());
		repository.save(new Artigo(dados));
		return   "redirect:artigo";      
	}
	
	@PutMapping
	@Transactional
	public String atualizar (DadosAtualizacaoArtigo dados) {
		var artigo = repository.getReferenceById(dados.id());
		artigo.atualizarInformacoes(dados);
		return "redirect:artigo";  
	}
	
	@DeleteMapping
	@Transactional
	public String removeArea (Long id) {
		repository.deleteById (id);
		return "redirect:artigo";  
	}
	
}
