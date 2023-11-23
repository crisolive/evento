package evento.fatec.api.artigo;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

	//Page<Organizador> findAllByAtivoTrue(Pageable paginacao);
}
