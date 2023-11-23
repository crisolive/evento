package evento.fatec.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import evento.fatec.api.area.Area;
import evento.fatec.api.area.AreaRepository;
import evento.fatec.api.area.DadosAtualizacaoArea;
import evento.fatec.api.area.DadosCadastroArea;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/area")
public class AreaController {
	
	@Autowired
	private AreaRepository repository;
	
	@GetMapping ("/formulario")                  
	public String carregaPaginaFormulario (Long id, Model model){ 
		if(id != null) {
	        var area = repository.getReferenceById(id);
	        model.addAttribute("area", area);
	    }
	    return "area/formulario";              
	}     
	@GetMapping                                           
	public String carregaPaginaListagem (Model model){    
	    model.addAttribute("lista", repository.findAll());
	    return "area/listagem";                         
	} 

	@PostMapping
	@Transactional
	public String cadastrar ( @Valid DadosCadastroArea dados) {
		repository.save(new Area(dados));
		return   "redirect:area";      
	}
	
	@PutMapping
	@Transactional
	public String atualizar (DadosAtualizacaoArea dados) {
		var area = repository.getReferenceById(dados.id());
		area.atualizarInformacoes(dados);
		return "redirect:area";  
	}
	
	@DeleteMapping
	@Transactional
	public String removeArea (Long id) {
		repository.deleteById (id);
		return "redirect:area";  
	}
	
}
