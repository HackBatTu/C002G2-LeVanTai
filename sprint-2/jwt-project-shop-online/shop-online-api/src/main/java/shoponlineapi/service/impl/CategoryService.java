package shoponlineapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoponlineapi.enlity.Category;
import shoponlineapi.repository.ICategoryRepository;
import shoponlineapi.service.ICategoryService;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }
}
