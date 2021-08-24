package choi.seowon.board.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import choi.seowon.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
