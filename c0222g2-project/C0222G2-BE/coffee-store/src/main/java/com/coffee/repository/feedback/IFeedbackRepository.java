package com.coffee.repository.feedback;

import com.coffee.model.feedback.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;

@Transactional
@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

    /**
     * Created by: DiepTT
     * Date created: 09/08/2022
     * Function: Create feedback (User send feedback)
     */
    @Modifying
    @Query(value = " insert into feedback (code, feedback_date, creator, email, content, rating, image) " +
            " values (:code, :feedback_date, :creator, :email, :content, :rating, :image) ",
            nativeQuery = true)
    void saveFeedback(@Param("code") String code, @Param("feedback_date") Date date, @Param("creator") String creator,
                      @Param("email") String email, @Param("content") String content, @Param("rating") int rating,
                      @Param("image") String image);

    @Query(value = "select max(id) from feedback ", nativeQuery = true)
    Integer findLastFeedbackId();

    /**
     * Created by : LuanTV
     * Date created: 09/08/2022
     * Function:  page , search
     *
     * @param pageable
     * @param creator
     * @param startDate
     * @param endDate
     * @return
     */
    @Query(value = " select feedback.id, feedback.code, feedback.content, feedback.creator, feedback.email,  " +
            " feedback.feedback_date, feedback.image, feedback.rating, feedback.is_deleted  " +
            " from feedback where feedback.creator like :creator and (feedback.feedback_date between :startDate and :endDate) and feedback.is_deleted = 0 ", nativeQuery = true,
            countQuery = " select count(*) from (select feedback.id, feedback.code, feedback.content, feedback.creator, feedback.email,  " +
                    " feedback.feedback_date, feedback.image, feedback.rating, feedback.is_deleted  " +
                    " from feedback where feedback.creator like :creator and (feedback.feedback_date between :startDate and :endDate) and feedback.is_deleted = 0 ) feedback")
    Page<Feedback> findAllFeedback(Pageable pageable,
                                   @Param("creator") String creator, String startDate, String endDate);

    /**
     * Created by : LuanTV
     * Date created: 09/08/2022
     * Function: find by id feedback
     *
     * @param id
     * @return
     */
    @Query(value = " select feedback.id, feedback.code, feedback.content, feedback.creator, feedback.email,  " +
            " feedback.feedback_date, feedback.image, feedback.rating, feedback.is_deleted  " +
            " from feedback where feedback.id =:idDetail and feedback.is_deleted = 0 ", nativeQuery = true)
    Optional<Feedback> findFeedbackById(@Param("idDetail") int id);
}
