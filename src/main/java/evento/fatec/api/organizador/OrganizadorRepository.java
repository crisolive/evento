package evento.fatec.api.organizador;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {

	//Page<Organizador> findAllByAtivoTrue(Pageable paginacao);
}
