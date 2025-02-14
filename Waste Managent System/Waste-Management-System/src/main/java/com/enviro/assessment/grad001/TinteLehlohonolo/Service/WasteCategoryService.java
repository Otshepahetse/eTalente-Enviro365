package com.enviro.assessment.grad001.TinteLehlohonolo.Service;

import com.enviro.assessment.grad001.TinteLehlohonolo.Model.WasteCategory;
import com.enviro.assessment.grad001.TinteLehlohonolo.Repository.WasteCategoryRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.*;

import java.util.List;

@Validated
@Service
public class WasteCategoryService {
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public WasteCategory addWasteCategory(@Valid @NotNull WasteCategory wasteCategory){
        return wasteCategoryRepository.save(wasteCategory);
    }

    public List<WasteCategory>getAllWasteCategories(){
        return  wasteCategoryRepository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long id){
        return wasteCategoryRepository.findById(id).orElseThrow(()->new RuntimeException("Waste Category was not fount with ID: "+ id));
    }

    public WasteCategory updateWasteCategory(Long id, @Valid @NotNull WasteCategory updatedWasteCategory){
        WasteCategory existingCategory = wasteCategoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Waste Category was not found with ID: "+id));

        existingCategory.setWasteCategory(existingCategory.getWasteCategory());
        existingCategory.setWasteItem(updatedWasteCategory.getWasteItem());
        existingCategory.setWasteDescription(existingCategory.getWasteDescription());

        return wasteCategoryRepository.save(existingCategory);
    }

    public void deleteWasteCategory(Long id){
        wasteCategoryRepository.deleteById(id);
    }

}
