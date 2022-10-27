package shoponlineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shoponlineapi.enlity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
