package com.enviro.assessment.grad001.TinteLehlohonolo.Control;

import com.enviro.assessment.grad001.TinteLehlohonolo.Model.WasteCategory;
import com.enviro.assessment.grad001.TinteLehlohonolo.Service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wasteCategory")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService wasteCategoryService;

    @PostMapping
    public WasteCategory addWasteCategory(@Valid @RequestBody WasteCategory wasteCategory){
        return wasteCategoryService.addWasteCategory(wasteCategory);
    }

    @PutMapping("/{id}")
    public WasteCategory updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategory){
        return wasteCategoryService.updateWasteCategory(id, wasteCategory);
    }

    @GetMapping
    public List<WasteCategory>getAllWasteCategory(){
        return wasteCategoryService.getAllWasteCategories();
    }

    @GetMapping("/{id}")
    public WasteCategory getWasteCategoryById(@PathVariable Long id){
        return wasteCategoryService.getWasteCategoryById(id);
    }

    @DeleteMapping("/{d}")
    public void deleteWasteCategory(@PathVariable Long id){
        wasteCategoryService.deleteWasteCategory(id);
    }
}
