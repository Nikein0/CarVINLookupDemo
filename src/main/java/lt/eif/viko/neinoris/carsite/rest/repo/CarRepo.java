package lt.eif.viko.neinoris.carsite.rest.repo;
import lt.eif.viko.neinoris.carsite.rest.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CarRepo extends JpaRepository<Car, Long>{

}
