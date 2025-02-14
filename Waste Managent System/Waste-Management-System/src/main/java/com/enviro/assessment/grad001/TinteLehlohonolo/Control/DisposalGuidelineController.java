package com.enviro.assessment.grad001.TinteLehlohonolo.Control;

import com.enviro.assessment.grad001.TinteLehlohonolo.Model.DisposalGuideline;
import com.enviro.assessment.grad001.TinteLehlohonolo.Service.DisposalGuidelineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disposalGuidelines")
public class DisposalGuidelineController {
    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @PostMapping
    public DisposalGuideline addDisposalGuideline(@Valid @RequestBody DisposalGuideline disposalGuideline){
        return disposalGuidelineService.addDisposalGuideline(disposalGuideline);
    }

    @PutMapping("/{id}")
    public DisposalGuideline updateDisposalGuideline(@PathVariable Long id,@Valid @RequestBody DisposalGuideline disposalGuideline){
        return disposalGuidelineService.updateDisposalGuideline(id,disposalGuideline);
    }

    @GetMapping
    public List<DisposalGuideline>getAllDisposalGuideline(){
        return disposalGuidelineService.getAllDisposalGuidelines();
    }

    @GetMapping("/{id}")
    public DisposalGuideline getDisposalGuidelineById(@PathVariable Long id){
        return disposalGuidelineService.getDisposalGuidelineById(id);
    }

    @GetMapping("wasteCategory/{wasteCategoryId}")
    public List<DisposalGuideline>getDisposalGuidelinesByWasteCategoryById(@PathVariable Long wasteCategory_Id){
        return disposalGuidelineService.getDisposalGuidelineByWasteCategoryId(wasteCategory_Id);
    }

    @DeleteMapping("/{id}")
    public void deleteDisposalGuideline(@PathVariable Long id){
        disposalGuidelineService.deleteDisposalGuideline(id);
    }
}
