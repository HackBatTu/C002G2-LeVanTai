package com.coffee.service.feedback;

import com.coffee.model.feedback.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFeedbackService {

    /**
     * Created by: DiepTT
     * Date created: 09/08/2022
     * Function: Create feedback (User send feedback)
     */
    void createFeedback(Feedback feedback);

    /**
     * Created by : LuanTV
     * Date created: 09/08/2022
     * Function: page section, search
     *
     * @param pageable
     * @param creator
     * @param startDate
     * @param endDate
     * @return
     */
    Page<Feedback> findAllFeedback(Pageable pageable, String creator, String startDate, String endDate);

    /**
     * Created by : LuanTV
     * Date created: 09/08/2022
     * Function: find by id feedback
     *
     * @param id
     * @return
     */
    Optional<Feedback> findFeedbackById(int id);
}
