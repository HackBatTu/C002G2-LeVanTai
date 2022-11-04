package com.coffee.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * Created by: DiepTT
 * Date created: 09/08/2022
 * Date updated: 10/08/2022
 * Function: Create feedback (User send feedback)
 */

public class FeedbackDto {

    @NotBlank(message = "Vui lòng nhập họ và tên.")
    @Pattern(regexp = "^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
            "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*" +
            "( )){0,14}([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
            "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*)$",
            message = "Vui lòng nhập họ và tên đúng định dạng" +
                    " (chỉ viết hoa chữ cái đầu mỗi từ, không chứa số và ký tự đặc biệt, không chứa khoảng trắng thừa, ...).")
    @Size(min = 2, max = 30, message = "Vui lòng nhập 2 - 30 ký tự.")
    private String creator;

    private String email;

    @NotBlank(message = "Vui lòng nhập nội dung phản hồi.")
    @Size(min = 2, message = "Vui lòng nhập từ 2 ký tự trở lên.")
    private String content;

    @NotNull(message = "Vui lòng đánh giá dịch vụ.")
    @Range(min = 1, max = 5, message = "Vui lòng đánh giá 1 - 5 sao.")
    private Integer rating;

    private String image;


    public FeedbackDto() {
    }

    public FeedbackDto(String creator, String email, String content, Integer rating, String image) {
        this.creator = creator;
        this.email = email;
        this.content = content;
        this.rating = rating;
        this.image = image;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
