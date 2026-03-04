package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer>{
    List<Schedule> findByJudgeIdAndAvailability(Integer judgeId,Boolean availability);
}
