package com.coffee.controller;

import com.coffee.dto.FeedbackDto;
import com.coffee.model.feedback.Feedback;
import com.coffee.service.feedback.IFeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackRestController {

    @Autowired
    private IFeedbackService feedbackService;

    /**
     * Created by: DiepTT
     * Date created: 09/08/2022
     * Function: Create feedback (User send feedback)
     *
     * @param feedbackDto
     * @param bindingResult
     * @return feedback in the database
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createFeedback(
            @Validated @RequestBody FeedbackDto feedbackDto,
            BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        Feedback feedback = new Feedback();

        BeanUtils.copyProperties(feedbackDto, feedback);

        this.feedbackService.createFeedback(feedback);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Created by : LuanTV
     * Date created: 09/08/2022
     * Update: 10/08/2022
     * Function:  page section, search, sort
     * if page feedback "" : NO_CONTENT
     *
     * @param page
     * @param size
     * @param sort
     * @param searchCreator
     * @param searchStartDate
     * @param searchEndDate
     * @return Page<Feedback>
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/page")
    public ResponseEntity<Page<Feedback>> getAllFeedback(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam Optional<String> searchCreator,
            @RequestParam Optional<String> searchStartDate,
            @RequestParam Optional<String> searchEndDate) {

        Sort sortable ;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        } else if(!sort.equals("DESC")){
            sortable = Sort.by("rating").descending();
        }else {
            sortable = Sort.by("rating").ascending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        String creator = searchCreator.orElse("");
        String startDate = searchStartDate.orElse("1000-01-01");
        String endDate = searchEndDate.orElse("8000-01-01");
        Page<Feedback> feedbackPage = feedbackService.findAllFeedback(pageable, creator, startDate, endDate);
        if (feedbackPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(feedbackPage, HttpStatus.OK);
        }
    }

    /**
     * Created by : LuanTV
     * Date created: 09/08/2022
     * Function: find by id feedback
     * if id feedback null : NO_CONTENT
     *
     * @param id
     * @return Feedback
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable int id) {
        Optional<Feedback> feedback = feedbackService.findFeedbackById(id);
        if (!feedback.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(feedback.get(), HttpStatus.OK);
    }
}
