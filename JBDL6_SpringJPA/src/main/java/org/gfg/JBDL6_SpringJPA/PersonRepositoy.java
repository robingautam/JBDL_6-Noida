package org.gfg.JBDL6_SpringJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoy extends JpaRepository<Person,Integer> {
}
