package evento.fatec.api.artigo;

import java.time.LocalDate;

public record DadosListagemArtigo(
	Long id,
	String titulo, 
	String resumo, 
	String keyWord1,
	String keyWord2,
	String keyWord3,
	Long areaId,
	LocalDate dataSubmissao)
	{
	public DadosListagemArtigo (Artigo artigo) {
	this(artigo.getId(),
		 artigo.getTitulo(),
		 artigo.getResumo(),
		 artigo.getKeyWord1(),
		 artigo.getKeyWord2(),
		 artigo.getKeyWord3(),
		 artigo.getArea().getId(),
		 artigo.getDataSubmissao()); 
	}
}
