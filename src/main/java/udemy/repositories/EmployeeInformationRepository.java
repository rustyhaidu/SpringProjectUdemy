package udemy.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.entity.EmployeeInformation;

@Repository
@Qualifier(value = "EmployeeInformationRepository")
public interface EmployeeInformationRepository extends JpaRepository<EmployeeInformation, Long> {
    EmployeeInformation findByPk(final int pk);
}
